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
<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
<link rel="shortcut icon" href="${contextPath }/resources/image/logo1.png"/>
<title>헤더</title>
</head>
<body>
<header>
   <div class="header">
      <div class="header_column">
         <a href="${contextPath }">
              <img src="${contextPath }/resources/image/logo1.png">
           </a>
       </div>
       <div class="header_column">
           <h1>Dog Brand</h1>
       </div>
       <div class="header_column">
           <ul class="login_menu">
              <c:choose>
                  <c:when test="${isLogOn=='true' }">
                     <li><a href="/petshop/user/modMember.do?id=${user.user_id }">${user.user_id }</a></li>
                     <li><a href="/petshop/user/logout.do">로그아웃&nbsp;&nbsp;</a></li>
                  </c:when>
                  <c:otherwise>
                     <li><a href="/petshop/user/login.do" class="no-underline">로그인&nbsp;&nbsp;</a></li>
                  </c:otherwise>
               </c:choose>
               <li><a href="/petshop/user/register.do">회원가입&nbsp;&nbsp;</a></li>
               <li>장바구니&nbsp;&nbsp;</li>
               <li><a href="/petshop/board/board.do">게시판&nbsp;&nbsp;</a></li>
               <li><a href="/petshop/user/myPage.do">마이페이지</a></li>
           </ul>
       </div>
   </div>
</header>
</body>
</html>