/**
 * 	서버 + 실시간 통신
 * 	이벤트 방식 적용
 * 	on, emit
 */
var http = require("http");
var fs = require("fs");
var io = require("socket.io");

var server = http.createServer(function(request, response) {
	fs.readFile("data/test.html", function(error, data) {
		response.writeHead(200, 
				{"Content-Type" : "text/html; charset=UTF-8"}
		);
		response.end(data);
	});
}).listen(10001, function() {
	console.log("서버구동중");
});

//실시간 통신 추가
//소켓 io와 웹서버를 연결
var socketIO = io.listen(server);
socketIO.sockets.on("connection", function(socket) {
	console.log("소켓 서버 접속함");
});