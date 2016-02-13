/**
 * 	http 모듈 사용 : 내장 모듈
 * 
 * 	여러개의 서버를 동시에 구동
 * 	단, 각각의 서버를 구분하기 위해 포트번호를 다르게 생성
 * 	
 * 	/html - html
 * 	/image - image
 * 	/audio - mp3
 */
var http = require("http");
var fs = require("fs");

//10001번 구동
http.createServer(function(request, response) {
	//사용자의 요청 uri 에 따라서 읽어오는 파일을 다르게 처리한다.
	console.log("사용자 요청 URL : " + request.url);
	
	var fileName = "";
	var contentType = "";
	if(request.url == "/html") {
		fileName = "data/test.html";
		contentType = "text/html; charset=utf-8";
	} else if(request.url == "/image") {
		fileName = "data/test.jpg";
		contentType = "image/jpeg";
	} else if(request.url == "/audio") {		
		fileName = "data/test.mp3";
		contentType = "audio/mp3";
	}

	fs.readFile(fileName, function(error, data) {
		response.writeHead(200, {"content-Type" : contentType});
		response.end(data);
	});
})
.listen(10001, function() {
	console.log("http://localhost:10001/ 구동중");
});