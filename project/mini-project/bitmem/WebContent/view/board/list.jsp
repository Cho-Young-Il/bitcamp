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
<link rel="stylesheet" type="text/css" href="../css/tableStyle.css" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" />
<script type="text/javascript" src="../time.js"></script>
<style type="text/css">
</style>
<title>자유 게시판</title>
</head>

<body>
	<div id="wrapper" style="height: auto;">
		<div id="header" style="height: auto;">
			<jsp:include page="/header.jsp" />
		</div>
		<div id="main">
			<c:if test="${empty boardList}">
				게시물이 없습니다.
			</c:if>

			<c:if test="${!empty boardList}">
				<form action="<%=request.getContextPath()%>/board/delete"
					method="post">
					<div class="table">
						<div class="row header">
							<c:if test="${sessionScope.member.auth eq 'S'}">
								<div class="cell">
									<input type="submit" value="삭제">
								</div>
							</c:if>
							<div class="cell">번호</div>
							<div class="celltitle">제목</div>
							<div class="cell">글쓴이</div>
							<div class="cell">아이디</div>
							<div class="cell">조회수</div>
							<div class="cell">추천수</div>
						</div>

						<c:forEach var="board" items="${boardList}">
							<div class="row">
								<c:if test="${sessionScope.member.auth eq 'S'}">
									<div class="cell">
										<input type="checkbox" name="numbers" value="${board.no}" />
									</div>
								</c:if>
								<div class="cell">
									<c:out value="${board.no}" />
								</div>
								<div class="celltitle">
									<a
										href="<%=request.getContextPath()%>/board/detail?no=${board.no}&call=view_cnt"><c:out value="${board.title}"/></a>
								</div>
								<div class="cell">
									<c:out value="${board.writer_name}" />
								</div>
								<div class="cell">
									<c:out value="${board.writer_id}" />
								</div>
								<div class="cell">
									<c:out value="${board.view_cnt}" />
								</div>
								<div class="cell">
									<c:out value="${board.recom_cnt}" />
								</div>
							</div>
						</c:forEach>
					</div>
				</form>
			</c:if>
			<br>

			<table>
				<tr>
					<c:if test="${totalBoardCnt eq fn:length(boardList)}">
						<c:forEach var="page" begin="1" end="${totalPages}">
							<td><c:if test="${page eq curPage}">
									<a
										href="<%=request.getContextPath()%>/board/list?pageParam=${page}"
										style="text-decoration: underline; color: skyblue">${page}</a>
								</c:if> <c:if test="${page ne curPage}">
									<a
										href="<%=request.getContextPath()%>/board/list?pageParam=${page}">${page}</a>
								</c:if></td>
						</c:forEach>
					</c:if>
					<c:if test="${totalBoardCnt ne fn:length(boardList)}">
						<c:forEach var="page" begin="1" end="${totalPages}">
							<td><c:if test="${page eq curPage}">
									<a
										href="<%=request.getContextPath()%>/board/list?pageParam=${page}&searchFlag=1&search_method=${search_method}&search_input=${search_input}"
										style="text-decoration: underline; color: skyblue">${page}</a>
								</c:if> <c:if test="${page ne curPage}">
									<a
										href="<%=request.getContextPath()%>/board/list?pageParam=${page}&searchFlag=1&search_method=${search_method}&search_input=${search_input}"
										style="text-decoration: none;">${page}</a>
								</c:if></td>
						</c:forEach>
					</c:if>
				</tr>
			</table>

			<div align="center" style="margin-bottom: 30px;">
				<form action="<%=request.getContextPath()%>/board/list">
					<a href="<%=request.getContextPath()%>/board/regist">글쓰기</a> <select
						name="search_method">
						<option value="title">제목</option>
						<option value="writer">글쓴이</option>
					</select> <input type="text" name="search_input" /> <input type="submit"
						value="검색" />
				</form>
			</div>

		</div>

		<div id="footer" style="height: auto;">
			<jsp:include page="/tail.jsp" />
		</div>
	</div>
</body>
</html>