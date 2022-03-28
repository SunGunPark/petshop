<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:choose>
<c:when test="${result=='registerFailed' }">
	<script>
		window.onload = function(){
			alert('중복된 아이디가 있습니다. 다시 회원가입 하세요.');
		}
	</script>
</c:when>
</c:choose>
<%
   request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<script>
function check() {
    var f = document.register; 
    if (f.userid.value == "") {
        alert("아이디를 입력해주십시오");
        f.userid.focus();
        return false;
    }
    if (f.pwd.value == "") {
        alert("비밀번호를 입력해주십시오");
        f.pwd.focus();
        return false;
    }
    if (f.name.value == "") {
        alert("이름을 입력해주십시오");
        f.name.focus();
        return false;
    }
    if (f.phone.value == "") {
        alert("휴대전화를 입력해주십시오");
        f.phone.focus();
        return false;
    }
    if (f.address.value == "") {
        alert("주소를 입력해주십시오");
        f.address.focus();
        return false;
    }
}   
</script>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${contextPath}/resources/css/register.css">
<title>회원 가입창</title>
</head>
<body>
   <form name="register" method="post" onsubmit="return check()" action="${contextPath}/user/register.do">
          <div class="register-page">
            <div class="form">
              <div class="form-group" id="divId">
                <label for="inputId" class="control-label">아이디</label>
                <div class=""><input type="text" class="control-label" name="user_id" data-rule-required="true" placeholder="아이디" maxlength="15" autocomplete="off" ></div>              
              </div>
              <div class="form-group" id="divPassword">
                <label for="inputPassword" class="control-label">비밀번호</label>
                <div class=""><input type="password" class="form-control"name="u_pwd" data-rule-required="true" placeholder="비밀번호" maxlength="15"></div>
              </div>
              <div class="form-group" id="divName">
                <label for="inputName" class="control-label">이름</label>
                <div class=""><input type="text" class="form-control onlyAlphabetAndNumber check" name="u_name" data-rule-required="true" placeholder="Name" maxlength="15" autocomplete="off"></div>
              </div>
              <div class="form-group" id="divPhonenumber">
                <label for="inputPhonenumber" class="control-label">휴대전화</label>
                <div class=""><input type="tell" class="form-control"  name="u_phone" data-rule-required="true" placeholder=" - 를 제외하고 숫자만 입력하세요" maxlength="11" autocomplete="off"></div>
              </div>
              <div class="form-group" id="divAddress">
                <label for="inputAddress" class="control-label">주소</label>
                <div class=""><input type="text" class="form-control onlyAlphabetAndNumber check" name="u_address" data-rule-required="true" placeholder="Address" maxlength="15" autocomplete="off"></div>
              </div>
              <button>가입하기</button>
            </div>
          </div>
      </form>
</body>