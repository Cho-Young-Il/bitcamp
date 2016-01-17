package bitmem.vo.board;

import java.util.Date;

public class BoardComment {
	private int comment_no;
	private int no;
	private String name;
	private String id;
	private String content;
	private Date reg_date;
	public int getComment_no() {
		return comment_no;
	}
	public BoardComment setComment_no(int comment_no) {
		this.comment_no = comment_no;
		return this;
	}
	public int getNo() {
		return no;
	}
	public BoardComment setNo(int no) {
		this.no = no;
		return this;
	}
	public String getName() {
		return name;
	}
	public BoardComment setName(String name) {
		this.name = name;
		return this;
	}
	public String getId() {
		return id;
	}
	public BoardComment setId(String id) {
		this.id = id;
		return this;
	}
	public String getContent() {
		return content;
	}
	public BoardComment setContent(String content) {
		this.content = content;
		return this;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public BoardComment setReg_date(Date reg_date) {
		this.reg_date = reg_date;
		return this;
	}	
}
