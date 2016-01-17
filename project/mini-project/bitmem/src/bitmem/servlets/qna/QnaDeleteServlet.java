package bitmem.servlets.qna;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitmem.dao.qna.QnaDao;
import bitmem.vo.qna.QnaVO;

@SuppressWarnings("serial")
@WebServlet("/qna/qnadelete")
public class QnaDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(
			HttpServletRequest request, 
				HttpServletResponse response) 
					throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		QnaVO vo = new QnaVO();
			
		ServletContext sc = request.getServletContext();
		QnaDao qnaDao = (QnaDao)sc.getAttribute("qnaDao");
		vo.setNo(no);
		try {
			qnaDao.deleteQna(vo);
			response.sendRedirect("list");
		} catch (Exception e) {
			throw new ServletException(e);
		}
			
		
		
		
	}
	

}
