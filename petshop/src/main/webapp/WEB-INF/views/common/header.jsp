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
<title>헤더</title>
</head>
<body>
   <table border="0" width="100%">
      <tr>
         <td>
            <a href="${contextPath }">
               <img src="${contextPath }/resources/image/logo1.png">
            </a>
            <h4>pet shop</h4>
         </td>
         <td>
            <h1><font size="50">Dog Brand</font></h1>
         </td>
         <td>
            <c:choose>
               <c:when test="${isLogOn=='true' }">
                  <a href="/pro12/member/modMember.do?id=${member.id }"><h4>${member.id }</h4></a>
                  <a href="/pro12/member/logout.do"><h4>로그아웃</h4></a>
               </c:when>
               <c:otherwise>
                  <a href="/pro12/member/loginForm.do"><h4>로그인</h4></a>
               </c:otherwise>
            </c:choose>
            <h4>장바구니</h4>
         </td>
         <td>
            <h4>회원가입</h4>
            <h4>게시판</h4>
         </td>
         <td>
            <h4>마이페이지</h4>
         </td>
      </tr>
   </table>
</body>
</html>