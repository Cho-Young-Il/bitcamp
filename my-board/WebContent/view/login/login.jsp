<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<li><a href="">로그인</a></li>
				<li><a href="">회원가입</a></li>
				<li>OOO님 Welcome</li>
				<li><a href="">로그아웃</a></li>
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
		<form method="post" 
		      action="${pageContext.request.contextPath}/login/login">
			id : <input type="text" name="id" /><br />
			pass : <input type="password" name="pass" /><br />
			<input type="submit" value="로그인" />	
		</form>
	</div>
	<div class="footer">
		자바 77기에 권한이 있습니다.
	</div>	
</body>
</html>













