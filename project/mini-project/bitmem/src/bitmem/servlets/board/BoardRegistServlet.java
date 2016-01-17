package bitmem.servlets.board;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitmem.dao.board.BoardDao;
import bitmem.util.FileRenamePolicyUtil;
import bitmem.vo.board.Board;
import bitmem.vo.board.BoardFile;

import com.oreilly.servlet.MultipartRequest;

@SuppressWarnings("serial")
@WebServlet("/board/regist")
public class BoardRegistServlet extends HttpServlet{
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(
				"/view/board/registForm.jsp");
		rd.forward(request, response);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String savePath = 
					"/Users/MacintoshHD/Documents/Web_Workspace"
					+ "/bitmem/WebContent/upload";
			SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
			String path = sdf.format(new Date());
			savePath += path;
			File saveFolder = new File(savePath);
			saveFolder.mkdirs();
			
			MultipartRequest mRequest = new MultipartRequest(
					request,
					savePath,
					1024 * 1024 * 10,
					"utf-8",
					new FileRenamePolicyUtil()
			);
		
			ServletContext sc = request.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			
			String title = mRequest.getParameter("title");
			String writer_id = mRequest.getParameter("writer_id");
			String writer_name = mRequest.getParameter("writer_name");
			String content = mRequest.getParameter("content");
			
			int no = boardDao.insertBoard(new Board()
											.setTitle(title)
											.setWriter_id(writer_id)
											.setWriter_name(writer_name)
											.setContent(content));
			
			Enumeration<String> files = mRequest.getFileNames();
			while(files.hasMoreElements()) {
				String fileName = files.nextElement();
				File file = mRequest.getFile(fileName);
				
				if(file != null) {
					long file_size = file.length();
					String ori_file_name = mRequest.getOriginalFileName(fileName);
					String real_file_name = mRequest.getFilesystemName(fileName);
					boardDao.insertFile(new BoardFile()
										.setNo(no)
										.setFile_size(file_size)
										.setOri_file_name(ori_file_name)
										.setReal_file_name(real_file_name)
										.setFile_path(path));
				}
			}
			response.sendRedirect("list");
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
