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
<script type="text/javascript" src="js/sortMode2.js"></script>
<title>Sorting Visualization</title>
</head>
<body onload="init();">
	<div id="wrapper" style="height: auto;">
		<div id="header" style="height: auto;">
			<jsp:include page="/header.jsp" />
		</div>
		<div id="main" style="text-align: center; width: 950px; height: auto;">
			<ul class="submenunav">
				<span id="menu0"
					onclick="if(isStart == 0 || stop == 1){mode = 0; init();}">
					Bubble Sort </span>
				<span id="menu1"
					onclick="if(isStart == 0 || stop == 1){mode = 1; init();}">
					Insertion Sort </span>
				<span id="menu2"
					onclick="if(isStart == 0 || stop == 1){mode = 2; init();}">
					Shell Sort </span>
				<span id="menu4"
					onclick="if(isStart == 0 || stop == 1){mode = 4; init(); }">
					Selection Sort </span>
				<span id="menu6"
					onclick="if(isStart == 0 || stop == 1){mode = 6; init();}">
					Quick Sort </span>
			</ul>
			<div id="buttons_2">
				<select
					onchange="location = this.options[this.selectedIndex].value;">
					<option value="">Select Mode</option>
					<option value="sort?mode=1">Mode1</option>
					<option value="sort?mode=2">Mode2</option>
					<option value="sort?mode=3">Mode3</option>
				</select> &nbsp;&nbsp;Random Array
				<button style="margin-left: 10px" onclick=" init();">Random</button>
				<button onclick=" restartAnimation();">Go</button>
				<button onclick="stopAnimation();">stop</button>
			</div>
			<div id="content" align="center">
				<canvas id="myCanvas" width="950px" height="589"></canvas>
			</div>
		</div>




		<div id="footer" style="height: auto;">
			<jsp:include page="/tail.jsp" />
		</div>
	</div>
</body>
</html>