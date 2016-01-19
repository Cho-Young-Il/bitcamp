package kr.co.mlec.myprj.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.mlec.common.MLecFileRenamePolicy;
import kr.co.mlec.myprj.board.MiniBoardVO;
import kr.co.mlec.myprj.board.MiniBoardFileVO;
import kr.co.mlec.myprj.board.dao.BoardDAO;

@WebServlet("/board/regist")
public class RegistController extends HttpServlet {
	
	public RegistController() {}

	public void doPost(
			HttpServletRequest req, 
			HttpServletResponse res) 
			throws IOException, ServletException {
		
		// 서버에 파일을 저장하기 위해 cos.jar 라이브러리 이용
		String saveFolder = 
				"C:/java77/workspace/MyProject/WebContent/upload";
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		String path = sdf.format(new Date());
		
		saveFolder += path;
		File f = new File(saveFolder);
		f.mkdirs();
		
		MultipartRequest mRequest = new MultipartRequest(
			req,
			saveFolder,
			1024 * 1024 * 10,
			"UTF-8",
			new MLecFileRenamePolicy()
		);
		
		MiniBoardVO vo = new MiniBoardVO();
		String title = mRequest.getParameter("title");
		vo.setTitle(title);

		String writer = mRequest.getParameter("writer");
		vo.setWriter(writer);
		
		String content = mRequest.getParameter("content");
		vo.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		try {
			// 게시물 정보 입력, no -> 입력된 게시물 번호
			int no = dao.insertBoard(vo);
			
			// 파일 정보 입력
			Enumeration<String> files = mRequest.getFileNames();
			while (files.hasMoreElements()) {
				String fName = files.nextElement();
				File file = mRequest.getFile(fName);
				
				if (file != null) {
					String oriFileName = 
							mRequest.getOriginalFileName(fName);
					String realFileName = 
							mRequest.getFilesystemName(fName);
					long fileSize = file.length();
					// 테이블에 저장하는 코드 호출
					MiniBoardFileVO fileVO = new MiniBoardFileVO();
					fileVO.setFilePath(path);
					fileVO.setFileSize(fileSize);
					fileVO.setOriFileName(oriFileName);
					fileVO.setRealFileName(realFileName);
					fileVO.setNo(no);
					dao.insertFile(fileVO);
				}
			}
			
			// 등록 처리 후 목록페이지 이동
			res.sendRedirect("list");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}






