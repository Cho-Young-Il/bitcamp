<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/headStyle.css" />
<link rel="stylesheet" type="text/css" href="../css/basicStyle.css"/>
<link rel="stylesheet" type="text/css" href="../css/loginStyle.css"/>
<link rel="stylesheet" type="text/css" href="../css/mainBodyStyle.css"/>
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" />
<script type="text/javascript" src="../time.js"></script>
<title>Bitcamp Membership</title>
</head>
<body>
	<div id="wrapper" style="height: auto;">
		<div id="header" style="height: auto;">
			<jsp:include page="/header.jsp" />
		</div>

		<div id="main" style="text-align: center; height: auto;">
			<c:if
				test="${empty sessionScope.member and
						  empty sessionScope.member.id}">
				<jsp:include page="/auth/loginForm.jsp" />
			</c:if>

			<c:if
				test="${!empty sessionScope.member and
						  !empty sessionScope.member.id}">
				<jsp:include page="mainBody.jsp"/>
			</c:if>
		</div>

		<div id="footer" style="height: auto;">
			<jsp:include page="/tail.jsp" />
		</div>
	</div>
</body>
</html>
