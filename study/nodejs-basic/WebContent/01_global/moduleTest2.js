/**
 *	module2.js에 등록된 내용
 *	module.exports = calc
 * 
 */
var calc = require("./module2.js");
console.log("add : " + calc.add(100, 200));

/*
 * 	require에 파일을 찾는 규칙
 * 
 * 	예 > require(".module3")
 * 	1. 확장자가 없는 이름이 올 경우 .js 파일을 찾는다.
 * 	2. 만약 .js 파일이 없을 경우 해당 이름의 디렉토리를 찾는다.
 * 	3. 디렉토리를 찾은 경우 해당 디렉토리에서 index.js 파일을 찾는다.
 * 	
 */
var module3 = require("./module3");
console.log("module3 : " + module3);