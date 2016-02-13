/**
 * 	http 모듈 사용 : 내장 모듈
 */
var http = require("http");

//서버 생성
//createServer(callbackFn) 사용자의 요청 처리
var server = http.createServer(function(request, response) {
	//사용자 브라우져에 응답하기
	response.writeHead(200, {"content-Type" : "text/html; charset=UTF-8"});
	//브라우져로 내용 응답하기
	response.write("<h1>Node 응답 테스트</h1>");
	response.write("<h1>응답 성공함</h1>");
	response.end("<h1>끝..</h1>");
});

server.listen(10001, function() {
	console.log("http://localhost:10001/ 구동중");
});