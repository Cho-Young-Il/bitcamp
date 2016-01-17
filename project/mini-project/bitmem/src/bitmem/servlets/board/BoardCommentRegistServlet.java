package bitmem.servlets.board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitmem.dao.board.BoardDao;
import bitmem.vo.board.BoardComment;

@SuppressWarnings("serial")
@WebServlet("/board/commentRegist")
public class BoardCommentRegistServlet extends HttpServlet{
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int no = Integer.parseInt(request.getParameter("no"));

			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String content = request.getParameter("content");
			
			ServletContext sc = request.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			
			boardDao.insertComment(new BoardComment()
									.setNo(no)
									.setId(id)
									.setName(name)
									.setContent(content));
			response.sendRedirect("detail?no=" + no);
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
