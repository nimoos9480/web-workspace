package servlet.controller.component;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;


public class IdCheckController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");		
//		PrintWriter out = response.getWriter();
		MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
		
		boolean flag = false;
		if(vo!=null) {
			flag = true;
		}
		
		// 비동기 방식
		PrintWriter out = response.getWriter();
		out.print(flag);
		
		return null;
		
//		if(id!=null && !id.isEmpty()) {
//			 if (vo != null) {
//	                out.print("이미 사용중인 아이디입니다.");
//	            } else {
//	                out.print("사용 가능한 아이디입니다.");
//	            }
//	        } else {
//	            out.print("아이디를 입력해주세요.");
//	        }
//
//		return new ModelAndView();
		
	}

}
