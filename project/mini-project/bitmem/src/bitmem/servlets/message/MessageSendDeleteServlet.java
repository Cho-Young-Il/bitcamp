package bitmem.servlets.message;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitmem.dao.message.MsgDao;

@SuppressWarnings("serial")
@WebServlet("/msg/sendDelete")
public class MessageSendDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int no = Integer.parseInt(req.getParameter("no"));
		ServletContext sc = req.getServletContext();
		MsgDao msgDao = (MsgDao) sc.getAttribute("msgDao");
		
		try {
			msgDao.deleteSendMessage(no);
			resp.sendRedirect("sendList");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	} 
	
}
