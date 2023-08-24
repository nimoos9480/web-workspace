<%@ page import="edu.kh.test.user.model.vo.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보</h1>
	<% UserDTO dto = (UserDTO) request.getAttribute("dto"); 
	if(dto!=null) { %>
	
	<table border="1">	
	<tr>
		<th>회원번호</th>
		<th>회원아이디</th>
		<th>회원이름</th>
		<th>회원나이</th>
	</tr>	
	<tr>
		<td><%= dto.getUserNo() %></td>
		<td><%= dto.getUserId() %></td>
		<td><%= dto.getUserName() %></td>
		<td><%= dto.getUserAge() %></td>
		<!-- 
			<td> ${dto.userNo} </td> 
			<td> ${dto.userId} </td> 
			<td> ${dto.userName} </td> 
			<td> ${dto.userName} </td> 
			<td> ${dto.userAge} </td>
			-->
	</tr>
	<% } %>

	</table>
	<br>
	<a href="index.jsp">메인페이지로 돌아가기</a>
	
</body>
</html>