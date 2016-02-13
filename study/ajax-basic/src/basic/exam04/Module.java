package basic.exam04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/basic/exam04/module")
public class Module extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id    = req.getParameter("id");
		String name  = req.getParameter("name");
		String email = req.getParameter("email");
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("id : " + id);
		out.println("name : " + name);
		out.println("email : " + email);
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String id    = req.getParameter("id");
		String name  = req.getParameter("name");
		String email = req.getParameter("email");
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("id : " + id);
		out.println("name : " + name);
		out.println("email : " + email);
		out.close();
	}
}










