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
import bitmem.vo.qna.QnaVO;

@SuppressWarnings("serial")
@WebServlet("/qna/list")
public class QnaListServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, 
				HttpServletResponse response)
						throws ServletException, IOException {
		
		try {
			ServletContext sc = request.getServletContext();
			QnaDao qnaDao = (QnaDao)sc.getAttribute("qnaDao");
			
			List<QnaVO> qnaList = qnaDao.selectQna();
			
			request.setAttribute("qnaList", qnaList);
			RequestDispatcher rd = request.getRequestDispatcher(
					"/view/qnaBoard/qnaList.jsp");
			rd.forward(request, response);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
}
