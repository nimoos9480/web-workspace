package servlet.controller.component;

import java.awt.im.InputMethodRequests;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class allShowController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<MemberVO> list = MemberDAO.getInstance().showAllMember();
		request.setAttribute("list", list);
		
		String path = "views/allShow.jsp";
		
		return new ModelAndView(path);
	}

}
