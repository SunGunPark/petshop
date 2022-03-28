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
<title>마이페이지</title>
</head>
<body>
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
				<td><a href="${contextPath}/user/modUser.do">수정하기</a></td>
				<td><a href="${contextPath}/user/removeUser.do?id=${user.user_id }">삭제하기</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
