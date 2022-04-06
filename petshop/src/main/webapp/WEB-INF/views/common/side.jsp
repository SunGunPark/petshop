<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   request.setCharacterEncoding("utf-8");
%>  
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사이드</title>
<style>
   .side_menu {
    text-decoration: none;
    color: black;
    font-size : 24px;
	font-family: "Malgun Gothic", Gulim, Dotum, Gungsuh, sans-serif;
	font-weight: bold;
	display: flex;
	justify-content: space-around;
   }
   .side_title {
       	font-size : 30px;
		font-family: "Malgun Gothic", Gulim, Dotum, Gungsuh, sans-serif;
		font-weight: bold;
   }
</style>
</head>
<body>
	<br>
   <div class="side_title">카테고리</div><br>
   <h1>
      <a href="/petshop/item/itemListForm.do?i_class=음식" class="side_menu">음식</a><br>
      <a href="/petshop/item/itemListForm.do?i_class=옷" class="side_menu">옷</a><br>
      <a href="#" class="side_menu">기타</a><br>
   </h1>
</body>
</html>