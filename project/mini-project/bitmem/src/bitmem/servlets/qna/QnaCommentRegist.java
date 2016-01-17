package bitmem.servlets.qna;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitmem.dao.qna.QnaDao;
import bitmem.vo.qna.QnaCommentVO;
@SuppressWarnings("serial")
@WebServlet("/qna/qnaCommentRegist")
public class QnaCommentRegist extends HttpServlet {

	@Override
	protected void doPost(
			HttpServletRequest request, 
				HttpServletResponse response) 
					throws ServletException, IOException {
		
		QnaCommentVO vo = new QnaCommentVO();
		vo.setNo(Integer.parseInt(request.getParameter("no")));
		vo.setNickName(request.getParameter("nick_name"));
		vo.setContent(request.getParameter("content"));
		
		ServletContext sc = request.getServletContext();
		QnaDao qnaDao = (QnaDao)sc.getAttribute("qnaDao");
		try {
			qnaDao.insertCommentQna(vo);
			response.sendRedirect("detail?no=" + vo.getNo());
//			RequestDispatcher rd = request.getRequestDispatcher("detail");
//			request.setAttribute("no", vo.getNo());
//			rd.forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
	}
}
