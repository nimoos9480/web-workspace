package edu.kh.test.user.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import edu.kh.test.user.model.vo.UserDTO;

public class UserDAO implements UserDAOTemplate{
	
	public UserDAO() {
		// 드라이버 로딩
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			// Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
	}

	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.NAME, ServerInfo.PASSWORD);
		// Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sample", "SAMPLE");
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
		
		ResultSet rs = ps.executeQuery();
		UserDTO dto = null;
		if(rs.next()) {
			dto = new UserDTO();
			dto.setUserNo(rs.getInt("user_No"));
			// == dto.setUserNo(userNo);로 써도 됨
			dto.setUserId(rs.getString("user_Id"));
			dto.setUserName(rs.getString("user_Name"));
			dto.setUserAge(rs.getInt("user_Age"));
			
			// System.out.println(dto); == 없어도 됨
		}
		
		closeAll(rs, ps, conn);
		return dto;
	}
}