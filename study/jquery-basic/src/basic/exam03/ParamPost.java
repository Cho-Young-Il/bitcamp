// /Ajax-basic/basic/exam03/paramGet?name=hong
// 위의 Ajax 호출과 매핑되도록 경로 설정 및
// name 파라미터 값을 꺼낸다음 다시 돌려주도록 코드 작성
package basic.exam03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/basic/exam03/paramPost")
public class ParamPost extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println(name);
		out.close();
	}
}










