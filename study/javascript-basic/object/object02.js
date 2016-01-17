/*
	ESS 에서 추가된 JSON.parse(string) - json만 가능
				 eval(string) 		- 모든코드 가능
	string에 입력된 값이 만약 JSON 형태라면
	실행시켜 json객체를 반환한다.

	json은 자바스크립트 리터럴 객체 형태와 동일한데
	단, 키값을 ""문자열로 묶어줘야 한다.
*/

var code = '{"id" : "hong", "msg" : "hi~!"}';
var obj = JSON.parse(code);
console.log(obj.id);
console.log(obj.msg);