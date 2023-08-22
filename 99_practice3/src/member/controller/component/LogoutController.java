package member.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.Controller;
import member.controller.ModelAndView;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
			return new ModelAndView("views/logout.jsp");
		}
//		return new ModelAndView("index.jsp");
		return null;
		
		 // return null; => 특정한 뷰를 표시하지 않고, 요청을 더 이상 처리하지 않겠다는 의미
		 					//보통 이런 경우, 다른 조건에 따라 다른 뷰 또는 처리를 위한 ModelAndView 객체를 반환하는 것이 일반적
	}

}
