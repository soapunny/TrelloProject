package app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.db.entity.LabelEntity;

public class TrelloDAO {
	private static TrelloDAO instance = null;
	private Connection conn = null;
	
	private TrelloDAO() {}
	public static TrelloDAO getInstance() {
		synchronized(TrelloDAO.class){
			if(instance == null) {
				instance = new TrelloDAO();
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
	
	public boolean addLabel(LabelEntity labelEntity) {
		boolean hasSucceeded = false;
		
		conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO labeling(address1, address2, label) VALUES(?, ?, ?)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		
		return hasSucceeded;
	}
}
