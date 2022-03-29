<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function(){
		$("#backToList").click(function(){
			history.back();
		})  
	});
		
	$(document).ready(function(){
		$("#saveBtn").click(function(){
			var title = document.boardForm.b_title.value;
			var type = document.boardForm.b_type.value;
			var content = document.boardForm.b_content.value;
			if(title==""){
				alert("제목을 입력하세요")
				document.boardForm.b_title.focus();
				return;
			}
			if(type==""){
				alert("카테고리를 입력하세요")
				document.boardForm.b_type.focus();
				return;
			}
			if(content==""){
				alert("내용을 입력하세요")
				document.boardForm.b_content.focus();
				return;
			}
			document.boardForm.submit();
		})
	})
</script>
<style type="text/css">
	
	textarea {
    	width: 100%;
    	height: 30em;
    	border: none;
    	resize: none;
    	border: 1px solid;
    }

</style>
</head>
<body>
	<form name="boardForm" method="post" action="${contextPath}/board/registerBoard.do" enctype="multipart/form-data">
		
		<table border="0" align="center">
			<tr>
				<td align="center" width="150" bgcolor="#C0C0C0">작성자</td>
				<td colspan="2" align="left">
					<input type="text" size="100%" maxlength="100" name="user_id" value="${sessionScope.user.user_id }" readonly="readonly">
				</td>
			</tr>
			<tr>
				
				<td align="center" width="150" bgcolor="#C0C0C0">제목</td>
				<td colspan="2" align="left">
					<input type="text" size="100%" maxlength="500" name="b_title" placeholder="제목을 입력하세요">
				</td>
			</tr>
			<tr>
				<td align="center" width="150" bgcolor="#C0C0C0">카테고리</td>
					<td colspan="2" align="left">
					<input type="text" size="100%" maxlength="500" name="b_type" placeholder="카테고리를 입력하세요">
				</td>
			</tr>
			<tr>
				<td align="center" width="150" bgcolor="#C0C0C0">내용</td>
				<td colspan="4" align="left">
					<textarea rows="10" cols="81" maxlength="4000" name="b_content" placeholder="내용을 입력하세요"></textarea>
				</td>
			</tr>
			<tr>
				<td align="center"></td>
				<td colspan="4">
					<input type="button" id="saveBtn" value="글쓰기">
					<input type="button" value="목록보기" id="backToList">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>