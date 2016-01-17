package bitmem.servlets.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitmem.dao.board.BoardDao;

@SuppressWarnings("serial")
@WebServlet("/board/detail")
public class BoardSearchOneServlet extends HttpServlet{
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int no = Integer.parseInt(request.getParameter("no"));
			String call = request.getParameter("call");
			
			ServletContext sc = request.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			
			if(call != null && call.equals("view_cnt")) {
				boardDao.updateViewCnt(no);
			}
			request.setAttribute("board", boardDao.selectBoardByNo(no)
											.setPrev(boardDao.selectPrevBoard(no))
											.setNext(boardDao.selectNextBoard(no)));
			request.setAttribute("fileList", boardDao.selectFile(no));
			request.setAttribute("comments", boardDao.selectComment(no));
			
			RequestDispatcher rd = request.getRequestDispatcher(
					"/view/board/detail.jsp");
			rd.forward(request, response);
			
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
