package kr.co.mlec.myprj.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/registForm")
public class RegistFormController extends GenericServlet {

	@Override
	public void service(
			ServletRequest req, ServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = 
				req.getRequestDispatcher(
						"/view/board/registForm.jsp");
		rd.forward(req, res);
		
		/*
		HttpServletResponse hRes = 
					(HttpServletResponse)res;
		hRes.sendRedirect("/ServletJSP/view/board/registForm.jsp");
		*/
	}
}








