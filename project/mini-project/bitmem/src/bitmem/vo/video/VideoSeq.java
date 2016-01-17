package bitmem.vo.video;

public class VideoSeq {
	private static int no=1;

	public static int getNo() {
		return no++;
	}

	public static void setNo(int no) {
		VideoSeq.no = no;
	}
}
