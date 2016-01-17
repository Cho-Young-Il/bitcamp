<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>프로젝트 영상모음</title>
<script type="text/javascript">
	function showVideo(url) {
		var video = document.getElementById("video");
		var videoBtn = document.getElementById("videoBtn");
		video.src = "https://www.youtube.com/embed/" + url;
		videoBtn.style.top = 140 + "px";
		video.style.top = 140 + "px";
	}
	function hideVideo() {
		var video = document.getElementById("video");
		var videoBtn = document.getElementById("videoBtn");
		video.src = "";
		video.style.top = -1000 + "px";
		videoBtn.style.top = -1000 + "px";
	}
</script>
</head>
<body>
	<div id="wrapper" style="height: auto;">
		<div id="header" style="height: auto;">
			<jsp:include page="/header.jsp" />
		</div>

		<div id="main">
			<div class="table3">
				<div class="row header">
					<div class="cell">번호</div>
					<div class="celltitle">제목</div>
				</div>

				<c:forEach var="video" items="${videos}">
					<div class="row">
						<div class="cell">
							<c:out value="${video.no}" />
						</div>
						<div class="celltitle">
							<a href="#" onclick="showVideo('${video.url}')">${video.title}</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div
			style="width: 950px; margin: 0 auto; text-align: center; margin-bottom: 20px;">
			<c:forEach var="i" begin="1" end="${size}">
				<c:choose>
					<c:when test="${i eq recentIndex}">&nbsp;${i}&nbsp;</c:when>
					<c:otherwise>
						<a href="main?index=${i}">&nbsp;${i}&nbsp;</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>			
		</div>
		
		<iframe id="video"
			style="position: absolute; background: black; top: -1000px;"
			width="950" height="536" frameborder="0" allowfullscreen></iframe>
		<button id="videoBtn" onclick="hideVideo()"
			style="width: 40px; height: 40px; position: absolute; top: -1000px; font-size: 20px">X</button>

		<div id="footer" style="height: auto;">
			<jsp:include page="/tail.jsp" />
		</div>
	</div>
</body>
</html>