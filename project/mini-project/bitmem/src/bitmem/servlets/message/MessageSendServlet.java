package bitmem.servlets.message;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitmem.dao.member.MemberDao;
import bitmem.dao.message.MsgDao;
import bitmem.vo.member.Member;
import bitmem.vo.message.MessageVO;

@SuppressWarnings("serial")
@WebServlet("/msg/msgSend")
public class MessageSendServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = req.getServletContext();
		MemberDao memberDao = (MemberDao) sc.getAttribute("memberDao");
		RequestDispatcher rd = req.getRequestDispatcher("msgSend.jsp");
		try {
			List<Member> list = memberDao.selectList();
			req.setAttribute("list", list);
			rd.forward(req, resp);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		ServletContext sc = req.getServletContext();
		
		HttpSession session = req.getSession();
		Member member = (Member)session.getAttribute("member");
		
		String id = member.getId();
		
		MessageVO sendMsg = new MessageVO();
		sendMsg.setSender(id);
		sendMsg.setReceiver(req.getParameter("receiver"));
		sendMsg.setContent(req.getParameter("content"));
		
		MessageVO receiveMsg = new MessageVO();
		receiveMsg.setSender(id);
		receiveMsg.setReceiver(req.getParameter("receiver"));
		receiveMsg.setContent(req.getParameter("content"));
		
		MsgDao msgDao = (MsgDao) sc.getAttribute("msgDao");
		try {
			msgDao.insertSendMessage(sendMsg);
			msgDao.insertReceiveMessage(receiveMsg);
			resp.sendRedirect("main");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
