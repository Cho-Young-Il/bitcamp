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

@SuppressWarnings("serial")
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			ServletContext sc = this.getServletContext();
			MemberDao memberDao = (MemberDao) sc.getAttribute("memberDao");

			Member member = memberDao.selectOne(Integer.parseInt(request
					.getParameter("no")));

			request.setAttribute("member", member);

			RequestDispatcher rd = request
					.getRequestDispatcher("/member/memberUpdateForm.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		Enumeration<String> param = request.getParameterNames();
//		String password1 = "";
//		String password2 = "";
//		
//		while(param.hasMoreElements()) {
//			String paramName = param.nextElement();
//			String paramElement = request.getParameter(paramName);
//			
//			if(paramName.equals("password1")) {
//				password1 = paramElement;
//			} else if(paramName.equals("password2")) {
//				password2 = paramElement;
//			}
//			if(paramElement == null || paramElement.equals("")) {
//				RequestDispatcher rd = 
//						request.getRequestDispatcher(
//								"/member/memberUpdateFormError.jsp");
//				rd.forward(request, response);
//				return;
//			}
//		}
//		
//		if(!password1.equals(password2)) {
//			RequestDispatcher rd = 
//					request.getRequestDispatcher(
//							"/member/memberUpdateFormError.jsp");
//			rd.forward(request, response);
//			return;
//		}
		
		try {
			response.setCharacterEncoding("utf-8");
			
			ServletContext sc = this.getServletContext();
			MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
			
			String password = request.getParameter("pass");
			if(password != null) {
				memberDao.update(new Member()
						.setNo(Integer.parseInt(request.getParameter("no")))
						.setPassword(password)
						.setPhoneNo(request.getParameter("phone"))
						.setEmail(request.getParameter("email")));
				
				response.sendRedirect("../auth/main");
			} else {
				memberDao.updatePermission(new Member()
				.setNo(Integer.parseInt(request.getParameter("no")))
				.setPermission(Integer.parseInt(request.getParameter("permission")))
				.setClassNo(Integer.parseInt(request.getParameter("classNo"))));
				
				response.sendRedirect("manager");
			}
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
}
