package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 세션을 하나 받아온다... request.getSession()
		HttpSession session = request.getSession(); // session은 쿠키와 달리 객체로 저장 가능, 쿠키보다 보안성이 높음
		
		// 2. 폼에 입력된 값을 가지고 객체 생성.. MemberVO (DAO 생략...)
		String id = request.getParameter("id");
		String password = request.getParameter("password");		
		MemberVO vo =  new MemberVO(id, password, "신수민", "경기도 광주");
		
		// 3. 세션에 바인딩
		session.setAttribute("vo", vo); // 객체로 담은 것
		
		// 4. 네비게이션
		PrintWriter out = response.getWriter();
		out.println("<a href=ProductServlet>ProductServlet..</a>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
