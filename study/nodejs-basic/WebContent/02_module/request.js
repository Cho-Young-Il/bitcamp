/**
 *	자바의 URL 클래스가 하던 일을 쉽게 처리함 
 *
 *	외부모듈을 사용할 경우 모듈을 인스톨 하는 과정이 필요
 *	npm install 모듈명
 *	npm install request
 */
var request = require("request");
request("http://www.daum.net", function(error, response, body) {
	if(!error && response.statusCode == 200) {
		console.log(body);
	}
});