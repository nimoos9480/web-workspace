<%@page import="edu.kh.test.model.vo.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 정보</h2>
	<% UserDTO dto = (UserDTO) request.getAttribute("dto"); 
	if(dto!=null) { %>
	
	<tr>
		<td>회원번호</td>
		<td>회원아이디</td>
		<td>회원이름</td>
		<td>회원나이</td>
	</tr>
	
	<tr>
		<td><%= dto.getUserNo() %></td>
		<td><%= dto.getUserId() %></td>
		<td><%= dto.getUserName() %></td>
		<td><%= dto.getUserAge() %></td>
	</tr>
	<% } %>

	<a href="index.jsp">메인페이지로 돌아가기</a>
</body>
</html>