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
<link rel="stylesheet" type="text/css" href="../css/formStyle.css" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" />
<script type="text/javascript" src="../time.js"></script>
<script type="text/javascript" src="../view/board/js/validityInspector.js"></script>
<title>자유 게시판</title>
</head>
<body>
	<div id="wrapper" style="height: auto;">
		<div id="header" style="height: auto;">
			<jsp:include page="/header.jsp" />
		</div>
		<div id="main">
			<form name="rform" action="<%=request.getContextPath()%>/board/regist" id="msform"
				method="post" enctype="multipart/form-data">
				<fieldset>
					<h1 class="fs-title">REGIST NEW CONTENT</h1>
					<input type="hidden" name="writer_name"
						value="${sessionScope.member.name}" /> <input type="hidden"
						name="writer_id" value="${sessionScope.member.id}" /> <input
						type="text" name="title" placeholder="Title" /> <input type="text"
						name="writer"
						value="${sessionScope.member.name} ( ${sessionScope.member.id} ) "
						readonly />
					<textarea rows="20" cols="70" name="content" placeholder="Content">${board.content}</textarea>
					<input type="file" name="attachFile1" /> <br /> <input type="file"
						name="attachFile2" /> <input type="button"
						class="submit action-button" value="Regist"
						onclick="registBoardInspector();" /> <input
						type="Reset" name="Reset" class="reset action-button"
						value="Reset" />
				</fieldset>
			</form>
		</div>
		<div id="footer" style="height: auto;">
			<jsp:include page="/tail.jsp" />
		</div>
	</div>
</body>
</html>