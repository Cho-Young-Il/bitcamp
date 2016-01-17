<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"
		   uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/headStyle.css"/>
<link rel="stylesheet" type="text/css" href="../css/basicStyle.css" />
<link rel="stylesheet" type="text/css" href="../css/boardDetailStyle.css" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" />
<script type="text/javascript" src="../time.js"></script>
<script type="text/javascript" src="../view/board/js/validityInspector.js"></script>
<title>자유 게시판</title>
</head>
<body>
	<div id="wrapper" style=" height:auto; ">
		<div id="header" style="height:auto;">
			<jsp:include page="/header.jsp"/>
		</div>
		<div id="main" style="height: auto;">
			<blockquote class="default">
			  	<h1><span class="Cdefault"></span><c:out value="${board.title}"/></h1>  
			  	<div id="n_r">
			  		<div>
					  	<span id="name-id"><c:out value="${board.writer_name} (${board.writer_id })"/></span>
					  	<span id="reg-date"><c:out value="${board.reg_date}"/></span>
				  	</div>
			  	</div>
			  	
				<div id="content">
					<textarea style="width:550px;" rows="20" cols="80" readonly><c:out value="${board.content}"/></textarea>
				</div>
				
				<div id="cfoot">
					첨부파일 :
					<c:if test="${empty fileList}">	 
						첨부된 파일이 없습니다.
					</c:if>
					<c:if test="${!empty fileList }">
						<c:forEach var="file" items="${fileList}">
							<a style="float: right;" href="<%=request.getContextPath()%>/down?oriFileName=${file.ori_file_name}&realFileName=${file.real_file_name}&filePath=${file.file_path}">${file.ori_file_name} ( ${file.file_size} byte )</a>
						</c:forEach>
					</c:if>
					<br/>
					조회수 : <c:out value=" ${board.view_cnt }"/>
					추천수 : <c:out value=" ${board.recom_cnt }"/>
					<a href="<%=request.getContextPath()%>/board/list">목록</a>
					
					<c:if test="${sessionScope.member.auth eq 'S' }">
						<a href="<%=request.getContextPath()%>/board/delete?no=${board.no}&id=${board.writer_id}">삭제</a>
						<a href="<%=request.getContextPath()%>/board/update?no=${board.no}&id=${board.writer_id}">수정</a>
						<a href="<%=request.getContextPath()%>/board/recom?no=${board.no}">추천</a>
					</c:if>
					<c:if test="${sessionScope.member.auth ne 'S' }">
						<c:if test="${sessionScope.member.id ne board.writer_id}">
							<a href="<%=request.getContextPath()%>/board/recom?no=${board.no}">추천</a>
						</c:if>
						<c:if test="${sessionScope.member.id eq board.writer_id}">
							<a href="<%=request.getContextPath()%>/board/delete?no=${board.no}&id=${board.writer_id}">삭제</a>
							<a href="<%=request.getContextPath()%>/board/update?no=${board.no}&id=${board.writer_id}">수정</a>
						</c:if>
					</c:if>
				</div>
				
				
				<form id="co-form" name="cform" action="<%=request.getContextPath()%>/board/commentRegist" method="post">
					<input type="hidden" name="no" value="${board.no}">
					<input type="hidden" name="id" value="${sessionScope.member.id}"/>
					<textarea rows="4" cols="80" name="content" placeholder="Comment"></textarea>
					<input type="text" name="name" value="${sessionScope.member.name}" readonly/>
					<input type="button" class="submit action-button" 
						   onclick="commentInspector();" value="Submit" />
				</form>
				
				<div id="comment" style="border-top: 1px solid gray;">
					<c:forEach var="comment" items="${comments}">
					<c:if test="${comment.no eq board.no}">
					<table style="width: 100%; padding-top: 5px;">
						<tr>
							<td width="25%">${comment.name} ( ${comment.id} )</td>
							<td>
								<fmt:formatDate value="${comment.reg_date}" pattern="yyyy-MM-dd hh:mm"/>
							</td>
				
							<c:if test="${sessionScope.member.id eq comment.id or sessionScope.member.auth eq 'S'}">
							<td>
								<a href="<%=request.getContextPath()%>/board/commentDelete?no=${board.no}&comment_no=${comment.comment_no}">
									삭제
								</a>
							</td>
							
							</c:if>
						</tr>
						</table>
						<table style="width: 100%; table-layout: fixed;
									 word-wrap: break-word; padding:10px;">
						<tr>
							<td><c:out value="${comment.content}"/></td>
						</tr>
						</table>
					<br />
					<hr />
					</c:if>
					
					</c:forEach>
				</div>
					
				
			</blockquote>
			
			
			<div class="bluejeans">
				이전글 :
				<c:if test="${board.prev.no eq 0}">
					이전글이 없습니다.
				</c:if>
				<c:if test="${board.prev.no ne 0}">
					<a href="<%=request.getContextPath()%>/board/detail?no=${board.prev.no}&call=view_cnt"><c:out value="${board.prev.title}"/></a>
				</c:if>
				<br/>
				<hr size="1px" color="gray">
				다음글 :
				<c:if test="${board.next.no eq 0}">
				다음글이 없습니다.
				</c:if>
				<c:if test="${board.next.no ne 0}">
				<a href="<%=request.getContextPath()%>/board/detail?no=${board.next.no}&call=view_cnt"><c:out value="${board.next.title}"/></a>
				</c:if>
			</div>
			
			
			<br/>
			
			
			
			
		
			
		</div>
		<div id="footer" style="height: auto;">
			<jsp:include page="/tail.jsp"/>
		</div>
	</div>
</body>
</html>