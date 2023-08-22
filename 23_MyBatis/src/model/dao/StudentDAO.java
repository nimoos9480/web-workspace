package model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.vo.StudentVO;

public class StudentDAO {
	
	private static StudentDAO dao = new StudentDAO();
	private StudentDAO() {}
	public static StudentDAO getInstance() {
		return dao;
	}
	
	// SqlSession 넣으려면 lib에 파일 넣어줘야 함
	public List<StudentVO> showStudent(SqlSession sqlSession, String word) {
		return sqlSession.selectList("studentMapper.showStudent", word);
		
	}
}
