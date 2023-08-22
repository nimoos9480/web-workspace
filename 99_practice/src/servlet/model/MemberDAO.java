package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class MemberDAO implements MemberDAOTemplate{
	
	// 드라이버 로딩
	public MemberDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {}
		
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
	public void insertMember(MemberVO vo) throws SQLException {
		Connection conn = getConnection();
		String query = "INSERT INTO member(name, age, addr) values(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getName());
		ps.setInt(2, vo.getAge());
		ps.setString(3, vo.getAddr());
		
		System.out.println(ps.executeUpdate() +"명 가입!");
		
		closeAll(ps, conn);
			
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM member";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ArrayList<MemberVO> list = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			list.add(new MemberVO(rs.getString("name"), rs.getInt("age"), rs.getString("addr")));
		}
		
		closeAll(rs, ps, conn);
		
		return list;
	}

	@Override
	public MemberVO findByNameMember(String name) throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM member WHERE name=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		MemberVO vo = null;
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			vo = new MemberVO(rs.getString("name"), rs.getInt("age"), rs.getString("addr"));
		}
		
		closeAll(rs, ps, conn);
		
		return vo;
	}

}
