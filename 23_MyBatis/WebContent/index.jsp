<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page import="model.vo.StudentVO" %>
<%@ page import="java.util.List" %>
<%@ page import="model.service.StudentService" %>
<!-- 
 첫페이지에 리스트 뿌려주기 <% %> -->
<% 
List<StudentVO> list = new StudentService().showStudent(null); 
   request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<style>
	.container .row {
		margin-top: 50px;
		margin-bottom: 30px;
	}
</style>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col">
				<input id="word" type="text" class="form-control">
			</div>
			<div class="col">
				<input id="searchBtn" value="검색" type="button" class="btn btn-danger">
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
            		<th>학번</th>
            		<th>이름</th>
            		<th>주소</th>
            		<th>학과</th>
            		<th>계열</th>
        		</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="student">
					<tr>
						<td>${student.studentNO}</td>
						<td>${student.studentName}</td>
						<td>${student.studentAddress}</td>
						<td>${student.department.departmentName}</td>
						<td>${student.department.category}</td>					
					</tr>				
				</c:forEach>
			</tbody> <!-- 나오는지 확인 후 고치기 -->
		</table>
	</div> 

 
 
<script>
	$('#searchBtn').click(function() {
		const word = $('#word').val(); 
		
		$.ajax({
			type: 'get', // 검색은 보통 get방식
			url: "find.do",
			data: 'word='+ word, 
			dataType: 'json',  // 백단은 주로 json 방식으로 
			
			// 응답부분
			success: function(data) {
				// console.log(data.result);
				const result = eval(data.result);
				// console.log(result);
				let resultHtml = '';
				for(let item of result) { // of써야 각각의 값을 가지고 옴(in은 인덱스를 가지고 옴)
					resultHtml += "<tr>" + 
									"<td>" + item.studentNO + "</td>" +
									"<td>" + item.studentName + "</td>" +
									"<td>" + item.studentAddress + "</td>" +
									"<td>" + item.department.departmentName + "</td>" +
									"<td>" + item.department.category + "</td>" +
								 "</tr>";
				}
				$('tbody').html(resultHtml);
			},
			error: function() {
				alert('응답시간 지연... Error!!');
			},
		});
	});
</script>	
		
	
</body>
</html>