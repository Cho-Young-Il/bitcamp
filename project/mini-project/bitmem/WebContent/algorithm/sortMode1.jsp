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
<title>Sorting Visualization</title>
</head>
<script type="text/javascript" src="js/sortMode1.js"></script>
<body onload="init();">
	<div id="wrapper" style="height: auto;">
		<div id="header" style="height: auto;">
			<jsp:include page="/header.jsp" />
		</div>
		<div id="main"
			style="text-align: center; width: 950px; height: auto; padding-top: 10px;">

			<ul class="submenunav">
				<span id="menu0"
					onclick="if(isStart == 0 || stop == 1){mode = 0; changeValue();}">
					Bubble Sort </span>
				<span id="menu1"
					onclick="if(isStart == 0 || stop == 1){mode = 1; changeValue();}">
					Insertion Sort </span>
				<span id="menu2"
					onclick="if(isStart == 0 || stop == 1){mode = 2; changeValue();}">
					Shell Sort </span>
				<span id="menu3"
					onclick="if(isStart == 0 || stop == 1){mode = 3; changeValue();}">
					Merge Sort </span>
				<span id="menu4"
					onclick="if(isStart == 0 || stop == 1){mode = 4; changeValue();}">
					Selection Sort </span>
				<span id="menu5"
					onclick="if(isStart == 0 || stop == 1){mode = 5; changeValue(); initHeap();}">
					Heap Sort </span>
				<span id="menu6"
					onclick="if(isStart == 0 || stop == 1){mode = 6; changeValue();}">
					Quick Sort </span>
			</ul>

			<div id="buttons_1">
				<select
					onchange="location =  this.options[this.selectedIndex].value;">
					<option value="">Select Mode</option>
					<option value="sort?mode=1">Mode1</option>
					<option value="sort?mode=2">Mode2</option>
					<option value="sort?mode=3">Mode3</option>
				</select> &nbsp INPUT &nbsp <input name="str" id="str" size=30
					value="3, 44, 38, 5, 47, 15, 36, 26, 27, 2"/>
				<button
					onclick=" if(isStart == 0 && stop == 0) changeValue(); if(mode == 5) initHeap();">
					Apply</button>
				<button onclick=" restartAnimation();">Go</button>
				<button onclick="stopAnimation();">stop</button>
			</div>
			<div id="content" style="padding-top: 70px;">
				<canvas id="myCanvas" width="950" height="550" />
			</div>

		</div>

		<div id="footer" style="height: auto;">
			<jsp:include page="/tail.jsp" />
		</div>
	</div>
</body>
</html>