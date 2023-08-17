<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <h1>장바구니</h1>
    <a href="itemList.do">쇼핑 계속하기</a>
    <c:if test="${not empty fruits}">
      <table border="1">
        <tr>
          <td>번호</td>
          <td>상품 이미지</td>
          <td>상품명</td>
          <td>상품가격</td>
          <td>수량</td>
          <td>
            <button>삭제</button>
          </td>
        </tr>
	 <c:forEach items="${fruits}" var="item">
        <tr>
          <td>index</td>
          <td><img src="${item.pictureUrl}" width="50" height="50" /></td>
          <td>${item.itemName}</td>
          <td>${item.price}원</td>
          <td>1</td>
          <td><input type="checkbox" name="delete" id="delete"></td>
        </tr>
      </c:forEach>
	  <tr>
        <td colspan="6">총 결제금액 : ${totalPrice}원</td>
      </tr>
    </table>
  </c:if>
</body>
</html>
