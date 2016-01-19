package kr.co.mlec.myprj.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.myprj.board.MiniBoardCommentVO;
import kr.co.mlec.myprj.board.dao.BoardDAO;

@WebServlet("/board/commentDelete")
public class BoardCommentDeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// 파라미터 꺼내기
		int no = Integer.parseInt(req.getParameter("no"));
		int commentNo = Integer.parseInt(
							req.getParameter("commentNo"));
		
		// DAO 호출하기
		BoardDAO dao = new BoardDAO();
		try {
			dao.deleteComment(commentNo);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		// 페이지 이동하기
		res.sendRedirect("detail?no=" + no);
	}
}











