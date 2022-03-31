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
   .no-underline {
      text-decoration: none;
      color: black;
   }
</style>
</head>
<body>
   <h1>카테고리</h1><br>
   <h1>
      <a href="/petshop/item/itemListForm.do?i_class=음식" class="no-underline">음식</a><br><br>
      <a href="/petshop/item/itemListForm.do?i_class=옷" class="no-underline">옷</a><br><br>
      <a href="#" class="no-underline">기타</a><br>
   </h1>
</body>
</html>