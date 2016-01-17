package bitmem.vo.member;

import java.util.Date;

public class Member {
	protected int		no;
	protected int		permission;	//0 승인 안됨 접근 안됨, 1 이면 승인됨 접근됨 //관리자 승인
	protected int		classNo;	//관리자가 업데이트해줌
	protected String	birth;
	protected String	phoneNo;
	protected String	gender;
	protected String	id;
	protected String	auth;		//S -> 관리자 U-> 사용자
	protected String 	name;
	protected String	email;
	protected String	password;
	protected Date		regDate;
	
	
	public String getBirth() {
		return birth;
	}
	public Member setBirth(String birth) {
		this.birth = birth;
		return this;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public Member setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
		return this;
	}
	public String getGender() {
		return gender;
	}
	public Member setGender(String gender) {
		this.gender = gender;
		return this;
	}
	public int getClassNo() {
		return classNo;
	}
	public Member setClassNo(int classNo) {
		this.classNo = classNo;
		return this;
	}
	public String getId() {
		return id;
	}
	public Member setId(String id) {
		this.id = id;
		return this;
	}
	public int getNo() {
		return no;
	}
	public Member setNo(int no) {
		this.no = no;
		return this;
	}
	public int getPermission() {
		return permission;
	}
	public Member setPermission(int permission) {
		this.permission = permission;
		return this;
	}
	public String getAuth() {
		return auth;
	}
	public Member setAuth(String auth) {
		this.auth = auth;
		return this;
	}
	public String getName() {
		return name;
	}
	public Member setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Member setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public Member setPassword(String password) {
		this.password = password;
		return this;
	}
	public Date getRegDate() {
		return regDate;
	}
	public Member setRegDate(Date regDate) {
		this.regDate = regDate;
		return this;
	}
}