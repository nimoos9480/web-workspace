package servlet.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class RegisterController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO(id, password, name, address);		
		MemberDAO.getInstance().registerMember(vo); // 회원가입 완료 - 데이터바인딩 안하고 회원가입 다시 하려고 세션에 담지 않음
		
		// 데이터 바인딩 - request, session, context
		// setAttribute / getAttribute
		// request <--- 범위가 가장 좁다(요청이 들어오면 응답하는 것 까지가 데이터 범위)
		// session <--- 로그인 / 로그아웃
		// context <--- 범위가 가장 넓음(거의 사용 X)

		return new ModelAndView("index.jsp", true); // 리다이렉트 방식
//		return new ModelAndView("index.jsp"); // forward 방식 - request로 넘길때는 무조건!
	}

}
