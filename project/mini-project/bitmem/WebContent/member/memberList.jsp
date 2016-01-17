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
<link rel="stylesheet" type="text/css" href="../css/headStyle.css"/>
<link rel="stylesheet" type="text/css" href="../css/basicStyle.css" />
<link rel="stylesheet" type="text/css" href="../css/tableStyle.css" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" />
<script type="text/javascript" src="../time.js"></script>
<title>회원 전체목록</title>
</head>
<body>
<div id="wrapper" style=" height:auto; ">
	<div id="header" style="height:auto;">
		<jsp:include page="/header.jsp"/>
	</div>
	
	<div id="main">
		<div class="table">
    		<div class="row header">
	      		<div class="cell">
	        		기수
	      		</div>
		      	<div class="cell">
		        	아이디
		      	</div>
		      	<div class="cell">
		        	이름
		      	</div>
		      	<div class="cell">
		        	성별
		      	</div>
		      	<div class="cell">
		        	이메일
		      	</div>
    		</div>
					
   			<c:forEach var="member" items="${members}">
   				<c:if test="${member.permission eq 1}">
	    			<div class="row">
		    			<c:choose>
		    				<c:when test="${member.classNo eq 0 and member.auth eq 'U'}">
      							<div class="cell">
						       		강사
						      	</div>
      						</c:when>
      						<c:when test="${member.classNo eq 0 and member.auth eq 'S'}">
      							<div class="cell">
        							관리자
      							</div>
      						</c:when>
      						<c:otherwise>
      							<div class="cell">
        							<c:out value="${member.classNo}"/>
      							</div>
      						</c:otherwise>
   						</c:choose>
      
      					<div class="cell">
        					<c:out value="${member.id}"/>
      					</div>
      					<div class="cell">
        					<c:out value="${member.name}"/>
      					</div>
      
      					<c:choose>
      						<c:when test="${member.gender eq 'M'}">
      							<div class="cell">
        							남
      							</div>
      						</c:when>
      						<c:otherwise>
      							<div class="cell">
        							여
      							</div>
      						</c:otherwise>
      					</c:choose>
      					<dir class="cell">
      						<c:out value="${member.email}"/>
      					</dir>
    				</div>
   				</c:if>
    		</c:forEach>
    	</div>
	</div>
		
	<div id="footer" style="height: auto;">
		<jsp:include page="/tail.jsp"/>
	</div>
</div>
</body>
</html>