package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberDAOTemplate {

	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	void insertMember(MemberVO vo) throws SQLException; // 리턴값이 없으니까 void
	ArrayList<MemberVO> showAllMember() throws SQLException; // 리턴값이 ArrayList, 매개변수는 없음
	MemberVO findByNameMember(String name) throws SQLException; // 매개변수 name을 받아서 MemberVO로 리턴
	
}


