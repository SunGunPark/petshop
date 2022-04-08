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
			alert("글쓰기가 완료되었습니다")
		})
	})
</script>
<style type="text/css">

	.boardForm {
		margin-left: 10%;
	}

	.board-header {
		display: flex;
	}
	
	.board-header_writer,
	.board-header_category,
	.board-header_title,
	.board-content {
		display: flex;
		flex-direction: column;
		align-items: flex-start;
		justify-content: flex-start;
		margin-right: 30px;
	}
	
	.board-header_writer input,
	.board-header_category select,
	.board-header_title input {
		border: 1px solid transparent;
   		border-bottom: 1px solid #ccc;
   		border-radius: 3px;
	    padding: 0.375rem 0.75rem;
	    line-height: 1.5;
	    height: 2.75em;
	    
	}
	
	.board-header_category {
		width: 200px;	
	}
	
	.board-header_category select {
		width: 100%;
		margin-top: 1em;
	}
	
	.board-content textarea {
    	width: 100%;
    	height: 27em;
    	border: none;
    	resize: none;
    	border: 1px solid;
    }
    
    .board-btn {
    	margin-top: 20px;
    }
    
    .board-btn input {
		border: none;
    	display: inline-block;
	    padding: 0 0.5em;
	    line-height: 2em;
	    text-decoration: none;
	    color: #fff !important;
	    background-color: #b3b3b3;
    }
    
</style>
</head>
<body>
	<form class="boardForm" name="boardForm" method="post" action="${contextPath}/board/registerBoard.do" enctype="multipart/form-data">
		
		<div class="board-header">
			<div class="board-header_writer">
				<h3>작성자</h3>
				<input type="text" name="user_id" value="${sessionScope.user.user_id }" readonly="readonly">
			</div>
			<div class="board-header_category">
				<h3>카테고리</h3>
				<select name="b_type">
						<option>음식</option>
						<option>옷</option>
						<option>기타</option>
				</select>
			</div>
			<div class="board-header_title">
				<h3>제목</h3>
				<input type="text" size="100%" maxlength="500" name="b_title" placeholder="제목을 입력하세요">
			</div>
		</div>
		<div class="board-content">
			<h3>내용</h3>
			<textarea rows="10" cols="81" maxlength="4000" name="b_content" placeholder="내용을 입력하세요"></textarea>
		</div>
		<div class="board-btn">
			<input type="button" id="saveBtn" value="글쓰기">
			<input type="button" value="목록보기" id="backToList">
		</div>
	</form>
</body>
</html>