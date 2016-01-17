<%@page import="bitmem.vo.member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body onload="displayTime();">
	<div id="top">
		<span id="hex" style="color: #003399"></span> <span>Bitcamp
			Membership</span>
		<c:if
			test="${!empty sessionScope.member and 
             		  !empty sessionScope.member.id}">
			<span> <c:out value="${sessionScope.member.name}님" />
			</span>
			<span> <a href="<%=request.getContextPath()%>/msg/main"> 쪽지함 </a>
			</span>
			<c:if test="${sessionScope.member.permission eq 0}">
				<span> <a href="<%=request.getContextPath()%>/qna/list"> Q&amp;A </a>
			</span>
			</c:if>
			<c:if test="${sessionScope.member.auth eq 'S'}">
				<span> <a href="<%=request.getContextPath()%>/qna/list">
						Q&amp;A 관리</a>
				</span>
				<span> <a href="<%=request.getContextPath()%>/member/manager">
						회원관리 </a>
				</span>
			</c:if>
			<span> <a
				href="<%=request.getContextPath()%>/member/update?no=${sessionScope.member.no}">
					회원정보 </a>
			</span>
		</c:if>
		<c:if test="${empty sessionScope.member}">
			<span> <a href="<%=request.getContextPath()%>/member/add"> 회원가입 </a>
			</span>
			<span> <a href="<%=request.getContextPath()%>/qna/list"> Q&amp;A </a>
			</span>
		</c:if>
		<span> <a href="<%=request.getContextPath()%>/auth/main">
				HOME </a>
		</span>

	</div>

	<c:if
		test="${!empty sessionScope.member and 
                 !empty sessionScope.member.id}">
		<div id="nav">
			<ul>
				<li><a href="<%=request.getContextPath()%>/member/list">
						회원목록 </a></li>
				<li><a href="<%=request.getContextPath()%>/board/list">
						자유게시판 </a></li>
				<li><a href="<%=request.getContextPath()%>/video/main"> 프로젝트영상 </a></li>
				<li><a href="<%=request.getContextPath()%>/algorithm/sort">
						알고리즘 </a></li>
				<li><a href="<%=request.getContextPath()%>/auth/logout">
						로그아웃 </a></li>
			</ul>
		</div>
	</c:if>
</body>