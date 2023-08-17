package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class ItemDAO implements ItemDAOTemplate{
	
	private static ItemDAO dao = new ItemDAO();
	
	private ItemDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {}
	}
	
	public static ItemDAO getInstance() {
		return dao;
	}

	@Override
	public Connection getConnection() throws SQLException {
		Connection conn= DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
		
	}

	@Override
	public ArrayList<Item> getAllItem() throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM item";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ArrayList<Item> list = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new Item(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6)));		
			
//			Item item = new Item();
//			item.setItemId(rs.getInt("itemId"));
//			item.setItemName(rs.getString("itemName"));
//			item.setPrice(rs.getInt("price"));
//			item.setDescription(rs.getString("description"));
//			item.setPictureUrl(rs.getString("pictureUrl"));
//			item.setCount(rs.getInt("count"));
			
//			list.add(item);
		}
		closeAll(rs, ps, conn);
		return list;
	}

	@Override
	public Item getItem(int itemId) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM item Where item_id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, itemId);
		
		ResultSet rs = ps.executeQuery();
		Item item = null;
		if(rs.next()) {
			item = new Item(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6));	
			
//			item.setItemId(rs.getInt("itemId"));
//			item.setItemName(rs.getString("itemName"));
//			item.setPrice(rs.getInt("price"));
//			item.setDescription(rs.getString("description"));
//			item.setPictureUrl(rs.getString("pictureUrl"));
//			item.setCount(rs.getInt("count"));
		}
		closeAll(rs, ps, conn);
		return item;
	}

	@Override
	public boolean updateRecordCount(int itemId) throws SQLException {
		Connection conn = getConnection();
		
		String query = "UPDATE item SET count=count+1 where item_id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, itemId);
		
		int row = ps.executeUpdate();
		
		boolean result = false;
		if(row > 0) result = true;
		
//		int count = getItem(itemId).getCount();
//		
//		ps.setInt(1, ++count);
//		ps.setInt(2, itemId);
//		
//		int result = ps.executeUpdate();
//		
//		if(result == 1) {
//			return true;
//		}
		
		closeAll(ps, conn);
		return false;
	}

}
