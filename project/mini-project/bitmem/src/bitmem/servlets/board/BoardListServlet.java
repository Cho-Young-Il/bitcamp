package bitmem.servlets.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet{
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			ServletContext sc = request.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			
			String search_method = request.getParameter("search_method");
			String pageParam = request.getParameter("pageParam");
			int pageNo = 1;
			
			if(pageParam != null) {
				pageNo = Integer.parseInt(pageParam);
			}
			int curPage = pageNo;
			
			if(search_method != null && !search_method.equals("")) {
				int searchedBoardCnt = 1;
				List<Board> boardList = new ArrayList<>();
				switch(search_method) {
				case "title" :
					String title = request.getParameter("search_input");
					searchedBoardCnt = boardDao.getTotalBoardCntByTitle(title); 
					boardList = boardDao.selectBoardByTitle(
							request.getParameter("search_input"), pageNo, 
							searchedBoardCnt);
					break;
				case "writer" :
					String writer = request.getParameter("search_input");
					searchedBoardCnt = boardDao.getTotalBoardCntByWriter(writer);
					boardList = boardDao.selectBoardByWriter(
							request.getParameter("search_input"), pageNo, 
							searchedBoardCnt);
					break;
				}
				int totalPages = 
						(searchedBoardCnt / 15) + (searchedBoardCnt % 15 == 0 ? 0 : 1);
				int totalBoardCnt = boardDao.getTotalBoardCnt();
				
				request.setAttribute("search_method", search_method);
				request.setAttribute("search_input", request.getParameter("search_input"));
				request.setAttribute("totalBoardCnt", totalBoardCnt);
				request.setAttribute("curPage", curPage);
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("boardList", boardList);
				
				RequestDispatcher rd = request.getRequestDispatcher(
						"/view/board/list.jsp");
				rd.forward(request, response);
				return;
			}
			
			int totalBoardCnt = boardDao.getTotalBoardCnt();
			int totalPages = 
					(totalBoardCnt / 15) + (totalBoardCnt % 15 == 0 ? 0 : 1);
			request.setAttribute("totalBoardCnt", totalBoardCnt);
			request.setAttribute("curPage", curPage);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute(
					"boardList", boardDao.selectBoard(pageNo, totalBoardCnt));
			RequestDispatcher rd = request.getRequestDispatcher(
					"/view/board/list.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
}
