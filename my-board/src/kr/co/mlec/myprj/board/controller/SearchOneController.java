package kr.co.mlec.myprj.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.myprj.board.MiniBoardVO;
import kr.co.mlec.myprj.board.MiniBoardCommentVO;
import kr.co.mlec.myprj.board.MiniBoardFileVO;
import kr.co.mlec.myprj.board.dao.BoardDAO;

@WebServlet("/board/detail")
public class SearchOneController extends HttpServlet {
	
	public SearchOneController() {}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int no = Integer.parseInt(req.getParameter("no"));
		try {
			BoardDAO dao = new BoardDAO();

			// 조회수 추가
			// 목록에서 호출된 경우만 조회수를 증가시킨다.
			// 어떤 페이지에서 호출했는지 판단하는 파라미터
			String call = req.getParameter("call");
			if (call != null && call.equals("viewCnt")) {
				// 조회수 증가
				dao.updateViewCnt(no);
			}
			
			// 게시물 정보 조회
			MiniBoardVO vo = dao.selectBoardByNo(no);

			// 이전글, 다음글 정보 추가
			vo.setPrev(dao.selectPrevBoard(no));
			vo.setNext(dao.selectNextBoard(no));
			
			// 게시물 파일 정보 조회
			List<MiniBoardFileVO> fileList = 
									dao.selectFile(no);
			
			// 댓글 정보 조회
			List<MiniBoardCommentVO> commentList = 
					dao.selectComment(no);
			req.setAttribute("commentList", commentList);
			
			// JSP에서 화면 처리하도록 변경
			// WebContent/view/board/detail.jsp
			RequestDispatcher rd = 
					req.getRequestDispatcher("/view/board/detail.jsp");
			
			// 공유영역에 데이터 등록
			req.setAttribute("content", vo);
			req.setAttribute("fileList", fileList);
			rd.forward(req, res);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}







