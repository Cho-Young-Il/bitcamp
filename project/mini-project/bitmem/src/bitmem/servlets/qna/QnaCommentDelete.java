package bitmem.servlets.qna;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitmem.dao.qna.QnaDao;

@SuppressWarnings("serial")
@WebServlet("/qna/qnaCommentDelete")
public class QnaCommentDelete extends HttpServlet {

	@Override
	protected void doGet(
			HttpServletRequest request,
				HttpServletResponse response) 
					throws ServletException, IOException {
		
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		int no = Integer.parseInt(request.getParameter("no"));
		
		ServletContext sc = request.getServletContext();
		QnaDao qnaDao = (QnaDao)sc.getAttribute("qnaDao");
		
		try {
			qnaDao.deleteCommentByQnaNO(commentNo);
			response.sendRedirect("detail?no=" + no);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	

}
