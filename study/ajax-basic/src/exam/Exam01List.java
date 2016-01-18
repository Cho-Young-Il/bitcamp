package exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exam/member-list")
public class Exam01List extends HttpServlet {
	@Override
	protected void doGet(
		HttpServletRequest request, HttpServletResponse response)
		throws ServletException {
			//데이터 베이스를 접근한후 회원 목록 리스트를 얻어온다.
			//회원목록 리스트의 데이터를 꺼내서
			//자바스크립트에서 사용할 수 있는 데이터의 형태로 문자열 변환을 진행한다.
			//생성된 배열의 내용을 화면으로 출력한다.

			String result = "[";
			try {
				Exam01DAO dao = new Exam01DAO();

				int cnt = 0;
				List<MemberVO> list = dao.list();
				for(MemberVO member : list) {
					if(cnt++ != 0) {
						result += ", ";
					}
					result += "\"" + member.getId() + ":" + member.getName() + "\"";
				}
				result += "]";
			} catch(Exception e) {
				throw new ServletException(e);
			}
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(result);
			out.close();
		}
}