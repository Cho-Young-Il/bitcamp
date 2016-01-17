/*
	객체생성 2가지 방법
	객체에 프로퍼티를 설정하고 추출하는 2가지 방법
*/

var obj1 = new Object();
obj1.id = "hong";
obj1.name = "홍길동";
obj1.age = 33;

console.log("id", obj1.id);
console.log("name", obj1.name);
console.log("age", obj1.age);
console.log("----------------");

var obj2 = {
	id : "hong",
	name : "홍길동",
	age : 33,
	addr : {
		postNo : "123-123",
		baseAddr : "서울특별시",
		detailAddr : "동아아파트"
	}
}

console.log("id", obj2.id);
console.log("name", obj2.name);
console.log("age", obj2.age);

console.log("addr1", obj2.addr);

console.log("addr2", obj2.addr.postNo, 
					obj2.addr.baseAddr, 
					obj2.addr.detailAddr);
console.log("----------------");