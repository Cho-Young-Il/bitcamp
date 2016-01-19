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
	
	<%--
			${pageContext.request.contextPath}
			pageContext.getRequest().getContextPath();
			
			ServletRequest request = pageContext.getRequest();
			String contextPath = request.getContextPath();
	 --%>                                 
	<form action='${pageContext.request.contextPath}/board/regist' method='post'
	      enctype="multipart/form-data">                    
		<table border='1' width='600px'>
		<tr>
			<th>제목</th>
			<td><input type='text' name='title' /></td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td><input type='text' name='writer' /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows='8' cols='60' name='content'></textarea></td>  
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><input type="file" name="attachFile1" /><br />
			    <input type="file" name="attachFile2" />
			</td>  
		</tr>
		</table>                                                              
		<div width='600px'>                                                   
			<input type='submit' value='등록' />                              
			<a href='list'>목록</a>                      
		</div>                                                                
	</form>                                                                   
</body>
</html>