package bitmem.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitmem.vo.member.Member;

@WebFilter("*")
public class AuthorizeFilter implements Filter {
	@Override
	public void init(FilterConfig config) throws ServletException {}

	@Override
	public void doFilter(
			ServletRequest request, ServletResponse response,
			FilterChain nextFilter) throws IOException, ServletException {
		checkSession((HttpServletRequest)request,
				(HttpServletResponse)response, nextFilter);
	}
	
	private void checkSession(
			HttpServletRequest request, HttpServletResponse response,
			FilterChain nextFilter) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			Member member = (Member)session.getAttribute("member");
			String servletPath = request.getServletPath();
			if(member == null) {
				if(servletPath.equals("/board/update") ||
				   servletPath.equals("/board/detail") ||
				   servletPath.equals("/board/regist") ||
				   servletPath.equals("/board/recom") ||
				   servletPath.equals("/board/delete") ||
				   servletPath.equals("/board/commentRegist") ||
				   servletPath.equals("/board/commentDelete") ||
				   servletPath.equals("/board/list") ||
				   servletPath.equals("/msg/main") ||
				   servletPath.equals("/msg/msgSend") ||
				   servletPath.equals("/msg/sendList") ||
				   servletPath.equals("/msg/sendDelete") ||
				   servletPath.equals("/msg/receiveList") ||
				   servletPath.equals("/msg/receiveDelete") ||
				   servletPath.startsWith("/member/list") || 
				   servletPath.startsWith("/video/main") ||
				   servletPath.startsWith("/algorithm")
				) {
					RequestDispatcher rd = 
							request.getRequestDispatcher("/auth/authError.jsp");
					rd.forward(request, response);
					return;
				}
			} else {
				if(!member.getAuth().equals("S")) {
					if(servletPath.equals("/member/manager") ||
					   servletPath.equals("/member/delete") ||
					   servletPath.equals("/qna/delete") ||
					   
					   (servletPath.equals("/board/delete")
							   && !member.getId().equals(request.getParameter("id")))||
					   (servletPath.equals("/board/update")
							   && !member.getId().equals(request.getParameter("id")))||
	    			   (servletPath.equals("/msg/sendDelete") 
			    			   && !member.getId().equals(request.getParameter("id"))) ||
	    			   (servletPath.equals("/msg/receiveDelete") 
			    			   && !member.getId().equals(request.getParameter("id"))) ||
					   (servletPath.equals("/member/update") 
			    			   && member.getNo() != 
			    			   Integer.parseInt(request.getParameter("no")))
					){
						RequestDispatcher rd = 
								request.getRequestDispatcher("/auth/authError.jsp");
						rd.forward(request, response);
						return;
					}
				}
				if(member.getPermission() == 0 &&
						!servletPath.equals("/auth/main")) {
					RequestDispatcher rd = 
							request.getRequestDispatcher("/auth/confirming.jsp");
					rd.forward(request, response);
					return;
				}
			}
			nextFilter.doFilter(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
			throw new ServletException(e);
		}
	}
	
	@Override
	public void destroy() {}
}
