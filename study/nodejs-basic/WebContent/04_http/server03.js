/**
 * 	http 모듈 사용 : 내장 모듈
 * 
 * 	여러개의 서버를 동시에 구동
 * 	단, 각각의 서버를 구분하기 위해 포트번호를 다르게 생성
 * 	
 * 	10001 - html
 * 	10002 - image
 * 	10003 - audio
 */
var http = require("http");
var fs = require("fs");

//10001번 구동
http.createServer(function(request, response) {
	//data/test.html 파일을 읽기
	fs.readFile("data/test.html", function(error, data) {
		//읽은 데이터를 사용자에게 응답
		response.writeHead(200, {"content-Type" : "text/html; charset=UTF-8"});
		response.end(data);
	});
})
.listen(10001, function() {
	console.log("http://localhost:10001/ 구동중");
});

//10002번 구동
http.createServer(function(request, response) {
	fs.readFile("data/test.jpg", function(error, data) {
		//읽은 데이터를 사용자에게 응답
		response.writeHead(200, {"content-Type" : "image/jpeg"});
		response.end(data);
	});
})
.listen(10002, function() {
	console.log("http://localhost:10002/ 구동중");
});

//10003번 구동
http.createServer(function(request, response) {
	fs.readFile("data/test.mp3", function(error, data) {
		response.writeHead(200, {"content-Type" : "audio/mp3"});
		response.end(data);
	});
})
.listen(10003, function() {
	console.log("http://localhost:10003/ 구동중");
});