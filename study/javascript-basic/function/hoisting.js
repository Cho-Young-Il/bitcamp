/*
	호이스팅
	선언된 변수와 함수를 스크립트의
	가장 위쪽으로 올리는 작업

	함수도 변수와 마찬가지로 중복 선언이 가능
	함수의 호이스팅 작업은 선언적 함수일 경우만 발생
	익명함수는 호이스팅 대상이 아님
*/

sum(100, 200);

var sum = function(num1, num2) {
	console.log(num1, num2);
}


/*
	컴파일 시점
	var sum;

	실행시점
	sun(100, 200);
	sum = function(nun1, nun2);

	이므로 에러남
*/