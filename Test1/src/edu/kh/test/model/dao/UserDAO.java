package edu.kh.test.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import edu.kh.test.model.vo.UserDTO;

public class UserDAO implements UserDAOTemplate{
	
	public UserDAO() {
		// 드라이버 로딩
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
	}

	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.NAME, ServerInfo.PASSWORD);
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
	public UserDTO selectUser(int userNo) throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM tb_user WHERE user_no=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, userNo);
		
		UserDTO dto = null;
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			dto = new UserDTO();
			dto.setUserNo(rs.getInt("user_No"));
			dto.setUserId(rs.getString("user_Id"));
			dto.setUserName(rs.getString("user_Name"));
			dto.setUserAge(rs.getInt("user_Age"));
			
			System.out.println(dto);
	
		}
		closeAll(ps, conn);
		return dto;
	}
}