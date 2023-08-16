package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import servlet.model.Member;


@WebServlet("/JsonAjax")
public class JsonAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Json 형식의 비동기 코드를 작성하려면.. json 라이브러리가 필요
		
		// JSONObject 객체 하나 생성
		JSONObject json = new JSONObject();
		
		// 1. 키값을 넣는 방식
//		json.put("name", "Jason");
//		json.put("age", 20);
//		json.put("addr", "Texas");
		
		// 2. 객체 방식 그대로 넘기는 방식
		Member member = new Member("Jason", 20, "Texas");
//		json.put("member", member);  // undefined에 사는 undefined살 undefined입니다~라고 뜸
		
		// 객체를 json 방식으로 바꾸기
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(member);
		
		json.put("result", result); 
		
		 
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
