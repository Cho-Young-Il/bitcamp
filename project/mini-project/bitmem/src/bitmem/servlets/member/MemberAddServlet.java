package bitmem.servlets.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitmem.dao.member.MemberDao;
import bitmem.vo.member.Member;

@WebServlet("/member/add")
@SuppressWarnings("serial")
public class MemberAddServlet extends HttpServlet{
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(
				"/member/memberRegist.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {		
			ServletContext sc = this.getServletContext();
			MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
			memberDao.insert(new Member()
					.setName(request.getParameter("name"))
					.setId(request.getParameter("id"))
					.setPassword(request.getParameter("pass"))
					.setBirth(request.getParameter("birth"))
					.setPhoneNo(request.getParameter("phone"))
					.setEmail(request.getParameter("email"))
					.setGender(request.getParameter("gender"))
					.setAuth("U"));
			
			RequestDispatcher rd = request.getRequestDispatcher("/member/compRegist.jsp");
			rd.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
}
