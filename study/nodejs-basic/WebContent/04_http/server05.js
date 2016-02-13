/**
 *	 request.method : get post 정보를 뽑아냄
 */
//http, fs 모듈을 로딩
var http = require("http");
var fs = require("fs");

//http 모듈을 이용해서 10001번 포트로 서버 구동
http.createServer(function(request, response) {
	console.log("request.method : " + request.method)
	if(request.method == "GET") {
		response.writeHead(200, {"Content-Type" : "text/html; charset=UTF-8"});
		response.end("<h1>GET 호출 성공</h1>")
	} else if (request.method = "POST") {
		request.on("data", function(data) {
			response.writeHead(200, {"Content-Type" : "text/html; charset=UTF-8"});
			response.write("<h1>" + data +"</h1>");
			response.end("<h1>호출 성공</h1>")
		});
	}
}).listen(10001, function() {
	console.log("10001 번 포트 서버 구동")
});