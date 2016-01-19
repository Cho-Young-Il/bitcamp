<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<h1>MyProject</h1>
		<div class="gnb">
			<ul>
				<c:choose>
					<c:when test="${empty user}">
						<li><a href="${pageContext.request.contextPath}/login/login">로그인</a></li>
						<li><a href="">회원가입</a></li>
					</c:when>
					<c:otherwise>
						<li>${user.name}님 Welcome</li>
						<li><a href="${pageContext.request.contextPath}/login/logout">로그아웃</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<div class="lnb">
			<ul>
				<li><a href="">이야기하기</a></li>
				<li><a href="">갤러리</a></li>
				<li><a href="">자료실</a></li>
				<li><a href="">묻고답하기</a></li>
			</ul>
		</div>
	</div>
	<div class="container">
		<h1>실제 내용이 표현될 부분</h1>
	</div>	
	<div class="footer">
		자바 77기에 권한이 있습니다.
	</div>	
</body>
</html>













