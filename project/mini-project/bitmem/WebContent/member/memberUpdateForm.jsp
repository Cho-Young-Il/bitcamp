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
<link rel="stylesheet" type="text/css" href="../css/formStyle.css"/>
<link rel="stylesheet" type="text/css" href="../css/basicStyle.css" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" />
<script type="text/javascript" src="../time.js"></script>
<script type="text/javascript" src="js/validityInspector.js"></script>
<title>회원 정보</title>
</head>
<body>
	<div id="wrapper" style=" height:auto; ">
		<div id="header" style="height:auto;">
			<jsp:include page="/header.jsp"/>
		</div>
		
		
		<div id="main">
	 		<c:if test="${sessionScope.member.no eq member.no}">
		 	<form id="msform" name="msform" action="update" method="post">
				<input type="hidden" name="no" value="${member.no}"/>
			 	<fieldset>
					<h1 class="fs-title">UPDATE YOUR ACCOUNT</h1>
					<input type="text" name="name" value="${member.name}" readonly/>
					<input type="text" name="id" value="${member.id}" readonly/>
					<input type="text" name="birth" value="${member.birth }" placeholder="Birth Date ( YYYY-MM-DD )" readonly/>
					<input type="text" name="email" value="${member.email}"placeholder="Email"/>
					<input type="text" name="phone" value="${member.phoneNo}" placeholder="Phone ( Contain '-' )"/>
					<input type="password" name="pass" placeholder="Password ( 4 ~ 8 )" />
					<input type="password" name="cpass" placeholder="Confirm Password" />
					<input type="button"class="submit action-button" 
						   value="Update" onclick="updateAccountInspector();"/>
					<input type="Reset" name="Reset" class="reset action-button" value="Reset" />
				</fieldset>
	 		</form>
			</c:if>
					
			<c:if test="${sessionScope.member.no ne member.no}">
			<form id="msform" name="msform" action="update" method="post">
			<input type="hidden" name="no" value="${member.no}"/>
			<input type="hidden" name="permission" value="1"/>
				<fieldset>
					<h1 class="fs-title">MANAGE ACCESS RIGHT</h1>
					<input type="text" value="NO              :   ${member.no}" readonly/>
					<input type="text" value="ID                :   ${member.id}" readonly/>
					<input type="text" value="Name          :   ${member.name}" readonly/>
					<input type="text" value="Birth           :   ${member.birth }"  readonly/>
					<input type="text" value="Email           :   ${member.email}" readonly/>
					<input type="text" value="Phone         :   ${member.phoneNo}" readonly/>
					<input type="text" value="Reg_Date   :   ${member.regDate}" readonly/>
					<input type="text" name="classNo" placeholder="Class Number" />
					<input type="button" class="submit action-button" 
						   onclick="updateRightInspector()" value="Update" />
					<input type="Reset" name="Reset" class="reset action-button" value="Reset" />
				</fieldset>
			</form>
			</c:if>
		</div>
		
		<div id="footer" style="height:auto;">
			<jsp:include page="/tail.jsp"/>
		</div>
	</div>
</body>
</html>