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

@WebServlet("/login/logout")
public class LogoutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 세션에 설정된 user 를 삭제(전체 삭제)
		HttpSession session = req.getSession();
		session.invalidate();
		
		// WebApplication  경로 얻기 : /MyProject
		String contextPath = req.getContextPath();
		res.sendRedirect(contextPath + "/main");
	}
}








