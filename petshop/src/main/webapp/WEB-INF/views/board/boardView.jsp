<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
 
<c:set var="article"  value="${articleMap.article}"  />
<c:set var="imageFileList"  value="${articleMap.imageFileList}"  />

<%
  request.setCharacterEncoding("UTF-8");
%> 

<head>
   <meta charset="UTF-8">
   <title>글보기</title>
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
   <script type="text/javascript" >
   
   		$(function(){
   			$("#backToList").click(function(){
   				history.back();
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
	 
	 function fn_reply_form(url, parentNO){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var parentNOInput = document.createElement("input");
	     parentNOInput.setAttribute("type","hidden");
	     parentNOInput.setAttribute("name","parentNO");
	     parentNOInput.setAttribute("value", parentNO);
		 
	     form.appendChild(parentNOInput);
	     document.body.appendChild(form);
		 form.submit();
	 }
	 
	 function readURL(input) {
	     if (input.files && input.files[0]) {
	         var reader = new FileReader();
	         reader.onload = function (e) {
	             $('#preview').attr('src', e.target.result);
	         }
	         reader.readAsDataURL(input.files[0]);
	     }
	 }  
 </script>
 <style>
    textarea {
    	width: 100%;
    	height: 30em;
    	border: none;
    	resize: none;
    }
   
	#tr_btn_modify{
		display:none;  
	}
		
   </style>
</head>
<body>

  <form name="frmArticle" method="post"  action="${contextPath}"  enctype="multipart/form-data">
  <table border=0 align="center">
  <tr>
   <td>
    <input type="hidden" name="boardNo" value="${boardVO.boardNo}"  />
   </td>
  </tr>
  <tr>
    <td width="150" align="center" bgcolor="#C0C0C0">
      작성자 아이디
   </td>
   <td >
    <input type=text value="${boardVO.user_id }" size="100%" name="user_id"  disabled />
   </td>
  </tr>
  <tr>
    <td width="150" align="center" bgcolor="#C0C0C0">
      제목 
   </td>
   <td>
    <input type=text value="${boardVO.b_title }" size="100%" name="b_title" id="i_title" disabled />
   </td>   
  </tr>
  <tr>
    <td width="150" align="center" bgcolor="#C0C0C0">
      내용
   </td>
   <td>
    <textarea rows="20" cols="60"  name="b_content"  id="i_content"  disabled >${boardVO.b_content }</textarea>
   </td>  
  </tr>
  <tr>
	<td width="150" align="center" bgcolor="#C0C0C0">
	  등록일자
	</td>
	   <td>
	    <input type=text value="<fmt:formatDate value="${boardVO.b_date}" />" size="100%" disabled />
	   </td>
  </tr>
  
  <tr  id="tr_btn"    >
   <td colspan="2" align="center">
       <c:if test="${sessionScope.user.user_id == boardVO.user_id }">
	      <input type=button value="수정하기" onClick="fn_enable(this.form)">
	      <input type=button value="삭제하기" onClick="fn_remove_board('${contextPath}/board/removeBoard.do', ${boardVO.boardNo})">
	   </c:if>
	      <input type=button value="리스트로 돌아가기"  id="backToList">
	      <input type=button value="답글쓰기"  onClick="fn_reply_form('${contextPath}/board/replyForm.do', ${boardVO.boardNo})">
   </td>
  </tr>
  
  <tr id="tr_btn_modify" align="center"  >
	   <td colspan="2"   >
	       <input type=button value="수정반영하기" onClick="fn_modify_article(frmArticle)"  >
           <input type=button value="취소" id="cancelMod">
	   </td>   
  </tr>


 </table>

 </form>
</body>
</html>