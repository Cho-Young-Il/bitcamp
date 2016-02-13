/**
 * 	http 모듈 사용 : 내장 모듈
 */
var http = require("http");

//서버 생성
var server = http.createServer();
server.listen(10001, function() {
	console.log("http://localhost:10001/ 구동중");
});

//사용자 요청 받기
server.on("request", function() {
	console.log("사용자 요청 들어옴..");
});