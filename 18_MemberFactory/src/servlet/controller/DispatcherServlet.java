package servlet.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.HandlerMapping;
import servlet.controller.ModelAndView;


@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// hidden 값으로 들어온 요청을 받지 않고, 들어온 요청의 주소를 직접 인식시킨다.
		String requestURI = request.getRequestURI();
		System.out.println("RequestURI :: " + requestURI);
		
		String[] requestURIList = requestURI.split("/");
		System.out.println("RequestURIList :: " + Arrays.toString(requestURIList));
		
		String command = requestURIList[requestURIList.length-1]; 
		System.out.println("Command :: " + command);
		
		Controller controller = HandlerMapping.getInstance().createController(command);		
			
		try {
			ModelAndView mv = controller.handle(request, response);
			
			if(mv!=null) {
				if(mv.isRedirect()) {
					response.sendRedirect(mv.getPath()); // 경로지정해서 다시 전송함(페이지(jsp)로 이동함) // true니까 리다이렉트 
				} else {
					request.getRequestDispatcher(mv.getPath()).forward(request, response); 
														 // false니까 forward(-> url이 XXX.do로 이동함, 로직이 외부에 공개되지 않음)
				}
			}
		} catch (Exception e) {}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
