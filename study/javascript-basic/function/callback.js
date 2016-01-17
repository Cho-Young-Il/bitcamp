/*
	콜백함수
	함수는 데이터 타입중에서 객체 타입의 일종이므로
	매개변수 또는 결과로 함수를 사용할 수 있다.
*/

function call(callback) {
	console.log("call 함수 실행됨");
	console.log(callback);
	callback();
}
function func() {
	console.log("콜백함수로 사용");
}

console.log(func);
console.log("-------------");
call(func);
console.log("-------------");
call(function() {
	console.log("익명함수 콜백 사용");
});
console.log("-------------");


//결과값으로 함수를 넘겨주는 방식
function rFunc() {
	/* // 내부함수 - 자신이 선언된 함수 내에서만 사용가능
	function hi() {
		console.log("hi");
	}
	return hi;
	*/

	//익명함수 방식의 리턴
	return function() {
		console.log("hi");
	}
}

var hi = rFunc(); //결과 값이 함수를 받는다.
hi();

rFunc()(); //넘겨받은 함수를 바로 실행