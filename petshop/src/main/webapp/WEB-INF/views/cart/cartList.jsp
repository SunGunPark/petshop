<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${contextPath}/resources/css/cart.css">
<title>Insert title here</title>
</head>
<body>
   <h2>장바구니 확인</h2>
   <c:choose>
      <c:when test="${map.count == 0}">
         장바구니가 비어있습니다.
      </c:when>
      <c:otherwise>
      <form name="form1" id="form1" method="post" action="${contextPath}/cart/modifyCart.do">
         <table align="center" width="95%">
             <tr align="center" class="cartMenu">
               <th>이미지</th>
               <th>상품명</th>
               <th>단가</th>
               <th>수량</th>
               <th>금액</th>
               <th>취소</th>
            </tr>
            <c:forEach var="row" items="${map.list}" varStatus="i">
            <tr>
               <td>
                  <img src="${contextPath }/resources/image/${row.itemno}.jpg" width="80">
               </td>
               <td>
                  ${row.i_name}
               </td>
                <td style="width: 100px" align="center">
                  <fmt:formatNumber pattern="###,###,###" value="${row.i_price}"/>
               </td>
               <td>
                  <input type="number" style="width: 40px" name="c_amount" value="${row.c_amount}" min="1">
                  <input type="hidden" name="itemno" value="${row.itemno}">
               </td>
               <td style="width: 120px" align="center">
                  <fmt:formatNumber pattern="###,###,###" value="${row.money}"/>
               </td>
               <td>
                  <a href="${contextPath}/cart/deleteCart.do?cartNo=${row.cartNo}">삭제</a>
               </td>
            </tr>
            </c:forEach>
            <tr>
               <td colspan="6" align="right">
                  전체 주문금액  :  <fmt:formatNumber pattern="###,###,###" value="${map.sumMoney}"/>
               </td>
            </tr>
         </table>
         <input type="hidden" name="count" value="${map.count}">
         <button type="submit" id="btnUpdate">수정</button>
      </form>
      <button id="btnList" onclick="location.href='${contextPath}'">메인화면</button>
      <a href="${contextPath}/buy/insertBuy.do?user_Id=${row.user_Id}" id="btnBuy" class="no-underline">구매하기</a>
      </c:otherwise>
   </c:choose>
</body>
</html>