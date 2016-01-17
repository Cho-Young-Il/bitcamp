<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../../css/headStyle.css" />
<link rel="stylesheet" type="text/css" href="../../css/basicStyle.css" />
<link rel="stylesheet" type="text/css" href="../../css/formStyle.css" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" />
<script type="text/javascript" src="js/validityInspector.js"></script>
<script type="text/javascript" src="../../time.js"></script>
<title>Q&amp;A</title>
</head>
<body>
	<div id="wrapper" style="height: auto;">

		<div id="header" style="height: auto;">
			<jsp:include page="/header.jsp" />
		</div>

		<div id="main">
			<form name="rform" action="${pageContext.request.contextPath}/qna/regist" id="msform"
				method="post">
				<fieldset>
					<h1 class="fs-title">REGIST NEW Q&amp;A</h1>
					<input type="text" name="title" placeholder="Title"/>
					<input type="text" name="writer" placeholder="Name"/>
					<textarea rows="20" cols="70" name="content" placeholder="Content">${board.content}</textarea>
					<input type="button"
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