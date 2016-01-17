package bitmem.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/down")
public class FileDownloader extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

	/**
	 *  파일 다운로드 기능을 구현하기 위한 기본 파라미터
	 *  1. 사용자 컴퓨터에 저장될 파일명
	 *  2. 서버에 파일 경로(/2015/12/20)와 파일명(a12acf.jpg)
	 *  3. draw 파라미터 값을 이용해서 화면에 보여줄지 다운로드 할지 결정
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 서버의 기본 패스 경로
		String uploadPath = 
				"/Users/MacintoshHD/Documents/Web_Workspace/bitmem/WebContent/upload";
		String oriFileName = req.getParameter("oriFileName");
		String realFileName = req.getParameter("realFileName");
		String filePath = req.getParameter("filePath");
		String draw = req.getParameter("draw");
		
		File f = new File(
				uploadPath + filePath, realFileName);
		
    	if (draw == null || !draw.equals("image")) {
    		res.setHeader("Content-Type", "application/octet-stream");
    		res.setHeader("Content-Disposition", "attachment;filename="+ new String(oriFileName.getBytes("UTF-8"),"8859_1"));
    		res.setHeader("Content-Transfer-Encoding", "binary;");
    		res.setHeader("Content-Length", String.valueOf(f.length()));
    		res.setHeader("Pragma", "no-cache;");
    		res.setHeader("Expires", "-1;");
    	} else {
    		res.setHeader("Content-Type", "image/jpg");
    	}
		
		if (f.isFile()) {
			BufferedInputStream bis = new BufferedInputStream(
											new FileInputStream(f));
			// 클라이언트 브라우져 출력 객체
			BufferedOutputStream bos = new BufferedOutputStream(
											res.getOutputStream());
			while (true) {
				int ch = bis.read();
				if (ch == -1) break;
				
				bos.write(ch);
			}
			bos.close();
			bis.close();
		}
	}

	
}













