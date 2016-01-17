package bitmem.servlets.video;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bitmem.vo.video.VideoSeq;
import bitmem.vo.video.VideoVo;

public class Parser {
	
	public List<VideoVo> execute() throws Exception {
		//파일저장폴더 생성
		File f = new File("/Users/MacintoshHD/Documents/Web_Workspace/bitmem/WebContent/video/sourceFile");
		f.mkdir();
		
		List<VideoVo> videoList = new ArrayList<>();
		String fileName = "";
		VideoSeq.setNo(1);
		for (int i = 1; i <= 10; i++) {
			
			//url에서 파싱하는 메서드. 파일 쓰고나면 주석처리하는것 추천
			//sourceGetter(i);
			
			fileName = "/Users/MacintoshHD/Documents/Web_Workspace/bitmem/WebContent/video/sourceFile/sourceCopy"+i+".html";
			String searchWord = "[비트캠프]";
			List<String> sourcelist = fileScan(fileName);
			List<String> validStrList = validStrParse(sourcelist, searchWord);
			for (int j = 0; j < validStrList.size(); j++) {
				VideoVo vo = new VideoVo();
				vo.setNo(VideoSeq.getNo());
				vo.setUrl(parseUrl(validStrList.get(j)));
				vo.setTitle(parseTitle(validStrList.get(j)));
				videoList.add(vo);
			}
		}
		return videoList;
	}
	
	//url의 소스를 파일로 저장하는 메서드
	public void sourceGetter(int i) throws IOException {
			
			URL url = null;
			BufferedReader br = null;
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(
							"/Users/MacintoshHD/Documents/Web_Workspace/bitmem/WebContent/video/sourceFile/sourceCopy"+i+".html"
							)
					);
			String str = null;

			try {// URL은 프로토콜(http)부터 다 써줘야 한다
				url = new URL("https://www.youtube.com/results?"
						+ "search_query=%EB%B9%84%ED%8A%B8%EA%B5%90%EC%9C%A1%EC%84%BC%ED%84%B0"
						+ "&search_sort=video_date_uploaded&page=" + i);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} 
			try {
				br = new BufferedReader(new InputStreamReader(url.openStream()));
				while ((str = br.readLine()) != null) {
					bw.write(str);
					bw.write("\r\n");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			bw.close();
			br.close();
	}

	// 소스파일을 모두 문자열로 담는 메서드
	public List<String> fileScan(String fileName) throws Exception {
		ArrayList<String> sourcelist = new ArrayList<>();
		Scanner sc = new Scanner(new File(fileName));
		while (sc.hasNextLine()) {
			sourcelist.add(sc.nextLine());
		}
		sc.close();
		return sourcelist;
	}

	// 소스파일에서 필요한 문자열 뽑는 메서드
	public List<String> validStrParse(List<String> sourcelist, String searchWord) throws Exception {
		List<String> validStrList = new ArrayList<>();
		for (int i = 0; i < sourcelist.size(); i++) {
			if (sourcelist.get(i).contains(searchWord) && sourcelist.get(i).length() < 1300) {
//				System.out.println(sourcelist.get(i));
				validStrList.add(sourcelist.get(i));
			}
		}
		return validStrList;
	}

	// url 부분
	public String parseUrl(String validStr) {
		String url = null;
		String[] str = validStr.split("a href=");
		url = str[1].substring(10, 21);
		 //System.out.println("url : " + url);
		return url;
	}

	// 타이틀 부분
	public String parseTitle(String validStr) {
		String title = null;
		String[] str = validStr.split("title=");
		try {
			int end = str[1].indexOf("\" ");
			title = str[1].substring(7, end);
			// System.out.println("title : " + title);
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println(title);
		}
		return title;
	}
}
