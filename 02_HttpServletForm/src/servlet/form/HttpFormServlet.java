package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpFormServlet
 */
public class HttpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 한글 처리 = 양방향을 다 해줘야 함!
		 * */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String result = request.getParameter("userId"); // key ==> name 값 가져오기
		String result2 = request.getParameter("userPwd");
		
		String[] menuList = request.getParameterValues("menu");
		String gender = request.getParameter("gender");
		
		PrintWriter out = response.getWriter();

		out.println("<h2>정보를 출력합니다...</h2>");
		out.println("<p>당신의 아이디는 " + result + "</p>");
		out.println("<p>당신의 비밀번호는 " + result2 + "</p>");
		// 당신의 성별은 --> form.html 라디오
		
		out.println("<p>당신의 성별은 " + (gender.charAt(0) == 'M' ? "남자입니다." : "여자입니다.") + "</p>");
		// 그냥 gender로 받으면 value값인 M / F가 뜸
		out.println("<ul>");
		for(String menu : menuList) {
			out.println("<li>" + menu + "</li>");
		}
		out.println("</ul>");

		out.close();
	}

}
