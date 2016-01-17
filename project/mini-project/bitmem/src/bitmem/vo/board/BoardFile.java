package bitmem.vo.board;

public class BoardFile {
	private int file_no;
	private int no;
	private long file_size;
	private String ori_file_name;
	private String real_file_name;
	private String file_path;
	
	public int getFile_no() {
		return file_no;
	}
	public BoardFile setFile_no(int file_no) {
		this.file_no = file_no;
		return this;
	}
	public int getNo() {
		return no;
	}
	public BoardFile setNo(int no) {
		this.no = no;
		return this;
	}
	public long getFile_size() {
		return file_size;
	}
	public BoardFile setFile_size(long file_size) {
		this.file_size = file_size;
		return this;
	}
	public String getOri_file_name() {
		return ori_file_name;
	}
	public BoardFile setOri_file_name(String ori_file_name) {
		this.ori_file_name = ori_file_name;
		return this;
	}
	public String getReal_file_name() {
		return real_file_name;
	}
	public BoardFile setReal_file_name(String real_file_name) {
		this.real_file_name = real_file_name;
		return this;
	}
	public String getFile_path() {
		return file_path;
	}
	public BoardFile setFile_path(String file_path) {
		this.file_path = file_path;
		return this;
	}	
}
