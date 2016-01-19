<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판</h1>                                                           
	<form action='${pageContext.request.contextPath}/board/update' method='post'>                    
		<input type='hidden' name='no' value='${board.no}' />                                      
		<table border='1' width='600px'>
		<tr>
			<th>제목</th>
			<td><input type='text' name='title' value='${board.title}' /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows='8' cols='60' name='content'>${board.content}</textarea></td>  
		</tr>
		</table>                                                              
		<div width='600px'>                                                   
			<input type='submit' value='수정' />                              
			<a href='detail?no=${board.no}'>취소</a>                      
		</div>                                                                
	</form>                                                                   
</body>
</html>