package bitmem.servlets.qna;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitmem.dao.qna.QnaDao;
import bitmem.vo.qna.QnaCommentVO;
import bitmem.vo.qna.QnaVO;

@SuppressWarnings("serial")
@WebServlet("/qna/detail")
public class QnaListOneServlet extends HttpServlet {
	
	@Override
	protected void doGet(
			HttpServletRequest request, 
				HttpServletResponse response) 
					throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		try {
			ServletContext sc = request.getServletContext();
			QnaDao qnaDao = (QnaDao)sc.getAttribute("qnaDao");
			
			QnaVO vo = new QnaVO();
			
			vo = qnaDao.selectQnaByNo(no);
			List<QnaCommentVO> list =qnaDao.selectCommentQna(no);
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("/view/qnaBoard/qnaDetail.jsp");
			request.setAttribute("qna", vo);
			request.setAttribute("list", list);
			rd.forward(request, response);
			
		} catch (Exception e) { 
			throw new ServletException(e);
		}
	}
}

	
