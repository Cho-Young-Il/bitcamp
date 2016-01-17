<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/headStyle.css" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" />
<script type="text/javascript" src="../time.js"></script>
<title>오류!</title>
<style>
html, body, table {
	height: auto;
}

div {
	width: auto;
	height: auto;
}
</style>
</head>
<body>
	<div id="wrapper" style="height: auto;">
		<div id="header" style="height: auto;">
			<jsp:include page="/header.jsp" />
		</div>

		<div id="main"
			style="text-align: center; height: auto; padding-top: 150px; padding-bottom: 150px;">
			<div style="height: 430px;">
				<font style="font-size: 30px; font-weight: bolder;"> <br />
				<br />
				<br />
				<br /> 요청을 처리하는 중에 문제가 발생하였습니다.<br /> 주소를 다시한번 확인하시고 요청하시기 바랍니다.<br />
					만약 계속해서 이 문제가 발생하게 된다면 운영팀에 연락하시기 바랍니다.
				</font>
			</div>
		</div>

		<div id="footer" style="height: auto;">
			<jsp:include page="/tail.jsp" />
		</div>
	</div>
</body>
</html>
