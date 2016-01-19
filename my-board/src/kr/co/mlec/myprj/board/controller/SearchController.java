package kr.co.mlec.myprj.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import kr.co.mlec.myprj.board.MiniBoardVO;
import kr.co.mlec.myprj.board.dao.BoardDAO;

@WebServlet("/board/list")
public class SearchController extends HttpServlet {
	
	public SearchController() {}

	public void service(
			ServletRequest req, ServletResponse res) 
			throws IOException, ServletException {
		BoardDAO dao = new BoardDAO();
		try {
			// 페이지 번호를 추출
			int pageNo = 1;
			try {
				pageNo = Integer.parseInt(req.getParameter("pageNo"));
			} catch(Exception e) {}
			
			// 목록에 보여질 데이터
			List<MiniBoardVO> list = dao.selectBoard(pageNo);
			// 전체 게시물 수
			int cnt = dao.selectBoardCount();
			
			// 마지막 페이지 번호
			int lastPage = (cnt % 10 == 0) ? cnt / 10 
					                       : cnt / 10 + 1;

			// 탭 관련 처리부분
			// pageNo  : 현재 페이지 번호
			// tabSize : 10 
			int currTab   = (pageNo - 1) / 10 + 1;
			int beginPage = (currTab - 1) * 10 + 1;
			int endPage   = (currTab * 10 > lastPage) ? lastPage
					                                  : currTab * 10;
			
			// 마지막 페이지 번호
			req.setAttribute("lastPage", lastPage);
			
			// 화면에 출력할 페이지 번호의 시작과 끝 
			req.setAttribute("beginPage", beginPage);
			req.setAttribute("endPage", endPage);
			
			// 현재 페이지 번호 
			req.setAttribute("pageNo", pageNo);

			req.setAttribute("list", list);
			
			RequestDispatcher rd = 
					req.getRequestDispatcher("/view/board/list.jsp");
			rd.forward(req, res);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}











