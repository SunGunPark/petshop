<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>


<html>
<head>
<meta charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>마이페이지</title>
</head>
<body>
	<div class="container">
		<button type="button" class="btn btn-primary">테스트</button>
	</div>
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="lightgreen">
			<td><b>아이디</b></td>
			<td><b>비밀번호</b></td>
			<td><b>이름</b></td>
			<td><b>휴대폰</b></td>
			<td><b>주소</b></td>
			<td><b>수정</b></td>
			<td><b>삭제</b></td>
		</tr>

		<c:forEach var="user" items="${usersList}">
			<tr align="center">
				<td>${user.user_id}</td>
				<td>${user.u_pwd}</td>
				<td>${user.u_name}</td>
				<td>${user.u_phone}</td>
				<td>${user.u_address}</td>
				<td><a
					href="${contextPath}/user/modifyForm.do?id=${user.user_id }">수정하기</a></td>
				<td><a
					href="${contextPath}/user/removeUser.do?id=${user.user_id }">삭제하기</a></td>
			</tr>
		</c:forEach>
	</table>
	<h2>구매 상품</h2>
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="lightblue">
			<td><b>번호</b></td>
			<td><b>이름</b></td>
			<td><b>분류</b></td>
			<td><b>가격</b></td>
			<td><b>삭제</b></td>
		</tr>
		<c:forEach var="item" items="${purchaseList}">
			<tr align="center">
				<td>${item.itemno}</td>
				<td>${item.i_name}</td>
				<td>${item.i_class}</td>
				<td>${item.i_price}</td>
				<td><a
					href="${contextPath}/user/removeItem.do?item=${item.itemno }">삭제하기</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
