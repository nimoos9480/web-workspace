package org.kh.member.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.vo.MemberVO;

public class MemberDAO {
	
	private static MemberDAO dao = new MemberDAO();	
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		return dao;
	}	
	
	public int insertMember(SqlSession session, MemberVO mOne) {
		int result=0;
		return session.insert("mybatis.insertMember", mOne);
		
	}
	
}


