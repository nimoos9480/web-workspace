<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>
		<input type="text" name="search">
		<button type="submit">검색</button>
		
		<table border="1">
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>주소</th>
				<th>학과</th>
				<th>계열</th>
			</tr>
			
			<c:forEach items="${list}" var="item">
				<tr>
					<th>${item.studentNo}</th>
					<th>${item.studentName}</th>
					<th>${item.studentAddress}</th>
					<th>${item.departmentName}</th>
					<th>${item.category}</th>
				</tr>
			</c:forEach>
		</table>
</body>
</html>