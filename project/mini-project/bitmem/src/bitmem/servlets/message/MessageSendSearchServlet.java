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
@WebServlet("/msg/sendList")
public class MessageSendSearchServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = req.getServletContext();
		MsgDao msgDao = (MsgDao) sc.getAttribute("msgDao");
		MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
		
		HttpSession session = req.getSession();
		Member member = (Member)session.getAttribute("member");
		
		String id = member.getId();
		
		
		try {
			List<Member> memberVO = memberDao.selectList();
			List<MessageVO> sendList = msgDao.selectSendMessage(id);
			RequestDispatcher rd = req.getRequestDispatcher("sendList.jsp");
			req.setAttribute("memberVO", memberVO);
			req.setAttribute("sendList", sendList);
			rd.forward(req, resp);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
