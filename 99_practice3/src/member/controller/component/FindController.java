package member.controller.component;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class FindController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 폼값 
		String path = "views/find_fail.jsp";		
		
		String id = request.getParameter("id");
		String addr = request.getParameter("addr");
		
		String [] idList = request.getParameterValues("checkId");
		
		MemberVO vo = new MemberVO();
		if(id!="") vo.setId(id);
		if(addr!="") vo.setAddress(addr);
		List<MemberVO> list = new MemberService().findByIdMember(idList);
			
		if(list!=null) {
			request.setAttribute("list", list); // request에 값을 바인딩 했기때문에 forward로 보내야 함
			path = "views/allShow.jsp";
		} 
		return new ModelAndView(path);
	}

}
