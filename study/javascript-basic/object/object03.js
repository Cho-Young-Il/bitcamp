/*
	객체의 프로퍼티로 함수 설정이 가능하다.
*/

var member = {
	id : "hong",
	name : "홍길동",
	age : 22,
	setId : function(id) {
		this.id = id;
	},
	getId : function() {
		return this.id;
	},
	info : function() {
		console.log(this.id, this.name, this.age);
	}
}

member.info();
member.setId("park");
console.log(member.getId());