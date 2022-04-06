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
<title>푸터</title>
<style>
   p {
      font-size: 10px;
      text-align: center;
      	display: flex;
		justify-content: space-around;
   }
</style>
</head>
<body>
   <p>회사명 : 주식회사 빅데이터 플랫폼 기반 AI 융합 서비스 개발자 양성 과정 Project B team</p>
   <p>사업자등록번호 : 101-00-19999</p>
   <p>고객만족센터 : 01-1111-2222</p>
</body>
</html>