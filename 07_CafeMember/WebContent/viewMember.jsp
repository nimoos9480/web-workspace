<%@ page import="servlet.model.MemberVO" %> 
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
   <head>
     <meta charset="UTF-8" />
     <link
       href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
       rel="stylesheet"
       integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
       crossorigin="anonymous"
     />
     <title>Insert title here</title>
   </head>
   <body>
   <% 
   String name = request.getParameter("name");
   // List<MemberVO> list = (List) application.getAttribute("list"); 
	List<MemberVO> list = (List) request.getAttribute("list");
   %>
    <div class="container">
    <% if(name!=null) { %>
    	<h4><%=name %>님이 방금 전 회원가입 하셨습니다..</h4>
    <% } %>
    <hr>
   
      <h2>전체 Cafe 명단 리스트</h2>
      <table class="table">
        <tr>
          <th></th>
          <th>이름</th>
          <th>나이</th>
          <th>주소</th>
        </tr>
        

        <% 
        if(list!=null) {
        	for(int i=0; i<list.size(); i++) { %>
        }
        <tr>
          <td><%= i+1 %></td>
          <td><%= list.get(i).getName() %></td>
          <td><%= list.get(i).getAge() %></td>
          <td><%= list.get(i).getAddr() %></td>
        </tr>
        <% } } %>
      </table>
    </div>

    <%-- <h2>회원 정보를 출력합니다.</h2>
    <h2><% for(MemberVO member : list) { %></h2>
    <p><%= "이름 : " + member.getName() %></p>
    <p><%= "나이 : " + member.getAge() %></p>
    <p><%= "주소 : " + member.getAddr() %></p>
    <h2><%} %></h2> --%>
  </body>
</html>
