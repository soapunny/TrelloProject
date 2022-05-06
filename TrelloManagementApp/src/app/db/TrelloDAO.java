package app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

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
			System.out.println("DB Driver is successfully closed");
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
			ps.setString(1, labelEntity.getAddress1());
			ps.setString(2, labelEntity.getAddress2());
			ps.setString(3, labelEntity.getLabel());
			hasSucceeded = ps.executeUpdate() >= 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return hasSucceeded;
	}
	public boolean refreshLabels(DefaultTableModel param) {
		boolean hasSucceeded = false;
		
		conn = getConnection();
		try {
			param.setRowCount(0);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM labeling");
			ResultSet rs = ps.executeQuery();
			int rowCnt = 0;
			while(rs.next()) {
				param.addRow(new Object[] {
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
				});
				rowCnt++;
			}
			System.out.println(rowCnt +" rows of label data has founded");

			hasSucceeded = true;
		} catch (SQLException e) {
			e.printStackTrace();
			hasSucceeded = false;
		} finally {
			close();
		}
		return hasSucceeded;
	}
	public int deleteLabels(ArrayList<Integer> param) {
		int deletedRows = 0;
		
		conn = getConnection();
		try {
			String sql = "DELETE FROM labeling WHERE";
			Iterator<Integer> labelIter = param.iterator();
			if(labelIter.hasNext()) {
				sql += " seq = "+labelIter.next();
				while(labelIter.hasNext()) {
					sql += " OR seq = "+labelIter.next();
				}
				PreparedStatement ps = conn.prepareStatement(sql);
				deletedRows = ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return deletedRows;
	}
}
