<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
   request.setCharacterEncoding("utf-8");
%>  
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${contextPath}/resources/css/item.css">
<title>상품 상세 페이지</title>
</head>
<body>
<form action="${contextPath}/cart/insertCart.do" name="item-menu" method="POST" class="item-menu">
    <input type="hidden" name="itemno" value="${itemVO.itemno}">
	<div class="card-menu">
          <img class="card-img" src="${contextPath }/resources/image/${itemVO.itemno}.jpg" alt="">
          <div>
            <h3 value="${itemVO.i_name}">${itemVO.i_name}</h3>
            <h4><fmt:formatNumber pattern="###,###,###" value="${itemVO.i_price}" />원</h4>
            <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
            <p>4.0 stars</p>
               <select name="c_amount" size="1">
                <c:forEach begin="1" end="5" var="i">
                	<option value="${i}">${i}</option>
                </c:forEach>
              </select>
              <input type="submit" value="장바구니 담기" class="btn btn-cart" />
          </div>
        </div>
      </form>
</body>
</html>