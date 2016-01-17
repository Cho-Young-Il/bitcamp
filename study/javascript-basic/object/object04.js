/*
	동적으로 객체에 속성 추가하기
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

member.setName = function(name) {
	this.name = name;
}
member.getName = function() {
	return this.name;
}

member.setName("박");
console.log("name", member.getName());