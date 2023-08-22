package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberVO;


public class EntranceServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("TEST!!");
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("addr");
		
		MemberVO vo = new MemberVO(name, age, address);
		System.out.println("2. VO 생성");
		MemberDAO dao = new MemberDAO();
		
		try {
//			
			 dao.insertMember(vo);
			 
			 ArrayList<MemberVO> memberList = dao.showAllMember();
			  request.setAttribute("list", memberList);
			  
			 // 4. 내비게이션 -> ViewMemberServlet
			  request.getRequestDispatcher("viewMember.jsp").forward(request, response);
			  } catch (SQLException e) {
			  e.printStackTrace();
			  response.sendRedirect("errorPage.jsp");
			  }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
