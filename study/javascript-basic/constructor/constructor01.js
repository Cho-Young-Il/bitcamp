/*
	자바스크립트 생성자
	별도의 다른 작업을 진행하지 않는 것들은
	prototype 공간에 올려놓고 사용하는것을 권장
	프로토타입에 여러개의 함수를 추가할 경우에는
	독립적으로 추가하지 않고 한꺼번에 추가하는 것을 권장
*/

function Member() {}
Member.prototype = {
	info : function() {
		console.log(this.id, this.name, this.age);
	},
	setId : function(id) {
		this.id = id;
		return this;
	},
	getId : function() {
		return this.id;
	},
	setName : function(name) {
		this.name = name;
		return this;
	},
	getName : function() {
		return this.name;
	},
	setAge : function(age) {
		this.age = age;
		return this;
	},
	getAge : function() {
		return this.age;
	}
}

console.log(Member.prototype.constructor);

new Member()
	.setId("hong")
   	.setName("홍길동")
   	.setAge(22)
	.info();