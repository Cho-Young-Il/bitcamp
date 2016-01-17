<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/headStyle.css" />
<link rel="stylesheet" type="text/css" href="../css/basicStyle.css" />
<link rel="stylesheet" type="text/css" href="../css/boardDetailStyle.css" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" />
<script type="text/javascript" src="../view/board/js/validityInspector.js"></script>
<script type="text/javascript" src="../time.js"></script>
<title>Q&amp;A</title>
</head>
<body>
	<div id="wrapper" style="height: auto;">
		<div id="header" style="height: auto;">
			<jsp:include page="/header.jsp" />
		</div>

		<div id="main" style="height: auto; margin-top: 70px; margin-bottom: 70px;">
			<blockquote class="default">
			<h1><span class="Cdefault"></span><c:out value="${qna.title}"/></h1>
			<div id="n_r">
		  		<div>
				  	<span id="name-id"><c:out value="${qna.writer}"/></span>
				  	<span id="reg-date"><c:out value="${qna.regDate}"/></span>
			  	</div>
			  	<div id="content">
					<textarea style="width:550px;" rows="20" cols="80" readonly><c:out value="${qna.content}"/></textarea>
				</div>
				
				<div id="cfoot">
					<a href="<%=request.getContextPath()%>/qna/list">목록</a><br/><br/><br/>
					<c:if test="${sessionScope.member.auth eq 'S' }">
						<a href="<%=request.getContextPath()%>/qna/qnadelete?no=${qna.no}">삭제</a>
					</c:if>
				</div>
				
				<c:if test="${sessionScope.member.auth eq 'S' }">
					<form id="co-form" name="cform" action="${pageContext.request.contextPath}/qna/qnaCommentRegist" method="post">
						<input type="hidden" name="no" value="${qna.no}" />
						<textarea rows="4" cols="80" name="content" placeholder="Comment"></textarea>
						<input type="text" name="nick_name" value="${sessionScope.member.name}" readonly/>
						<input type="button" class="submit action-button" 
							   onclick="commentInspector();" value="Submit" />
					</form>
				</c:if>
				
				<div id="comment" style="border-top: 1px solid gray;">
					<c:forEach var="vo" items="${list}">
		
					<table style="width: 100%; padding-top: 5px;">
						<tr>
							<td width="25%">${vo.nickName} ( 관리자 )</td>
							<td>
								<fmt:formatDate value="${vo.regDate}"
								pattern="yyyy-MM-dd HH:mm" />
							</td>
				
							<c:if test="${sessionScope.member.auth eq 'S'}">
							<td>
								<a href="qnaCommentDelete?commentNo=${vo.commentNo}&no=${vo.no}">삭제</a>
							</td>
							
							</c:if>
						</tr>
						</table>
						<table style="width: 100%; table-layout: fixed;
									 word-wrap: break-word; padding:10px;">
						<tr>
							<td><c:out value="${vo.content}"/></td>
						</tr>
						</table>
					<br />
					
		
					
					</c:forEach>
				</div>
		  	</div>
			</blockquote>
		</div>
		<div id="footer" style="height: auto;">
			<jsp:include page="/tail.jsp" />
		</div>
	</div>
</body>
</html>