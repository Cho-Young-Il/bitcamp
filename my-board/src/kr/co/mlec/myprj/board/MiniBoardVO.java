package kr.co.mlec.myprj.board;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MiniBoardVO implements Serializable {
	private String title;
	private String writer;
	private String content;
	private int no;
	private int viewCnt;
	private Date regDate;
	// 댓글수 
	private int commentCnt;
	
	// 이전글, 다음글
	private MiniBoardVO prev;
	private MiniBoardVO next;
	
	// 추천수 추가
	private int recomCnt;
	
	public MiniBoardVO() {
		super();
	}
	
	public MiniBoardVO(String title, String writer, int no) {
		super();
		this.title = title;
		this.writer = writer;
		this.no = no;
	}
	
	public MiniBoardVO getPrev() {
		return prev;
	}

	public void setPrev(MiniBoardVO prev) {
		this.prev = prev;
	}

	public MiniBoardVO getNext() {
		return next;
	}

	public void setNext(MiniBoardVO next) {
		this.next = next;
	}

	public int getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	// setter, getter : alt + shift + s, r
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getRecomCnt() {
		return recomCnt;
	}

	public void setRecomCnt(int recomCnt) {
		this.recomCnt = recomCnt;
	}

	public String toString() {
		return no + "\t" + title + "\t" + writer + "\t" + viewCnt;
	}
}























