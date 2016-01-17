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
@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int no = Integer.parseInt(request.getParameter("no"));
			
			ServletContext sc = request.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			
			boardDao.deleteBoard(no);
			boardDao.deleteCommentByBoardNo(no);
			boardDao.deleteFileByBoardNo(no);
			
			response.sendRedirect("list");
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ServletContext sc = this.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			
			String[] noStrs = request.getParameterValues("numbers");
			for(String noStr : noStrs) {
				int no = Integer.parseInt(noStr);
				boardDao.deleteBoard(no);
				boardDao.deleteCommentByBoardNo(no);
				boardDao.deleteFileByBoardNo(no);
			}
			
			response.sendRedirect("list");
		} catch(Exception e) {
			e.printStackTrace();
		    request.setAttribute("error", e);
		    RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
		    rd.forward(request, response);
		}
	}
}
