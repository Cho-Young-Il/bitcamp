/*
	동적으로 객체의 속성 삭제하기
	delete 객체명.프로퍼티명
*/

var member = {
	id : "hong",
	name : "홍길동",
	age : 22,
	info : function() {
		console.log(this.id, this.name, this.age);
	}
}

console.log("-------------");
member.info();
console.log("-------------");
console.log("id 삭제후");
delete member.id;
member.info();
console.log("-------------");
console.log("name 삭제후");
delete member.name;
member.info();