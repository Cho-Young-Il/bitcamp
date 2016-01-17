package bitmem.vo.board;

import java.util.Date;

public class Board {
	private String title;
	private String writer_name;
	private String writer_id;
	private String content;
	private int rnum;
	private int no;
	private int view_cnt;
	private int comment_cnt;
	private int recom_cnt;
	private Board prev;
	private Board next;
	private Date reg_date;
	
	public int getRnum() {
		return rnum;
	}
	public Board setRnum(int rnum) {
		this.rnum = rnum;
		return this;
	}
	public Board getPrev() {
		return prev;
	}
	public Board setPrev(Board prev) {
		this.prev = prev;
		return this;
	}
	public Board getNext() {
		return next;
	}
	public Board setNext(Board next) {
		this.next = next;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Board setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getWriter_name() {
		return writer_name;
	}
	public Board setWriter_name(String writer_name) {
		this.writer_name = writer_name;
		return this;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public Board setWriter_id(String writer_id) {
		this.writer_id = writer_id;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Board setContent(String content) {
		this.content = content;
		return this;
	}
	public int getNo() {
		return no;
	}
	public Board setNo(int no) {
		this.no = no;
		return this;
	}
	public int getView_cnt() {
		return view_cnt;
	}
	public Board setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
		return this;
	}
	public int getComment_cnt() {
		return comment_cnt;
	}
	public Board setComment_cnt(int comment_cnt) {
		this.comment_cnt = comment_cnt;
		return this;
	}
	public int getRecom_cnt() {
		return recom_cnt;
	}
	public Board setRecom_cnt(int recom_cnt) {
		this.recom_cnt = recom_cnt;
		return this;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public Board setReg_date(Date reg_date) {
		this.reg_date = reg_date;
		return this;
	}	
}
