package edu.kh.test.user.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.test.user.model.dao.UserDAO;
import edu.kh.test.user.model.vo.UserDTO;


@WebServlet("/SelectUserServlet")
public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		UserDTO dto = null;
		UserDAO dao = new UserDAO();
		
		try {
			dto = dao.selectUser(userNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("dto", dto);
		
		if(dto!=null) {
			request.getRequestDispatcher("WEB-INF/views/searchSuccess.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("WEB-INF/views/searchFail.jsp").forward(request, response);			
			// WEB-INF는 감추고 싶은 정보일 때 사용하는 경로 ==> sendRedirect 경로 사용 못함
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
