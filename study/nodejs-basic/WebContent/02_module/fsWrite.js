/**
 *	fs : 파일을 읽거나 쓰려고 할 때 사용
 *	
 *	파일 읽기
 *	writeFile(file, data, encoding, callback) : 비동기식 파일 읽기
 *	writeFileSync(file, data, encoding) : 동기식 파일 읽기 
 */
var fs = require("fs");

var msg = "파일에 저장합니다.\r\n";
//비동기 읽기
fs.writeFile("writeTest1.txt", msg, "utf-8", function(error) {
	if(error) {
		console.log("쓰기중 오류 발생");
		console.log(error);
	} else {
		console.log("파일 쓰기 성공");
	}
});

//동기 읽기
//fs.writeFileSync("writeTest2.txt", msg, "utf-8");
fs.appendFileSync("writeTest2.txt", msg, "utf-8");
console.log("동기 쓰기 성공");