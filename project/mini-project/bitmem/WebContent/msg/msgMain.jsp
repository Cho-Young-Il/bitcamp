<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/headStyle.css" />
<link rel="stylesheet" type="text/css" href="../css/basicStyle.css" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" />
<script type="text/javascript" src="../time.js"></script>
<title>Bitcamp Membership</title>
<style>
html, body {
	margin: 0 auto;
	height:600px;
}

#mainDiv{
width: 950px; 
margin: 0 auto;
height: 600px;
}

a{text-decoration: none;}

#menu{
width: 950px; 
margin: 0 auto;
border-top: 3px solid hsl(180, 40%, 60%);

}
#menu > span{
    font: normal 18px/30px 'Hanna', serif;
    background-color: #D4F4FA;
	width: 100px;
    height: 50px;
    padding: 5px;
    text-align: center;
    line-height: 55px;
    margin: 5px 10px;
    border-radius: 5px;
    font-weight: bold;
    margin-right: 5px;
    display: inline-block;
}
#menu:hover span {width: 285px;}
#menu:hover span a{display: block;}
.sList{transition: 1s ease;}
.rList{transition: 1s ease;}
.send{transition: 1s ease;}


#pic{
	width: 950px; 
	height: auto;
	margin: 0 auto;
}



img {width: 200px; height: 200px;}


#mainLnb{width: 950px; margin: 0px auto; list-style: none; height: auto;}
#mainLnb > li {width: 200px; height: 200px; margin: 30px;
float: left; line-height: 30px; }
#mainLnb > li > a {display: block; font-size: 13px; font-weight: bold;
 text-align: center; transition: .5s;} 
#mainLnb > li > a:HOVER {
	background: #489df2; color: #ffff;
}


#mainLnb > li > ul {list-style: none; visibility: hidden;}

#mainLnb > li:HOVER > ul {visibility: visible; margin-top: 30px;}

#mainLnb > li > ul > li{width: 180px; height: 50px;
line-height: 30px; font-size: 20px; font-weight: bold; list-style: none;
font: normal 18px/30px 'Hanna', serif;
background-color: #D4F4FA;
border-radius: 50px; line-height: 55px; color: #999;
}
.mainLnb > li > ul > li > a {display: block; padding-left: 10px;}
img:hover {transform: scale(1.2, 1.2); visibility: visible;}
img{transition: 1s ease;}

#outer{
	width: 950px; 
	height: auto;
	margin: 0 auto;
}

#outer > span {
width: 950px; 
background-color: #D4F4FA;
font-size: 30px;
color: #999;
animation: myani 10s linear infinite alternate;
}

@keyframes myani{
0%{margin-left:0px;}
25%{margin-left:150px; background-color: orange; color: black; border-radius: 100px;}
50%{margin-left:300px; background-color: skyblue; color: red; border-radius: 100px;}
75%{margin-left:450px; background-color: skyblue; color: red; border-radius: 0px;}
}
</style>
<script>
</script>
</head>
<body>

	<div id="wrapper">
	
		
		<div id="header">
			<jsp:include page="/header.jsp" />
		</div>
	
		
		<div id="main">
			<div id="mainDiv">
				<div id="menu">
					<span class="sList" ><a href="sendList" style="color: #999; ">보낸쪽지함</a></span>
					<span class="rList" ><a href="receiveList" style="color: #999;">받은쪽지함</a></span>
					<span class="send" ><a href="msgSend" style="color: #999;">쪽지보내기</a></span>
				</div>	
				
				
				<div id="pic" align="center" style="padding-left: 150px;">
					<ul id="mainLnb">
						<li><a href="sendList"><img src="a2.JPG"></a>
							<ul>
								<li class="x">보낸쪽지: ${fn:length(sendList)}개</li>
							</ul>
						</li>
						
						<li><a href="receiveList"><img src="a2.JPG"></a>
							<ul>
								<li class="y">받은쪽지: ${fn:length(receiveList)}개</li>
							</ul>
						</li>
						
						<li><a href="msgSend"><img src="a2.JPG"></a>
							<ul>
								<li class="all">쪽지보내기</li>
							</ul>
						</li>
					</ul>
				</div>	
				
				<div id="outer" style="padding-top: 370px;">
					<span>마우스를 이미지에 올려보세요</span>
				
				</div>
				
			</div>
		</div>
			
		<div id="footer">
			<jsp:include page="/tail.jsp" />
		</div>
		
	</div>
</body>
</html>
