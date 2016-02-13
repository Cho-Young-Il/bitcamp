//Gson 구글 제공 리이브러리 사용함
package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/exam/MemberDetail4")
public class Exam01Detail4 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String result = "";
		try {
			Exam01DAO dao = new Exam01DAO();
			
			int cnt = 0;
			MemberVO member = dao.detail(id);
			
			Gson gson = new Gson();
			result = gson.toJson(member);
			
			System.out.println("result : " + result);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		res.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println(result);
		out.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Exam01Detail4().doGet(null, null);
	}
}


















