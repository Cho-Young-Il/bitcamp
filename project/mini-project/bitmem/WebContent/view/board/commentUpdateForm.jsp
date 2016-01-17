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
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" />
<script type="text/javascript" src="../time.js"></script>
<title>댓글 수정</title>
</head>
<body>
	<div id="wrapper" style="height: auto;">
		<div id="header" style="height: auto;">
			<jsp:include page="/header.jsp" />
		</div>
		<div id="main"
			style="text-align: center; width: 1300px; height: auto; padding-top: 10px; padding-bottom: 50px;">
			<h1>댓글 수정</h1>
			<form action="<%=request.getContextPath()%>/board/commentUpdate"
				method="post">
				<input type="hidden" name="no" value="${comment.no}" /> <input
					type="hidden" name="id" value="${sessionScope.member.id}" /> <input
					type="hidden" name="comment_no" value="${comment.comment_no}" />
				<table>
					<tr>
						<th>이름</th>
						<td><input type="text" name="name" value="${comment.name}"
							readonly /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><input type="text" name="content"
							value="${comment.content}" /></td>
					</tr>
				</table>
				<input type="submit" value="수정"> <a
					href="<%=request.getContextPath()%>/board/detail?no=${comment.no}">취소</a>
			</form>
		</div>

		<div id="footer" style="height: auto;">
			<jsp:include page="/tail.jsp" />
		</div>
	</div>
</body>
</html>