<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	request.setCharacterEncoding("UTF-8");
	String i_class = request.getParameter("i_class");
%>


<html>
<head>
<style>
	.card{
	    margin-top: 50px;
	    display: flex;
	    justify-content: center;
	    align-items: center;
	}
	
	.card-img{
		width: 200px;
		height: 200px;
	}
	
	.cardc{
		margin-left: 50px;
		margin-right: 50px;
		border: 1px solid lightgrey;
     	border-radius: 5px;
	}
</style>
<meta charset=UTF-8">
<title>상품 리스트</title>
</head>
<body>
	<table class="card">
		<tr>
		<c:forEach var="item" items="${itemList}">
			<td>
				<div class="cardc">
				<a href="${contextPath}/item/itemDetail.do?itemno=${item.itemno}">
				<img class="card-img" src="${contextPath }/resources/image/${item.itemno}.jpg" width="100px" height="100px"></a>
				<br>
				<a href="${contextPath}/item/itemDetail.do?itemno=${item.itemno}" class="no-underline">${item.i_name}</a>
				<h5><fmt:formatNumber pattern="###,###,###" value="${item.i_price}" />원</h5>
				</div>
			</td>
		</c:forEach>
		</tr>
	</table>
</body>
</html>