<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   .main {
       width: 320px;
       height: 400px;
       display: flex;
      justify-content: center;
       align-items: center;
       flex-direction: column;
       border: 1px solid lightgrey;
       border-radius: 5px;
   }

   #login {
      display: block;
       background-color: silver;
       border-color: transparent;
       color: white;
   }
   
   #login:hover{
      background:black;
   }
   
   .input {
       display: block;
       margin-bottom: 3px;
       padding: 3px;
       border: 1px solid lightgray;
       border-radius: 3px;
       justify-content: center;
       width: 80%;
       height: 8%;
   }
   
   form{
      display: flex;
      justify-content: center;
       align-items: center;
   }
</style>
</head>
<body>
   <form action="${contextPath}/user/login.do" method="post">   
      <div class="main">
            <img src="${contextPath }/resources/image/dog.jpg"><br><br>
            <input type="text" name="user_id" placeholder="아이디를 입력하세요" class="input" required><br>
            <input type="password" name="u_pwd" placeholder="비밀번호를 입력하세요" class="input" required><br><br>
            <input type="submit" value="로그인" class="input" id="login">
      </div>
   </form>
</body>
</html>