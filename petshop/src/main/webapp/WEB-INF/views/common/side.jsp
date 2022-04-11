<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	font-size: 24px;
	font-family: "Malgun Gothic", Gulim, Dotum, Gungsuh, sans-serif;
	font-weight: bold;
	display: flex;
	justify-content: space-around;
	height: 35px;
}

.side_title {
	font-size: 30px;
	font-family: "Malgun Gothic", Gulim, Dotum, Gungsuh, sans-serif;
	font-weight: bold;
}
</style>
</head>
<body>
<div class="accordion" id="accordionExample">
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingOne">
      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
        카테고리
      </button>
    </h2>
    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
      <div class="accordion-body">
      	<a href="/petshop/item/itemListForm.do?i_class=음식" class="side_menu">음식</a>
	<hr>
		<a href="/petshop/item/itemListForm.do?i_class=옷" class="side_menu">옷</a>
	<hr>
		<a href="/petshop/item/itemListForm.do?i_class=기타" class="side_menu">기타</a>
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingTwo">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
        회사소개
      </button>
    </h2>
    <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
      <div class="accordion-body">
       <!-- 내용2 -->
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingThree">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
        고객센터
      </button>
    </h2>
    <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        <!-- 내용3 -->
      </div>
    </div>
  </div>
</div>
</body>
</html>