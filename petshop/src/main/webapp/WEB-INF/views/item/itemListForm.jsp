<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	request.setCharacterEncoding("UTF-8");
	String i_class = request.getParameter("i_class");
%>


<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<body>
	<h2><%=i_class %> 상품 리스트</h2>
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="lightblue">
			<td><b>번호</b></td>
			<td><b>분류</b></td>
			<td><b>이미지</b></td>
			<td><b>이름</b></td>
			<td><b>가격</b></td>
		</tr>
		<c:forEach var="item" items="${itemList}">
			<tr align="center">
				<td>${item.itemno}</td>
				<td>${item.i_class}</td>
				<td><img src="${contextPath }/resources/image/${item.itemno}.jpg"
				 width="100px" height="100px"></td>
				 <td>${item.i_name}</td>
				<td>${item.i_price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
