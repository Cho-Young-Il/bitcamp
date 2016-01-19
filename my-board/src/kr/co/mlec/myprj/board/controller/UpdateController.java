package kr.co.mlec.myprj.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.myprj.board.MiniBoardVO;
import kr.co.mlec.myprj.board.dao.BoardDAO;

@WebServlet("/board/update")
public class UpdateController extends HttpServlet {
	
	public UpdateController() {}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		int no = Integer.parseInt(req.getParameter("no"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		MiniBoardVO vo = new MiniBoardVO();
		vo.setNo(no);
		vo.setTitle(title);
		vo.setContent(content);
		
		try {
			BoardDAO dao = new BoardDAO();
			dao.updateBoard(vo);
			
			// 수정 후 목록페이지로 이동
			res.sendRedirect("list");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}






