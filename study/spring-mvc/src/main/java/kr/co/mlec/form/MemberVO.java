package kr.co.mlec.form;

public class MemberVO {
	private String id;
	private String password;
	private String name;
	public String getId() {
		return id;
	}
	public MemberVO setId(String id) {
		this.id = id;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public MemberVO setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getName() {
		return name;
	}
	public MemberVO setName(String name) {
		this.name = name;
		return this;
	}
	
}
