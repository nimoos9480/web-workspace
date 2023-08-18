package servlet.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import servlet.model.dao.MemberRepository;
import servlet.model.vo.MemberDTO;

public class MemberService {  // DAO에 있는거 그대로 전달하는 역할만 함

	private MemberRepository repo = new MemberRepository();
	
	public ArrayList<MemberDTO> showAllMember() throws SQLException {
		return repo.showAllMember();
	}
}
