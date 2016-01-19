<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" 
           uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/MyProject/framework.js"></script>
<script type="text/javascript">
	function commentReg() {
		var f = document.cForm;
		$.ajax({
			url: f.action,
			method: "POST",
			callback: function() {
				if(httpRequest.readyState == 4) {
					if(httpRequest.status == 200) {
						var result = JSON.parse(httpRequest.responseText);
						var div = "";
						div += '<div id="c_' + result.commentNo + '"> ';
						div += '<span>' + result.nickName + '</span> ';
						div += '<span>' + result.content + '</span> ';
						div += '<span>' + result.regDate + '</span> ';
						div += '<span><a href="#1" onclick="commentDel(' + result.no + ',' + result.commentNo + ');">삭제</a></span>';
						div += '</div>';
						$("#cListDiv").html($("#cListDiv").html() + div);
						
						f.nickName.value = "";
						f.content.value = "";
					}
				}
			},
			data: {
				no: f.no.value,
				nickName: f.nickName.value,
				content: f.content.value
			}
		});
		return false;
	}
	
	function commentDel(no, commentNo) {
		$.ajax({
			url: "/MyProject/board/commentDeleteAjax",
			data: {
				no: no,
				commentNo: commentNo
			},
			callback: function() {
				if(httpRequest.readyState == 4) {
					if(httpRequest.status == 200) {
						var div = $("#c_" + commentNo);
						div.parentNode.removeChild(div);
					}
				}
			}
		});
	}
	
</script>
<title>Insert title here</title>
</head>
<body>
	<%-- req.setAttribute("content", vo); --%>
	<h1>${content.no}번 게시물 정보</h1>
	<hr />
	제목   : ${content["title"]}<br />
	글쓴이 : ${content.writer}<br />
	내용   : ${content.content}<br />
	조회수 : ${content.viewCnt}<br />
	추천수 : ${content.recomCnt}<br />
	첨부파일 : 
	<c:forEach var="fileVO" items="${fileList}">
		<a href="${pageContext.request.contextPath}/down?oriFileName=${fileVO.oriFileName}&realFileName=${fileVO.realFileName}&filePath=${fileVO.filePath}">
		${fileVO.oriFileName}
		</a> 
		(${fileVO.fileSize} byte)
	</c:forEach>
	<c:if test="${empty fileList}">
		첨부된 파일이 없습니다.
	</c:if>
	<hr />
	<a href='recom?no=${content.no}'>추천</a>
	<a href='updateForm?no=${content.no}'>수정</a>
	<a href='delete?no=${content.no}'>삭제</a>
	<a href='list'>목록</a>
	
	<table>
		<tr>
			<td>이전글</td>
			<td><a href="detail?no=${content.prev.no}&call=viewCnt">
					<c:out value="${content.prev.title}" />	
				</a>
				<c:if test="${empty content.prev.no}">
					이전글이 없습니다.				
				</c:if>
			</td>
		</tr>
		<tr>
			<td>다음글</td>
			<td><a href="detail?no=${content.next.no}&call=viewCnt">
					<c:out value="${content.next.title}" />	
				</a>
				<c:if test="${empty content.next.no}">
					다음글이 없습니다.				
				</c:if>
			</td>
		</tr>
	</table>
	
	<form name="cForm" action="${pageContext.request.contextPath}/board/commentRegistAjax"
	      method="post" onsubmit="return commentReg();">
		<!-- 게시물번호 -->
		<input type="hidden" id="no" name="no" value="${content.no}" />      
		<table>
		<tr>
			<td><input type="text" name="nickName" /></td>
			<td><textarea name="content" rows="2" cols="50"></textarea></td>
			<td><input type="submit" value="등록"/></td>
		</tr>	
		</table>
	</form>
	
	
	<div id="cListDiv">
	<c:if test="${not empty commentList}">	
		<c:forEach var="commentVO" items="${commentList}">
		<div id="c_${commentVO.commentNo}">
			<span>${commentVO.nickName}</span>
			<span>${commentVO.content}</span>
			<span>${commentVO.regDate}</span>
			<span><a href="#1" onclick="commentDel(${content.no}, ${commentVO.commentNo})">삭제</a></span>
		</div>	
		</c:forEach>
	</c:if>
	</div>
</body>
</html>













