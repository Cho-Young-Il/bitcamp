/**
 *	socket.io 단독 서버 구성
 *	클라이언트용 화면(html)은 웹서버를 활용 
 */
var io = require("socket.io")();
io.on("connection", function(socket) {
	console.log("클라이언트 연결 요청");
	socket.on("echo", function(data) {
		console.log("클라이언트 전송 테이터 : " + data);
		//접속한 사용자에게만 메시지 보내기
		//socket.emit("serverEcho", data);
		//전체 통신
		socket.emit("serverEcho", data);
		socket.broadcast.emit("serverEcho", data);
	});
});

io.listen(10001);