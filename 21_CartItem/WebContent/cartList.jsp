<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
  </head>
  <body>
    <h1>장바구니</h1>
    <a href="itemList.do">쇼핑 계속하기</a>

      <table border="1">
      	<thead>
      		<tr>
          		<th>번호</th>
          		<th>상품 이미지</th>
          		<th>상품명</th>
          		<th>상품가격</th>
          		<th>수량</th>
          		<th><button onclick="deleteStorage()">삭제</button></th>
        	</tr>
      	</thead>
      	<tbody></tbody>
      	<tfoot>
      		<tr>
        		<td colspan="6">총 결제금액 : <span id="resultTotal">${totalPrice}원</span></td>
      		</tr>
      	</tfoot>
      
	  
    </table>
    
    <script>
    	let amount = 1;
   		let totalPrice = 0;
    	refreshPage(); // 들어오는 순간 재호출
    	
    	function refreshPage() {
    		let html = '';
    		let count = 0;
    		for(let key in localStorage) {
    			// console.log(key);
    			if(key==='length') break;
    			// console.log(key);
    			const data = localStorage.getItem(key).split(",");
    			console.log(data); // 배열방식으로 온다
    			html += '<tr>' + 
    						'<td>' + ++count + '</td>' +
    						'<td><img src=' + data[2] +' width=150 height=150></td>' +
    						'<td>' + data[0] + '</td>' +
    						'<td>' + data[1] + '</td>' +
    						'<td><img src=img/up.jpg width=10 height=10 style=cursor:pointer; class=up><div>' + amount 
    												+ '</div><img src=img/down.jpg width=10 height=10 style=cursor:pointer; class=down></td>' +
    						'<td><input value='+ key +' type=checkbox class=deleteItem></td>' +
    					'</tr>';
    					totalPrice += eval(data[1]);
    		}
    		$('tbody').append(html);
    		$('#resultTotal').html(totalPrice);
    	}
    	
		$('.up').on('click', function() {
    		$(this).next().html(eval($(this).next().html())+1); // 이미지 다음 숫자칸 접근하려고 .next(), 숫자자체를 바꾸려고, .html()
    		amount = $(this).next().html(); // 바뀐 값 담기
    		console.log($(this).parent().prev().html()); // 부모태그의 이전값 = 가격
    		totalPrice += eval($(this).parent().prev().html());
    		$('#resultTotal').html(totalPrice);
    	});
    	
		$('.down').on('click', function() {
			if(amount > 1) {
				$(this).prev().html(eval($(this).prev().html())-1);
				amount = $(this).prev().html();	
				totalPrice -= eval($(this).parent().prev().html());
				$('#resultTotal').html(totalPrice);
			} 
    	});
		
		function deleteStorage() {
			const check = document.querySelectorAll(".deleteItem");
			console.log(check);
			for(let i=0; i<check.length; i++) {
				if(check[i].checked === true) {
					localStorage.removeItem(check[i].value);
					location.reload();
				}
			}
		}
    	
    </script>

</body>
</html>
