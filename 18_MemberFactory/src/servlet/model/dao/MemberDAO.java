package servlet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import servlet.model.vo.MemberVO;



public class MemberDAO implements MemberDAOTemplate{

	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		
		MemberVO vo = new MemberVO();
		vo.setId("user1");
		vo.setPassword("user1");
		vo.setName("신수민");
		vo.setAddress("경기도 광주");
		
		try {
//			dao.registerMember(dto);
			dao.login("user1", "user1");
			System.out.println("name : " + vo.getName());
			System.out.println("address : " + vo.getAddress());
		} catch (SQLException e) {

		}

	}
	
	// 싱클톤 패턴 - 클래스의 객체가 항상 하나만 존재하도록
	/*
	 * DAO를 반복적으로 생성하고 해제하는 것은 비효율적
	 * 객체지향적 설계! 싱글톤 패턴은 객체지향적 설계 원칙을 준수 -> 중앙에서 처리!
	 * 주의할 점은 싱글톤은 전역 상태를 가질 수 있으므로 오남용하면 애플리케이션의 복잡성이 증가
	 * */
	private static MemberDAO dao = new MemberDAO();
	
	private MemberDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {}
		
		// private이라 바깥에서 객체 생성 불가~
	}
	
	public static MemberDAO getInstance() {
		return dao;
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
	public void registerMember(MemberVO vo) throws SQLException {
		Connection conn = getConnection();
		
		// 3. Statement 객체 생성
		String query = "INSERT INTO member(id, password, name, address) VALUES(?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPassword());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getAddress());
		
		// 4. 쿼리문 실행
		System.out.println(ps.executeUpdate());
		
		closeAll(ps, conn);
	
		
	}

	@Override
	public MemberVO login(String id, String password) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM member WHERE id=? AND password=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();
		MemberVO vo = null;
		if(rs.next()) {
			vo = new MemberVO();
			vo.setId(rs.getString("id"));
			vo.setPassword(rs.getString("password"));
			vo.setName(rs.getString("name"));
			vo.setAddress(rs.getString("address"));					
		} 
		closeAll(rs, ps, conn);
		return vo;
	}

	@Override
	public MemberVO findByIdMember(String id) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM member WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		
		
		ResultSet rs = ps.executeQuery();
		MemberVO vo = null;
		if(rs.next()) {
			vo = new MemberVO();
			vo.setId(rs.getString("id"));
			vo.setPassword(rs.getString("password"));
			vo.setName(rs.getString("name"));
			vo.setAddress(rs.getString("address"));	
		}
		closeAll(rs, ps, conn);
		return vo;
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM member";
		PreparedStatement ps = conn.prepareStatement(query);
				
		ResultSet rs = ps.executeQuery();
		ArrayList<MemberVO> list = new ArrayList<>();
		while(rs.next()) {
			MemberVO vo = new MemberVO();
			vo.setId(rs.getString("id"));
			vo.setPassword(rs.getString("password"));
			vo.setName(rs.getString("name"));
			vo.setAddress(rs.getString("address"));
			
			list.add(vo);
		}
		closeAll(rs, ps, conn);
		return list;
	}
	
	@Override
	public void updateMember(MemberVO vo) throws SQLException {
		Connection conn= getConnection();
		
		String query = "UPDATE member SET password=?, name=?, address=? WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, vo.getPassword());
	    ps.setString(2, vo.getName());
	    ps.setString(3, vo.getAddress());
	    ps.setString(4, vo.getId());
	    
		ps.executeUpdate();
		
		closeAll(ps, conn);
		
	}

}
