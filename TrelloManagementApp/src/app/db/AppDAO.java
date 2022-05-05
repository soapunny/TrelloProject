package app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.db.entity.LoginEntity;
import app.logic.Automation;

public class AppDAO {
	private static AppDAO instance = null;
	private Connection conn = null;
	
	private AppDAO() {}
	public static AppDAO getInstance() {
		synchronized(AppDAO.class){
			if(instance == null) {
				instance = new AppDAO();
			}
		}
		return instance;
	}
	
	private Connection getConnection() {
		if(conn == null) {
			String url = DBSettings.URL;
			try {
				conn = DriverManager.getConnection(url);
				System.out.println("DB Driver is successfully connected");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	private void close() {
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
	}
	
	public LoginEntity getRememberedAppAccount() {
		LoginEntity rememberedAccount = null;
		
		conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM app_login WHERE isRemembered = 1");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				rememberedAccount = new LoginEntity();
				rememberedAccount.setEmail(rs.getString(1));
				rememberedAccount.setPassword(rs.getString(2));
				rememberedAccount.setRemembered(true);
				rememberedAccount.setLastLoginTime(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return rememberedAccount;
	}
	public boolean loginApp(Object loginEntityObject) {
		boolean isSuccess = false;
		LoginEntity loginEntity = null;
		if(loginEntityObject instanceof LoginEntity)
			loginEntity = (LoginEntity)loginEntityObject;
		
		conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM app_login WHERE email = ? and password = ?");
			ps.setString(1, loginEntity.getEmail());
			ps.setString(2, loginEntity.getPassword());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {//login success
				updateLastLoginTime(loginEntity);
				if(loginEntity.getRemembered()) {
					isSuccess = updateRememberMe(loginEntity.getEmail());
					System.out.println("updateRememberMe 성공? : "+isSuccess);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return isSuccess;
	}
	private boolean updateRememberMe(String email) {
		boolean isSuccess = false;
		try {
			PreparedStatement ps = conn.prepareStatement("Update app_login set isRemembered = 0");
			ps.executeUpdate();
			ps = conn.prepareStatement("Update app_login set isRemembered = 1 where email = ?");
			ps.setString(1, email);
			isSuccess = ps.executeUpdate() >= 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	private boolean updateLastLoginTime(LoginEntity loginEntity) {
		boolean isSuccess = false;
		try {
			PreparedStatement ps = conn.prepareStatement("Update app_login set lastLoginTime = ? where email = ?");
			ps.setString(1, loginEntity.getLastLoginTime());
			ps.setString(2, loginEntity.getEmail());
			isSuccess = ps.executeUpdate() >= 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
}
