package bitmem.vo.video;

public class VideoVo {
	private int no;
	private String title;
	private String url;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return  "title	: "+title+"\n"+
				"url	: "+url+"\n";
	}
}
