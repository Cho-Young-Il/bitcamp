function Member(id, name, age) {
	var member = {
		id : id,
		name : name,
		age : age,
		info : function() {
			console.log(this.id, this.name, this.age);
		}
	}
	return member;
}

var member = [];
member[0] = new Member("hong", "홍", 22);
member[1] = new Member("park", "박", 33);
member[3] = new Member("kim", "김", 44);

for(idx in member) {
	member[idx].info();
}