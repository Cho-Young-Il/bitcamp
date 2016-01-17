<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Refresh" content="2; url=add">
<link rel="stylesheet" type="text/css" href="../css/headStyle.css"/>
<link rel="stylesheet" type="text/css" href="../css/basicStyle.css" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" />
<script type="text/javascript" src="../time.js"></script>
<title>회원가입 양식 오류</title>
</head>
<body>
	<div id="wrapper" style=" height:auto; ">
		<div id="header" style="height:auto;">
			<jsp:include page="/header.jsp"/>
		</div>
		
		<div id="main" style="text-align:center; height:732px;">
			 <div style="height: 375px; padding-top:150px; padding-bottom:150px;">
				 <font style="font-size: 30px; font-weight: bolder;">
					<br /><br /><br /><br />
					양식에 올바르게 맞추어 작성해 주시기 바랍니다. <br /> 
					잠시후 이전 페이지로 다시 이동합니다.
				</font>
			</div>
		</div>
		
		<div id="footer" style="height: auto;">
			<jsp:include page="/tail.jsp"/>
		</div>
	</div>
</body>
</html>
