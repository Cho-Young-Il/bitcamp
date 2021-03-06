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

@SuppressWarnings("serial")
@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet{
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			ServletContext sc = this.getServletContext();
			MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
			
			memberDao.delete(request.getParameterValues("numbers"));
			response.sendRedirect("manager");
			
		} catch(Exception e) {
			e.printStackTrace();
		    request.setAttribute("error", e);
		    RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
		    rd.forward(request, response);
		}
	}
}
