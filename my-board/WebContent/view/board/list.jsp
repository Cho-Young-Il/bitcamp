<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" 
           uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	a {
		text-decoration: none;
		color: #334455;
	}
	a:hover { text-decoration: underline; }
</style>
</head>
<body>
	전체 : ${fn:length(list)}개
	<table border='1'>
	<tr>
	<th>번호</th>
	<th>제목</th>
	<th>글쓴이</th>
	<th>조회수</th>
	<th>추천수</th>
	</tr>
	
	<%--  최신 등록된 글부터 출력합니다. --%>
	<c:forEach var="vo" items="${list}">
		<tr>
			<td>${vo.no}</td>
			<td><a href='detail?no=${vo.no}&call=viewCnt'>
					${vo.title}
					<c:if test="${vo.commentCnt ne 0}">
					[${vo.commentCnt}]
					</c:if>
				</a>
			</td>
			<td>${vo.writer}</td>
			<td>${vo.viewCnt}</td>
			<td>${vo.recomCnt}</td>
		</tr>
	</c:forEach>
	
	<%--  만약, 게시글이 하나도 등록되어 있지 않다면 --%>
	<c:if test="${empty list}">
		<tr>
		<td colspan='4'>게시글이 존재하지 않습니다.</td>
		</tr>
	</c:if>
	</table>
	
	<!-- 
		페이징 관련 부분 시작
	 -->
	<table width="60%">
	<tr>
		<td>
		<%-- 처음 링크 만들기 --%>
		<c:if test="${pageNo ne 1}">
			<a href="list?pageNo=1">처음</a>
		</c:if>		
		
		<%-- 이전 링크 만들기 --%>
		<c:if test="${beginPage ne 1}">
			<a href="list?pageNo=${beginPage - 1}">이전</a>
		</c:if>		
		
		<%-- 페이징 번호 만들기 --%>
		<c:forEach var="i" begin="${beginPage}" end="${endPage}">
			<c:if test="${pageNo ne i}">
				<a href="list?pageNo=${i}">[${i}]</a>
			</c:if>
			<c:if test="${pageNo eq i}">
				<strong>[${i}]</strong>
			</c:if>
		</c:forEach>
		
		<%-- 다음 링크 만들기 --%>
		<c:if test="${endPage ne lastPage}">
			<a href="list?pageNo=${endPage + 1}">다음</a>
		</c:if>		
		
		<%-- 마지막 링크 만들기 --%>
		<c:if test="${pageNo ne lastPage}">
			<a href="list?pageNo=${lastPage}">마지막</a>
		</c:if>		

		</td>
	</tr>	
	</table>
	
	
	<a href='registForm'>글쓰기</a>
</body>
</html>























