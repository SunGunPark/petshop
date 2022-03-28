<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
  String id = request.getParameter("id");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 정보 수정창</title>
<style>
   .text_center{
     text-align:center;
   }
</style>
</head>
<body>
	<form method="post" action="${contextPath}/user/modUser.do">
	<h1  class="text_center">회원 정보 수정창</h1>
	<table  align="center">
	   <tr>
	      <td width="200"><p align="right">아이디</td>
	      <td width="400"><input type="text" name="user_id" value="${param.id }" readonly="readonly">
	      </td>
	      <input type="hidden" name="action" value="mod">
	   </tr>
	   <tr>
	      <td width="200"><p align="right">비밀번호</td>
	      <td width="400"><input type="password" name="u_pwd" value="${userVO.u_pwd }"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">이름</td>
	       <td width="400"><p><input type="text" name="u_name" value="${userVO.u_name }"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">전화번호</td>
	       <td width="400"><p><input type="text" name="u_phone" value="${userVO.u_phone }"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">주소</td>
	       <td width="400"><p><input type="text" name="u_address" value="${userVO.u_address }"></td>
	    </tr>
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="수정하기">&nbsp;&nbsp;<input type="reset" value="다시입력"></td>
	    </tr>
	</table>
	</form>
</body>
</html>