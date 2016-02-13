package kr.co.mlec.member;

import java.util.Date;

public class MemberVO {
	private String id;
	private String name;
	private String addr;
	private String email;
	private Date joinDate;
	private String [] addrs;

	public String getEmail() {
		return email;
	}
	public MemberVO setEmail(String email) {
		this.email= email;
		return this;
	}
	public String getId() {
		return id;
	}
	public MemberVO setId(String id) {
		this.id= id;
		return this;
	}
	public String getName() {
		return name;
	}
	public MemberVO setName(String name) {
		this.name= name;
		return this;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public MemberVO setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
		return this;
	}
	public String getAddr() {
		return addr;
	}
	public MemberVO setAddr(String addr) {
		this.addr = addr;
		return this;
	}
	public String[] getAddrs() {
		return addrs;
	}
	public MemberVO setAddrs(String [] addrs) {
		this.addrs = addrs;
		return this;
	}
}