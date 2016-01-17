/*
	클로져
	지역함수 내의 변수는 함수가 종료됨과 동시에 메모리에서 삭제됨
	함수 외부에서 사용할수 있도록 하는 기법
	함수내의 함수를 만들어서 사용
	콜백함수 처럼 함수를 리턴하는 함수내에 지역함수내의 변수를
	참조하는 것
*/

function func(name) {
	var output = "hi~" + name;
	return function() {
		console.log(output);
	}
}

var f = func("java");
f();
console.log("-------------");

func("java")();
console.log("-------------");


function func2(val) {
	var cnt = val;
	return function() {
		return cnt++;
	}
}

var f = func2(100);
console.log(f());
console.log(f());
console.log("-------------");

var f2 = func2(100);
console.log(f2());
console.log(f2());