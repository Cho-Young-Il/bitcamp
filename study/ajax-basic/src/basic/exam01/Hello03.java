package basic.exam01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/idCheck")
public class Hello03 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 사용자가 입력한 체크하려는 아이디
		String id = req.getParameter("id");
		
		// 임시 회원 디비
		ArrayList<String> idList = 
				new ArrayList<>();
		idList.add("aaa");
		idList.add("bbb");
		idList.add("ccc");
		
		// 실제 회원테이블로 변경처리
		
		
		String msg = "사용 가능한 아이디 입니다.";
		if (idList.indexOf(id) != -1) {
			msg = "이미 사용중인 아이디 입니다.";
		}
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println(msg);
		out.close();
	}
}












