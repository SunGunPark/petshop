<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("replaceChar", "\n"); %>

<c:set var="contextPath"  value="${pageContext.request.contextPath}"  /> 
<c:set var="article"  value="${articleMap.article}"  />

<%
  request.setCharacterEncoding("UTF-8");
%> 

<head>
	<meta charset="UTF-8">
    <title>글보기</title>
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
   		integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
   		crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script type="text/javascript" >
   
		$(function(){
   			$("#backToList").click(function(){
   				location.href = '${contextPath}/board/boardList.do'
   			})  
        });
   		
   		$(function(){
   			$("#cancelMod").click(function(){
   				history.back();
   			})  
        });
 
		function fn_enable(obj){
			document.getElementById("i_title").disabled=false;
			document.getElementById("i_content").disabled=false;
			document.getElementById("tr_btn_modify").style.display="block";
			document.getElementById("tr_btn").style.display="none";
			document.querySelector(".reply").style.display="none";
			document.querySelector(".modify-hidden").style.display="block";
			document.querySelector(".section-hidden").style.display="none";
		}
		 
		function fn_modify_article(obj){
			obj.action="${contextPath}/board/modArticle.do";
			obj.submit();
		}
		 
		function fn_remove_board(url,boardNo){
			var form = document.createElement("form");
			form.setAttribute("method", "post");
			form.setAttribute("action", url);
		    var articleNoInput = document.createElement("input");
		    articleNoInput.setAttribute("type","hidden");
		    articleNoInput.setAttribute("name","boardNo");
		    articleNoInput.setAttribute("value", boardNo);
			 
		    form.appendChild(articleNoInput);
		    document.body.appendChild(form);
		    form.submit();
		}
		 
		$(document).ready(function(){
			$("#writeReplyBtn").click(function(){
				var replyContent = document.replyForm.r_content.value;
				if(replyContent==""){
					alert("내용을 입력하세요")
					document.replyForm.r_content.focus();
					return;
				}
				alert("댓글이 작성되었습니다");
				document.replyForm.submit();
			})
		})

 </script>
 <style>
 	
    #i_content {
    	width: 99%;
    	height: 17em;
    	resize: none;
    }
   
	#tr_btn_modify{
		display: none;  
	}
	
	.reply {
		margin-top: 30px;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		margin-bottom: 100px;
	}
	
	.reply-form {
		border: 1px solid #b3b3b3;
		border-radius: 4px;
		padding: 10px;
		width: 50%;
	}
	
	.reply-form_form {
		display: flex;
		flex-direction: column;
	}
	
	.reply-form_form div {
		align-self: flex-start;
		margin-bottom: 5px;
	}
	
	.reply-form_form textarea {
		resize: none;
		height: 5em;
		margin-bottom: 5px;
	}
	
	.comment {
		margin: 30px 0;
		padding-bottom: 15px;
		width: 50%;
		text-align: left;
		font-size: 20px;
		border-bottom: 1px solid #b3b3b3;
	}
	
	.reply-border {
		border-bottom: 1px solid #b3b3b3;
	}
	
	.reply-area {
		width: 50%;
	}
	
	.reply-area ol {
		list-style: none;
		align-self: center;
	}
	
	.reply-user,.reply-content {
		display: flex;
		justify-content: space-between;
	}
	
	.reply-user span:last-child {
		font-size: 13px;
		color: #b3b3b3;
	}
	.reply-content p {
		font-size: 15px;
		text-align: left;
	}
	
	.reply-content a {
		margin-top: 12px;
		text-decoration: none;
    	color: black;
	}
	
	.board-from {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	
	.reply-form a {
		text-decoration: none;
    	color: black;
	}
	
	.board-content {
		width:80%;
		text-align: left;
	}
	
	.board-content span:first-child {
		color: rgb(138, 138, 138);
	}
	
	.board-content #title {
		font-size: 40px;
		font-weight: 800;
		margin-bottom: 15px;
	}
	
	.board-content_user {
		display: flex;
		padding: 5px;
		border-bottom: 1px solid #b3b3b3;
		margin-bottom: 20px;
		color: rgb(138, 138, 138);
	}
	
	.board-content_user span:first-child {
		padding-right: 15px;
		margin-right: 15px;
		border-right: 1px solid #b3b3b3;
	}
	
	.board-content_area {
		width: 100%;
    	height: 20em;
    	resize: none;
    	border: none;
    	background-color: white;
	}
		
	.modify-hidden {
		display: none;
	}
	
	.modify {
		width: 85%;
		margin-bottom: 20px;
	}

	.modify-hidden_header {
		display: flex;
	}
	
	.header_writer,
	.header_title,
	.modify-hidden_body {
		display: flex;
		flex-direction: column;
		align-items: flex-start;
		justify-content: flex-start;
		margin-right: 30px;
	}
	
	.header_title {
		width: 70%;
	}
	
	.header_writer input,
	.header_title input {
		border: 1px solid transparent;
   		border-bottom: 1px solid #ccc;
   		border-radius: 3px;
	    padding: 0.375rem 0.75rem;
	    line-height: 1.5;
	    height: 2.75em;
	}
	
	.header_writer input:disabled {
		 background: #FFFFFF;
	}
	
	.header_title input {
		width: 100%;
	}
	
	input[type="button"] {
		border: none;
    	display: inline-block;
	    padding: 0 0.5em;
	    line-height: 2em;
	    text-decoration: none;
	    color: black !important;
	    background-color: #b3b3b3;
	    border-radius: 5px;
	}
	
	</style>
</head>
<body>
	<form class="board-from" name="frmArticle" method="post"  action="${contextPath}" enctype="multipart/form-data">
		
<!-- 게시글 보기 -->
		<section class="board-content section-hidden">
			<span>${boardVO.b_type}</span>
			<div id="title">${boardVO.b_title}</div>
			<div class="board-content_user">
				<span><i class="fa-solid fa-user"></i>${boardVO.user_id}</span>
				<span><fmt:formatDate value="${boardVO.b_date}" pattern="yyyy-MM-dd" /></span>
			</div>
			<article class="board-content_area" >
			${fn:replace(boardVO.b_content, replaceChar, "<br/>")}
			</article>
		</section>


<!-- 게시글 수정 -->
	<div class="modify modify-hidden">
		<input type="hidden" name="boardNo" value="${boardVO.boardNo}"/>
		<div class="modify-hidden_header">
			<div class="header_writer">
				<h3>작성자</h3>
				<input type=text value="${boardVO.user_id}" name="user_id"  disabled />
			</div>
			<div class="header_title">
				<h3>제목</h3>
				<input type=text value="${boardVO.b_title}" name="b_title" id="i_title" disabled />
			</div>
		</div>
		<div class="modify-hidden_body">
			<h3>내용</h3>
			<textarea rows="20" cols="60" name="b_content" id="i_content" disabled >${boardVO.b_content}</textarea>
		</div>    
	</div>
 
 <div id="tr_btn">
   <div>
       <c:if test="${sessionScope.user.user_id == boardVO.user_id }">
	      <input type=button value="수정하기" onClick="fn_enable(this.form)">
	      <input type=button value="삭제하기" onClick="fn_remove_board('${contextPath}/board/removeBoard.do', ${boardVO.boardNo})">
	   </c:if>
	      <input type=button value="글 목록보기"  id="backToList">
   </div>
  </div>
  
  <div id="tr_btn_modify" align="center"  >
	   <div>
	       <input type=button value="수정반영하기" onClick="fn_modify_article(frmArticle)"  >
           <input type=button value="취소" id="cancelMod">
	   </div>
  </div>
 
 </form>
 
<!-- 댓글 -->
	<section class="reply">
		<div class="reply-form">
			<c:choose>
		    	<c:when test="${sessionScope.user.user_id eq null}">
					<a href="${contextPath}/user/loginForm.do">댓글쓰기 권한이 없습니다. 로그인 하시겠습니까?</a>
		    	</c:when>
		    	<c:otherwise>
				<form name="replyForm" method="post" action="${contextPath}/board/writeReply.do?baordNo=${boardVO.boardNo}">
				  <input type="hidden" id="boardNo" name="boardNo" value="${boardVO.boardNo}" />
				  <input type="hidden" id="r_writer" name="r_writer" value="${sessionScope.user.user_id}" />
				  <div class="reply-form_form">
				  	<div>
					  	<i class="fa-solid fa-user"></i>
					    <span>${sessionScope.user.user_id}</span>
				    </div>
				    <textarea id="r_content" name="r_content" placeholder="내용" ></textarea>
				  </div>
				  <div>
				  	<input type="button" value="작성" id="writeReplyBtn">
				  </div>
				</form>
				</c:otherwise>
			</c:choose>
		</div>
		
		<div class="comment">
			<span><i class="fa-regular fa-message"></i>댓글</span>
		</div>
		<c:choose>
			<c:when test="${empty replyList}">
				<p align="center">
					<b><span style="font-size:10pt;">등록된 댓글이 없습니다.</span></b>
				</p>
			</c:when>
			<c:when test="${!empty replyList}">
				<div class="reply-area">
				  <div class="replyList">
				    <c:forEach items="${replyList}" var="replyVO">
				      <div class="reply-border">
				      	<div class="reply-user">
				      	   	<span><i class="fa-solid fa-circle-user"></i>${replyVO.r_writer}</span>
				        	<span><fmt:formatDate value="${replyVO.r_date}" pattern="yyyy-MM-dd" /></span>
						</div>
						<div class="reply-content">
					        <p>${fn:replace(replyVO.r_content, replaceChar, "<br/>")}</p>
					        <c:if test="${sessionScope.user.user_id == replyVO.r_writer }">
					        	<a href="${contextPath}/board/deleteReply.do?baordNo=${boardVO.boardNo}&replyNo=${replyVO.replyNo}">삭제</a>
					        </c:if>
					    </div>
				      </div>
				    </c:forEach>
				  </div>
				</div>
			</c:when>
		</c:choose>
	</section>
</body>
</html>