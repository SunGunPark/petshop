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
<link rel="stylesheet" href="${contextPath}/resources/css/itemList.css">
<meta charset=UTF-8">
<title>상품 리스트</title>
</head>
<body>
	<table class="cards">
		<tr>
			<c:forEach var="item" items="${itemList}">
				<td>
					<div class="cardc">
						<figure>
							<a href="${contextPath}/item/itemDetail.do?itemno=${item.itemno}">
								<img class="cards-img"
								src="${contextPath }/resources/image/${item.itemno}.jpg"
								width="100px" height="100px">
							</a>
							<div class="overlay">
								<div class="description">
									<a
										href="${contextPath}/item/itemDetail.do?itemno=${item.itemno}" class="card-font">${item.i_name}</a>
								</div>
							</div>
						</figure>
						<br>
						<h5>
							<fmt:formatNumber pattern="###,###,###" value="${item.i_price}" />
							원
						</h5>
					</div>
				</td>
			</c:forEach>
		</tr>
	</table>
</body>
</html>