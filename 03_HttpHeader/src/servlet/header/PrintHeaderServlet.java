package servlet.header;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintHeaderServlet
 */
public class PrintHeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리 해주기!
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");	
		
		String id = request.getParameter("id");
		
		PrintWriter out = response.getWriter();
		out.println("<h2>여기는 서비스입니다...</h2>");
		out.println("<p>ID : " + id + "</p>");
		
		out.close();

	}
	
	
}
