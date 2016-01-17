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
@WebServlet("/qna/regist")
public class QnaRegistServlet extends HttpServlet {

	@Override
	protected void doGet(
			HttpServletRequest request, 
				HttpServletResponse response) 
					throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/view/qnaBoard/qnaRegistForm.jsp");
	}
	@Override
	protected void doPost(
			HttpServletRequest request, 
				HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		QnaVO vo = new QnaVO();
		vo.setTitle(request.getParameter("title"));
		vo.setWriter(request.getParameter("writer"));
		vo.setContent(request.getParameter("content"));
		
		
		ServletContext sc = request.getServletContext();
		QnaDao qnaDao = (QnaDao)sc.getAttribute("qnaDao");
		try {
			qnaDao.insertQna(vo);
			response.sendRedirect("list");
		} catch (Exception e) {
			throw new ServletException(e);
	}
			
	}
}