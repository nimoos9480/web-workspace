package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;

@WebServlet("/AllMemberServlet")
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		MemberDAO dao = new MemberDAO();
		
		try {
//			ArrayList<MemberDTO> list = dao.showAllMember();
			ArrayList<MemberDTO> list = MemberDAO.getInstance().showAllMember();
			
			// 한 번 호출하면 되는 데이터니까 request에 데이터 바인딩 (session에 바인딩은 로그인처럼 상태유지를 해야하는 데이터일 경우)
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("views/allShow.jsp").forward(request, response);
		} catch (SQLException e) {}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}