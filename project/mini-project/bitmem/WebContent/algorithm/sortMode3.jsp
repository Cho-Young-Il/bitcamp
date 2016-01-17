<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/headStyle.css" />
<link rel="stylesheet" type="text/css" href="../css/basicStyle.css" />
<link rel="stylesheet" type="text/css" href="../css/sortStyle.css" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" />
<script type="text/javascript" src="js/sortMode3.js"></script>
<title>Sorting Visualization</title>
</head>
<body onload="init();">
	<div id="wrapper" style="height: auto;">
		<div id="header" style="height: auto;">
			<jsp:include page="/header.jsp" />
		</div>
		<div id="main"
			style="text-align: center; width: 950px; height: auto; padding-top: 5px;">

			<ul id="buttons_3">
				<select
					onchange="location = this.options[this.selectedIndex].value;">
					<option value="">Select Mode</option>
					<option value="sort?mode=1">Mode1</option>
					<option value="sort?mode=2">Mode2</option>
					<option value="sort?mode=3">Mode3</option>
				</select>

				<button
					onclick="if(first == 0 || stop == 1 || !started()){first = 0; init();}">
					RandomSelect</button>
				<button style="width: 50px;"
					onclick="if(started() == false || stop == 1) {startSort(); stop = 0; first = 1;}">Go</button>
				<button style="width: 50px;" onclick="stopAnimation(); first = 1;">stop</button>
			</ul>

			<div id="content" align="center">
				<canvas id="myCanvas" width="860" height="634px"> </canvas>
			</div>

		</div>

		<div id="footer" style="height: auto;">
			<jsp:include page="/tail.jsp" />
		</div>
	</div>
</body>
</html>