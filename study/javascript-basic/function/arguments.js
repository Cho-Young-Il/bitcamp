/*
	arguments
	함수의 매개변수를 담고있는 배열
	함수 자체에 내장되어 있는 함수
	매개변수와 상관없이 호출이 가능
*/

function func() {
	console.log("func call");
	console.log("arguments.length : " + arguments.length);
	if(arguments.length == 0) {
		console.log("매겨변수 없음");
	} else {
		for(key in arguments) {
			console.log(arguments[key]);
		}
	}
	console.log("---------------");
}

func();
func(1);
func(1, 2);