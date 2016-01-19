package kr.co.mlec.myprj.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.myprj.login.dao.LoginDAO;
import kr.co.mlec.myprj.login.vo.LoginVO;

@WebServlet("/login/login")
public class LoginServlet extends HttpServlet {
	
	/**
	 *   로그인 폼으로 이동시킴
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// WebApplication  경로 얻기 : /MyProject
		String contextPath = req.getContextPath();
		res.sendRedirect(contextPath + "/view/login/login.jsp");
	}

	/**
	 * 로그인 처리 진행
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id   = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		LoginVO member = new LoginVO();
		member.setId(id);
		member.setPass(pass);
		
		LoginDAO dao = new LoginDAO();
		try {
			String contextPath = req.getContextPath();
			LoginVO result = dao.selectMember(member);
			if (result == null) {
				// 로그인 실패시 로그인 폼으로 이동
				res.sendRedirect(contextPath + "/view/login/login.jsp");
			} else {
				// 로그인 성공 
				// 세션에 로그인 객체를 등록함
				HttpSession session = req.getSession();
				session.setAttribute("user", result);
				
				// 메인 페이지로 이동함
				res.sendRedirect(contextPath + "/main");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}








