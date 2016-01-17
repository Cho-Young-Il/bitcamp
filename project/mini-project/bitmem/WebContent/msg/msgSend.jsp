<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/headStyle.css" />
<link rel="stylesheet" type="text/css" href="../css/formStyle.css"/>
<link rel="stylesheet" type="text/css" href="../css/basicStyle.css" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" />
<script type="text/javascript" src="../time.js"></script>
<script type="text/javascript" src="../msg/js/validityInspector.js"></script>
<title>쪽지 보내기</title>
<style>

	#boxmenu {
		padding-left: 180px;
		margin-top: 20px;
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
		text-decoration: none;
	}
	#boxmenu > span > a:hover {
		text-decoration: underline;
	}
	
</style>
</head>
<body>
<div id="wrapper">
		<div id="header">
			<jsp:include page="/header.jsp" />
		</div>

		<div class="main">
			<div id="boxmenu">
				<span class="sList" ><a href="sendList">보낸쪽지함</a></span>
				<span class="rList" ><a href="receiveList">받은쪽지함</a></span>
				<span class="send" ><a href="msgSend">쪽지보내기</a></span>
			</div>
			<form action="${pageContext.request.contextPath}/msg/msgSend"
				method="post" id="msform" name="msform">
				<fieldset>
					<h1 class="fs-title">SEND A MESSAGE</h1>
					
					<div style="float: right;padding: 15px;
								border: 1px solid #ccc;
								border-radius: 3px;
								margin-bottom: 10px;
								width: 100%;
								box-sizing: border-box;
								
								color: #2C3E50;
								font-size: 13px;
								margin-top: 3px;">
					Receiver
					<select name="receiver">
							<c:forEach var="member" items="${list}">
								<c:if test="${member.permission eq 1}">
									<option value="${member.id}">
										아이디: <c:out value="${member.id}"/> 이름: <c:out value="${member.name}"/> 기수: 
										<c:choose>
											<c:when test="${member.classNo eq 0 and member.auth eq 'S'}">
												관리자
											</c:when>
											<c:when test="${member.classNo eq 0 and member.auth eq 'U'}">
												강사
											</c:when>
											<c:otherwise>
												<c:out value="${member.classNo}"/>
											</c:otherwise>
										</c:choose>
									</option>
								</c:if>
							</c:forEach>
					</select>
					</div>
					<textarea rows="20" cols="90" name="content"
							  placeholder="Input Message"></textarea>
					<input type="button" class="submit action-button"
			   			   value="Send" onclick="sendMsgInspector();" />
					<input type="Reset" name="Reset" class="reset action-button" value="Reset" />
				</fieldset>
			</form>
		</div>

		<div id="footer">
			<jsp:include page="/tail.jsp" />
		</div>
	</div>

</body>
</html>
