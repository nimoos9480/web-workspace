package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class MemberDAO implements MemberDAOTemplate {
	
	
	public MemberDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success..");
		} catch (ClassNotFoundException e) {}
		
	}
	

	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USERNAME, ServerInfo.PASSWORD);
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
	public void inserMember(MemberVO vo) throws SQLException {
		Connection conn = getConnection();
		
		String query = "INSERT INTO MEMBER(NAME, AGE, ADDR) VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getName());
		ps.setInt(2, vo.getAge());
		ps.setString(3, vo.getAddr());
		
		System.out.println(ps.executeUpdate()+"명 가입!");
		
		closeAll(ps, conn);
		
	}



	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM MEMBER";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ArrayList<MemberVO> list = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new MemberVO(rs.getString("name"), rs.getInt("age"), rs.getString("addr")));
		}
		
		closeAll(rs, ps, conn);
		return list;
	}



	@Override
	public MemberVO findByNameMember(String name) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM MEMBER WHERE NAME=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		MemberVO vo = null;
		if(rs.next()) {
			 vo = new MemberVO(rs.getString("name"), rs.getInt("age"), rs.getString("addr"));
			
		}
		
		closeAll(rs, ps, conn);
		
		return vo;
	}
	
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		
		
	}

	

}
