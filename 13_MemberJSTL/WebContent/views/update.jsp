<%@page import="servlet.model.vo.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
	<h1>회원 정보 수정</h1>
	<form action="/UpdateServlet" method="post">
		ID : <input type="text" name="id" value="${dto.id}" readonly><br>
		PASSWORD : <input type="password" name="password" value="${dto.password}"><br>
		NAME : <input type="text" name="name" value="${dto.name}"><br>
		ADDRESS : <input type="text" name="address" value="${dto.address}"><br>
		<input type="submit" value="수정">

	</form>
</body>
</html>