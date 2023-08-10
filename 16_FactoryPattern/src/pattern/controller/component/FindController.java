package pattern.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern.controller.Controller;
import pattern.model.NoteBook;
import pattern.model.NoteBookDAO;

public class FindController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 비즈니스 로직에 request와 response가 올 것 이기 때문에 미리 설정해준 것
		
		
		// 1. 폼값 받아오기
		String path = "find_fail.jsp";
		String model = request.getParameter("model");
		
		NoteBook notebook = NoteBookDAO.getInstance().findNoteBook(model);
		
		if(notebook!=null) {
			request.setAttribute("notebook", notebook);
			path = "find_result.jsp";
		}
		
		return path;
	}

}
