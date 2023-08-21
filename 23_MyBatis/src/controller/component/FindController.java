package controller.component;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.service.StudentService;
import model.vo.StudentVO;

public class FindController implements Controller {
	// 컨트롤러는 서비스랑 연결되어 있다.

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String word = request.getParameter("word");
		List<StudentVO> list = new StudentService().showStudent(word);
		
		return null;
	}

}
