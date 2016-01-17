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
<title>회원 관리</title>
</head>
<body>
	<div id="wrapper" style="height: auto;">
		<div id="header" style="height: auto;">
			<jsp:include page="/header.jsp" />
		</div>
		<div id="main" style="height: auto;">
			<form action="<%=request.getContextPath()%>/member/delete"
				method="post">
				
				<div id="anchor1">
					<a id="bitmem1"></a>
					<a style="color: #5e9de6" href="#bitmem1">#기존회원</a>
					<a style="color: #ed5565" href="#bitmem2">#미승인회원</a>
				</div>
				
				<div class="table1">
					<div class="row header">
						<div class="cell" style="width: 20px;">
							<input type="submit" value='삭제' />
						</div>
						<div class="cell" style="width: 20px;">기수</div>
						<div class="cell">이름</div>
						<div class="cell" style="width: 20px;">성별</div>
						<div class="cell">생년월일</div>
						<div class="cell">이메일</div>
						<div class="cell">휴대폰</div>
						<div class="cell">가입일</div>
					</div>
					<c:forEach var="member" items="${members}">
						<c:if test="${member.permission eq 1}">
							<div class="row">
								<div class="cell" style="width: 20px;">
									<input type="checkbox" name="numbers" value="${member.no}" />
								</div>

								<c:choose>
									<c:when test="${member.classNo eq 0 and member.auth eq 'U'}">
										<div class="cell" style="width: 20px;">강사</div>
									</c:when>
									<c:when test="${member.classNo eq 0 and member.auth eq 'S'}">
										<div class="cell" style="width: 20px;">관리자</div>
									</c:when>
									<c:otherwise>
										<div class="cell" style="width: 20px;">
											<c:out value="${member.classNo}" />
										</div>
									</c:otherwise>
								</c:choose>

								<div class="cell">
									<c:out value="${member.name}" />
								</div>

								<c:choose>
									<c:when test="${member.gender eq 'M'}">
										<div class="cell" style="width: 20px;">남</div>
									</c:when>
									<c:otherwise>
										<div class="cell" style="width: 20px;">여</div>
									</c:otherwise>
								</c:choose>

								<div class="cell">
									<c:out value="${member.birth}" />
								</div>
								<div class="cell">
									<c:out value="${member.email}" />
								</div>
								<div class="cell">
									<c:out value="${member.phoneNo}" />
								</div>
								<div class="cell">
									<c:out value="${member.regDate}" />
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</form>

			<form action="delete" method="post">
				<div id="anchor2">
					<a id="bitmem2"></a>
					<a style="color: #5e9de6" href="#bitmem1">#기존회원</a>
					<a style="color: #ed5565" href="#bitmem2">#미승인회원</a>
				</div>
				
				<div class="table2">
					<div class="row header">
						<div class="cell">
							<input type="submit" value='삭제' />
						</div>
						<div class="cell">이름</div>
						<div class="cell">성별</div>
						<div class="cell">생년월일</div>
						<div class="cell">이메일</div>
						<div class="cell">휴대폰</div>
					</div>

					<c:forEach var="member" items="${members}">
						<c:if test="${member.permission eq 0 }">
							<div class="row">
								<div class="cell">
									<input type="checkbox" name="numbers" value="${member.no}" />
								</div>
								<div class="cell">
									<a href="update?no=${member.no}">${member.name}</a>
								</div>
								<c:choose>
									<c:when test="${member.gender eq 'M'}">
										<div class="cell">남</div>
									</c:when>
									<c:otherwise>
										<div class="cell">여</div>
									</c:otherwise>
								</c:choose>
								<div class="cell">
									<c:out value="${member.birth}" />
								</div>
								<div class="cell">
									<c:out value="${member.email}" />
								</div>
								<div class="cell">
									<c:out value="${member.phoneNo}" />
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</form>
		</div>


		<div id="footer" align="center" style="height: auto;">
			<jsp:include page="/tail.jsp" />
		</div>
	</div>
</body>
</html>