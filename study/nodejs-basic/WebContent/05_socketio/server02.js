/**
 *	socket.io 단독 서버 구성
 *	클라이언트용 화면(html)은 웹서버를 활용 
 */
var io = require("socket.io")();
io.on("connection", function(socket) {
	console.log("클라이언트 연결 요청");
});

io.listen(10001);