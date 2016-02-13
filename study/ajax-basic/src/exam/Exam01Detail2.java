package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exam/MemberDetail2")
public class Exam01Detail2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String result = "";
		try {
			Exam01DAO dao = new Exam01DAO();
			
			int cnt = 0;
			MemberVO member = dao.detail(id);
			result += "<member>";
			result += "<id>";
			result += member.getId();
			result += "</id>";
			result += "<name>";
			result +=  member.getName();
			result += "</name>";
			result += "<pass>";
			result +=  member.getPass();
			result += "</pass>";
			result += "</member>";
			System.out.println("result : " + result);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		res.setContentType("text/xml; charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println(result);
		out.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Exam01Detail2().doGet(null, null);
	}
}


















