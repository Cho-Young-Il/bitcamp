package bitmem.servlets.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bitmem.dao.member.MemberDao;
import bitmem.vo.member.Member;

@WebServlet("/auth/main")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(
				"/auth/mainPage.jsp");
		rd.forward(request, response);
	}
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ServletContext sc = this.getServletContext();
			
			MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
			Member member = memberDao.exist(new Member()
						.setId(request.getParameter("id"))
						.setPassword(request.getParameter("password")));
			
			String viewPath = null;
			
			if(member == null) {
				viewPath = "/auth/loginFail.jsp";
			} else {
				if(member.getPermission() == 0) {
					viewPath = "/auth/confirming.jsp";
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("member", member);
					viewPath = "main";
					response.sendRedirect("main");
					return;
				}
			}
			
			RequestDispatcher rd = request.getRequestDispatcher(viewPath);
			rd.forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
}
