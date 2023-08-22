package controller.component;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

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
		
		
		JSONObject json = new JSONObject();
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(list);
		
		json.put("result", result);		// json에 담기
				
		PrintWriter out = response.getWriter(); // 담은 걸 보내기
		out.print(json);
		


        return null; // null로 반환
      
	}

}
