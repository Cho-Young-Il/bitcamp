/*
	number 특성
*/

var index = 1;
var num1;
var num2;

//소수점 앞 정수가 만약 0일 경우는 생략가능
num1 = 0.13;
num2 = .13;
console.log(index++ + ":" + num1);
console.log(index++ + ":" + num2);

//소수점 뒤 정수가 만약 0일 경우는 생략가능
num1 = 13.0;
num2 = 13.;
console.log(index++ + ":" + num1);
console.log(index++ + ":" + num2);

//뒤에 있는 소수점 이하0은 뗀다
num1 = 13.1000;
num2 = 13.0;
console.log(index++ + ":" + num1);
console.log(index++ + ":" + num2);

//수치계산 오류
console.log(index++ + ":" + (0.1 + 0.2));

num1 = 0.1;
num2 = 0.2;

if((num1 + num2) == 0.3) {
	console.log(index++ + ":" + "0.3이 이다.");
} else {
	console.log(index++ + ":" + "0.3이 아니다.");
}

console.log(index++ + ":" + (3.1 % 2));
console.log(index++ + ":" + (3.1 % 1));

Number.isInt = function(num) {
	return typeof(num) == "number" && num % 1 == 0;
}
console.log(index++ + ":" + Number.isInt(3.1));
console.log(index++ + ":" + Number.isInt(3));