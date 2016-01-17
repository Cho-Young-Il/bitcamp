<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/headStyle.css"/>
<link rel="stylesheet" type="text/css" href="../css/basicStyle.css"/>
<link rel="stylesheet" type="text/css" href="../css/formStyle.css"/>
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" />
<script type="text/javascript" src="../time.js"></script>
<script type="text/javascript" src="js/validityInspector.js"></script>
<style type="text/css">
</style>
<title>회원 가입</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="/header.jsp"/>
		</div>
		
		<div id="main">
			<jsp:include page="memberRegistForm.jsp"/>
		</div>
		
		<div id="footer">
			<jsp:include page="/tail.jsp"/>
		</div>
	</div>
</body>
</html>