package servlet.model.dao;

import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import servlet.model.vo.MemberDTO;



public class MemberDAO implements MemberDAOTemplate{

	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		
		MemberDTO dto = new MemberDTO();
		dto.setId("user1");
		dto.setPassword("user1");
		dto.setName("신수민");
		dto.setAddress("경기도 광주");
		
		try {
//			dao.registerMember(dto);
			dao.login("user1", "user1");
			System.out.println("name : " + dto.getName());
			System.out.println("address : " + dto.getAddress());
		} catch (SQLException e) {

		}

	}
	
	public MemberDAO() {
		try {
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER_NAME);
			
		} catch (ClassNotFoundException e) {}
		
	}

	@Override
	public Connection getConnection() throws SQLException {
		// 2. 데이터베이스와 연결
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		// 5. close 닫기
		ps.close();
		conn.close();
		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
		
	}

	@Override
	public void registerMember(MemberDTO dto) throws SQLException {
		Connection conn = getConnection();
		
		// 3. Statement 객체 생성
		String query = "INSERT INTO member(id, password, name, address) VALUES(?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPassword());
		ps.setString(3, dto.getName());
		ps.setString(4, dto.getAddress());
		
		// 4. 쿼리문 실행
		System.out.println(ps.executeUpdate());
		
		closeAll(ps, conn);
	
		
	}

	@Override
	public MemberDTO login(String id, String password) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM member WHERE id=? AND password=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();
		MemberDTO dto = null;
		if(rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setPassword(rs.getString("password"));
			dto.setName(rs.getString("name"));
			dto.setAddress(rs.getString("address"));					
		} 
		closeAll(rs, ps, conn);
		return dto;
	}

	@Override
	public MemberDTO findByIdMember(String id) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM WHERE ID=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		
		MemberDTO dto = null;
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			dto = new MemberDTO();
			dto.setId(id);
		}
		closeAll(rs, ps, conn);
		return dto;
	}

	@Override
	public ArrayList<MemberDTO> showAllMember() throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM MEMBER";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ArrayList<MemberDTO> list = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new MemberDTO());
		}
		closeAll(rs, ps, conn);
		return list;
	}

}
