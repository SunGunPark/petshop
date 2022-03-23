<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:choose>
<c:when test="${result=='loginFailed' }">
	<script>
		window.onload = function(){
			alert('아이디나 비밀번호가 틀렸습니다. 다시 로그인하세요.');
		}
	</script>
</c:when>
</c:choose>
</head>
<body>
	<form action="/petshop/user/login.do" method="post">	
		<table border="1" width="80%" align="center">
			<tr align="center">	
				<td>아이디</td>
				<td>비밀번호</td>
			</tr>
			<tr align="center">
				<td><input type="text" name="id" size="20"></td>
				<td><input type="password" name="pwd" size="20"></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>