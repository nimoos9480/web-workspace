<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="servlet.model.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<% MemberVO vo = (MemberVO) request.getAttribute("vo"); %>
	<h2> 회원 검색 결과 </h2>
	<ul>
		<li>이름 : <%= vo.getName() %></li>
		<li>나이 : <%= vo.getAge() %></li>
		<li>주소 : <%= vo.getAddr() %></li>
	</ul>
</body>
</html>