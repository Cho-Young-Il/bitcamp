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
import bitmem.vo.board.Board;

@SuppressWarnings("serial")
@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet{
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int no = Integer.parseInt(request.getParameter("no"));
			ServletContext sc = request.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			
			request.setAttribute("board", boardDao.selectBoardByNo(no));
			RequestDispatcher rd = request.getRequestDispatcher(
					"/view/board/updateForm.jsp");
			rd.forward(request, response);
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int no = Integer.parseInt(request.getParameter("no"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			ServletContext sc = request.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			
			boardDao.updateBoard(new Board()
							.setNo(no)
							.setTitle(title)
							.setContent(content));
			response.sendRedirect("list");
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
