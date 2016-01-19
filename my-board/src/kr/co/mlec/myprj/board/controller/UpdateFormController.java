package kr.co.mlec.myprj.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.myprj.board.MiniBoardVO;
import kr.co.mlec.myprj.board.dao.BoardDAO;

@WebServlet("/board/updateForm")
public class UpdateFormController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 수정하려는 게시글의 글번호를 얻는다.
		int no = Integer.parseInt(req.getParameter("no"));
		BoardDAO dao = new BoardDAO();
		try {
			// updateForm.jsp 에서 사용할 게시물 객체
			MiniBoardVO board = dao.selectBoardByNo(no);
			req.setAttribute("board", board);
			
			// 페이지 이동
			RequestDispatcher rd = 
					req.getRequestDispatcher(
							"/view/board/updateForm.jsp");
			rd.forward(req, res);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}





