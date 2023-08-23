package org.kh.member.model.service;


import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.dao.MemberDAO;
import org.kh.member.model.vo.MemberVO;

public class MemberServiceImpl{

public int insertMember(MemberVO mOne) {
	SqlSession sqlSession = SqlSession.getSqlSession();
	int result = MemberDAO.getInstance().insertMember(sqlSession, mOne);
	
	if(result > 0) sqlSession.commit();
	sqlSession.close();
	
	return result;

}

}
