<%@ page language="java" contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
		   prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
		   prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"
		   prefix="fmt" %>
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
<title>Message Box</title>
<style>

	#boxmenu {
		padding-left: 100px;
	}
	#boxmenu > span{
	    font: normal 13px/30px 'Jeju Gothic', serif;
	    background-color: hsl(180, 40%, 60%);
	    color : white;
		width: 100px;
	    height: 30px;
	    padding: 5px;
	    text-align: center;
	    line-height: 30px;
	    border-radius: 5px;
	    font-weight: bold;
	    margin-right: 5px;
	    display: inline-block;
	}
	#boxmenu > span > a {
		color: white;
	}
	
</style>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="/header.jsp" />
		</div>
		
	
		<div id="main" style="height: 700px;overflow:scroll;padding:10px;">
			<div id="boxmenu">
				<span class="sList" ><a href="sendList">보낸쪽지함</a></span>
				<span class="rList" ><a href="receiveList">받은쪽지함</a></span>
				<span class="send" ><a href="msgSend">쪽지보내기</a></span>
			</div>
			<h1 style="font-family: 'Jeju Gothic', serif; margin: 20px; margin-left: 140px;">받은 쪽지함</h1>
			<div class="table4" >
				<div class="row header">
					<div class="cell" style="width: 70px;">
						보낸사람
					</div>
					<div class="cell" style="width: 100px;">
						받은시간
					</div>
					<div class="cellcontent">
						내용
					</div>
					<div class="cell" style="width: 50px;">
						삭제
					</div>
				</div>
				
				<c:forEach var="receiveList" items="${receiveList}">
					<div class="row">
						<div class="cell" style="width: 70px;">
							<c:out value="${receiveList.sender}"/>
						</div>
						<div class="cell"style="width: 100px;">
							<fmt:formatDate value="${receiveList.regDate}" pattern="yyyy-MM-dd HH:mm"/>
						</div>
						<div class="cellcontent">
							<c:out value="${receiveList.content}"/>
						</div>
						<div class="cell" style="width: 50px;">
							<a href="receiveDelete?no=${receiveList.no}&id=${sessionScope.member.id}">삭제</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		
		<div id="footer">
			<jsp:include page="/tail.jsp" />
		</div>
	</div>
</body>
</html>
