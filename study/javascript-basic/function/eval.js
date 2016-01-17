/*
	eval(문자열로된 자바스크립트 코드)
	코드 안의 문자열의 내용을 실행
*/

var code  = "var i = 100;";
	code += "var j = 200;";
	code += "console.log(i + j);";
//코드 안의 문자열의 내용을 실행
eval(code);