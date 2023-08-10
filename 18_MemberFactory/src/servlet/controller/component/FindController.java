package servlet.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class FindController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 폼값 
		String id = request.getParameter("id");
		String path = "views/find_fail.jsp";
		
		MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
		if(vo!=null) {
			request.setAttribute("vo", vo); // request에 값을 바인딩 했기때문에 forward로 보내야 함
			path = "views/find_ok.jsp";
		} 
		return new ModelAndView(path);
	}

}
