<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  table {
  	align: center;
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  tr:first-child{
  	background-color: rgb(192, 192, 192);
  	pointer-events: none;
  }
  td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
  tr:hover {
  	background-color: rgba(192, 192, 192, .3);
  }
  a {
    text-decoration: none;
    color: black;
  }
  .btn {
  	margin-top: 10px;
  }
</style>
<script>
	function fn_articleForm(isLogOn, articleForm, loginForm) {
		if(isLogOn != '' && isLogOn != 'false') {
			location.href= articleForm;
		} else {
			alert('로그인 후 글쓰기가 가능합니다.');
			location.href=loginForm+'?action=/board/boardForm.do';
		}
	}
</script>
</head>
<body>
	<table >
		<tr align="center" >
			<td>번호</td>
			<td>카테고리</td>
			<td>제목</td>
			<td>글쓴이</td>
			<td>날짜</td>
		</tr>
	<c:choose>
		<c:when test="${empty boardList}">
			<tr height="10">
				<td colspan="5">
					<p align="center">
						<b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
					</p>
				</td>
			</tr>
		</c:when>
		<c:when test="${!empty boardList}">
			<c:forEach	var="board" items="${boardList}" varStatus="articleNum">
				<tr align="center">
					<td>${articleNum.count }</td>
					<td>${board.b_type}</td>
					<td><a href="${contextPath}/board/boardView.do?boardNo=${board.boardNo}">${board.b_title}</a></td>
					<td>${board.user_id}</td>
					<td><fmt:formatDate value="${board.b_date}" pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>
	</table>
	<div class="btn">
		<a class="cls1" href="javascript:fn_articleForm('${isLogOn }', '${contextPath}/board/boardForm.do', '${contextPath}/user/loginForm.do')">
			<span class="cls2">글쓰기</span>
		</a>
	</div>
</body>
</html>