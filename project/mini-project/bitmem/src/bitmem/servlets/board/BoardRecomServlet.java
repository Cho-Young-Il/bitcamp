package bitmem.servlets.board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitmem.dao.board.BoardDao;

@SuppressWarnings("serial")
@WebServlet("/board/recom")
public class BoardRecomServlet extends HttpServlet{
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int no = Integer.parseInt(request.getParameter("no"));
			ServletContext sc = request.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			
			boardDao.updateRecomCnt(no);
			response.sendRedirect("detail?no=" + no);
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
