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
                     <a href="/pro12/member/modMember.do?id=${member.id }"><li>${member.id }</li></a>
                     <a href="/pro12/member/logout.do"><li>로그아웃&nbsp;&nbsp;</li></a>
                  </c:when>
                  <c:otherwise>
                     <a href="/pro12/member/loginForm.do" class="no-underline"><li>로그인&nbsp;&nbsp;</li></a>
                  </c:otherwise>
               </c:choose>
               <li>회원가입&nbsp;&nbsp;</li>
               <li>장바구니&nbsp;&nbsp;</li>
               <li>게시판&nbsp;&nbsp;</li>
               <li>마이페이지</li>
           </ul>
       </div>
   </div>
</header>
</body>
</html>