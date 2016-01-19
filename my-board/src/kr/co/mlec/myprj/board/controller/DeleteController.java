package kr.co.mlec.myprj.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.myprj.board.MiniBoardVO;
import kr.co.mlec.myprj.board.dao.BoardDAO;

@WebServlet("/board/delete")
public class DeleteController extends HttpServlet {
	
	public DeleteController() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int no = Integer.parseInt(req.getParameter("no"));
		BoardDAO dao = new BoardDAO();
		MiniBoardVO vo = new MiniBoardVO();
		vo.setNo(no);
		try {
			
			// 게시판 삭제
			dao.deleteBoard(vo);
			// 파일 삭제	
			dao.deleteFileByBoardNo(no);
			// 댓글 삭제
			dao.deleteCommentByBoardNo(no);
			
			// 삭제 후 목록페이지로 이동
			res.sendRedirect("list");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}












