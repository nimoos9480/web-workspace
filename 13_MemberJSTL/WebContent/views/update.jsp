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

	<c:if test="${dto!= null}">
			
	<h1>회원정보 수정</h1>
	<form action="/UpdateServlet" method="post">
		아이디 : <input type="text" name="id" value="${dto.id}" disabled><br>
		비밀번호 : <input type="password" name="password" value="${dto.password}"><br>
		이름 : <input type="text" name="name" value="${dto.name}"><br>
		주소 : <input type="text" name="address" value="${dto.address}"><br>
		<input type="submit" value="수정">
	</c:if>
	</form>
</body>
</html>