<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.spring.petshop.user.vo.UserVO" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
UserVO userVO = (UserVO) session.getAttribute("user");
String user_id = userVO.getUser_id();
%>


<html>
<head>
<meta charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<!-- 글꼴 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap"
	rel="stylesheet">
<!-- local CSS -->
<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
<link rel="stylesheet" href="${contextPath}/resources/css/mypage.css">
<!-- jQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>마이페이지</title>
</head>
<body>

	<c:forEach var="user" items="${usersList}">
		<div class="container">
			<div class="main-body">
				<div class="row gutters-sm">
					<div class="col-md-4 mb-3">
						<div class="card">
							<div class="card-body">
								<div class="d-flex flex-column align-items-center text-center">
									<img src="https://bootdey.com/img/Content/avatar/avatar7.png"
										alt="Admin" class="rounded-circle" width="150">
									<div class="mt-3">
										<h4>${user.user_id }</h4>
										<p class="text-secondary mb-1">${user.u_name }</p>
										<p class="text-muted font-size-sm">${user.u_address }</p>
										<button class="btn btn-primary">장바구니</button>
										<button class="btn btn-outline-primary">로그아웃</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-8">
						<div class="card mb-3">
							<div class="card-body">
								<div class="row">
									<div class="col-sm-3">
										<h6 class="mb-0">아이디</h6>
									</div>
									<div class="col-sm-9 text-secondary">${user.user_id }</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h6 class="mb-0">비밀번호</h6>
									</div>
									<div class="col-sm-9 text-secondary">${user.u_pwd }</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h6 class="mb-0">이름</h6>
									</div>
									<div class="col-sm-9 text-secondary">${user.u_name }</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h6 class="mb-0">전화번호</h6>
									</div>
									<div class="col-sm-9 text-secondary">${user.u_phone }</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-3">
										<h6 class="mb-0">주소</h6>
									</div>
									<div class="col-sm-9 text-secondary">${user.u_address }</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-12">
										<a class="btn btn-success" data-bs-toggle="collapse" href="#item_table" role="button" aria-expanded="false" aria-controls="item_table">구매목록</a>
										<div id="item_table" class="collapse">
											<div class="card card-body">
											<table class="table">
												<thead>
													<tr>
														<th scope="col">번호</th>
														<th scope="col">이름</th>
														<th scope="col">분류</th>
														<th scope="col">가격</th>
														<th scope="col">삭제</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${purchaseList}">
														<tr>
															<th>${item.itemno}</th>
															<td>${item.i_name}</td>
															<td>${item.i_class}</td>
															<td>${item.i_price}</td>
															<td><a
																href="${contextPath}/user/removeItem.do?item=${item.itemno }">삭제하기</a></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
											</div>
										</div>
										<a class="btn btn-info" target="__blank"
											href="${contextPath}/user/modifyForm.do?id=${user.user_id }">수정하기</a>
										<a class="btn btn-danger" target="__blank"
											href="${contextPath}/user/removeUser.do?id=${user.user_id }">삭제하기</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</c:forEach>
</body>
</html>
