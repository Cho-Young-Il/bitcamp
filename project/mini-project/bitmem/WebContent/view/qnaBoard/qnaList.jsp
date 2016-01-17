<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/headStyle.css" />
<link rel="stylesheet" type="text/css" href="../css/basicStyle.css" />
<link rel="stylesheet" type="text/css" href="../css/tableStyle.css" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" />
<script type="text/javascript" src="../time.js"></script>
<title>Q&amp;A</title>
</head>
<body>
	<div id="wrapper" style="height: auto;">

		<div id="header" style="height: auto;">
			<jsp:include page="/header.jsp" />
		</div>


		<div id="main" style="margin-top: 40px;">
			<div class="table">
				<div class="row header">
					<div class="cell">번호</div>
					<div class="cell">제목</div>
					<div class="cell">글쓴이</div>
					<div class="cell">조회수</div>
				</div>
				<c:forEach var="vo" items="${qnaList}">
					<div class="row">
						<div class="cell">
							<c:out value="${vo.no}" />
						</div>
						<div class="cell" style="font-size: 14px;">
							<a href='detail?no=${vo.no}'><c:out value="${vo.title}" /></a>
						</div>
						<div class="cell">
							<c:out value="${vo.writer}" />
						</div>
						<div class="cell">
							<c:out value="${vo.viewCnt}" />
						</div>
					</div>
				</c:forEach>
			</div>
			
			<div align="center" style="margin-bottom: 30px;">
				<a href='regist'>글쓰기</a>
			</div>
		</div>

		<div id="footer" style="height: auto;">
			<jsp:include page="/tail.jsp" />
		</div>
	</div>
</body>
</html>