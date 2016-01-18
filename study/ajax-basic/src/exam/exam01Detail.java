package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exam/member-detail")
public class Exam01Detail extends HttpServlet {
	@Override
	protected void doGet(
		HttpServletRequest request, HttpServletResponse response)
		throws ServletException {

		String id = request.getParameter("id");

		String result = "";

		try {
			Exam01DAO dao = new Exam01DAO();

			int cnt = 0;
			MemberVO member = dao.detail(id);
			result += member.getId() + ":" +
					  member.getname() + ":" +
					  member.getPass();

		} catch(Exception e) {
			throw new ServletException(e);
		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		out.close();
	}
}