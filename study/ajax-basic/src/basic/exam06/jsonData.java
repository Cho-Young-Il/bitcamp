package basic.exam06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/jsonData")
public class jsonData extends HttpServlet{
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
//		[{"이름" : "값"}, {"이름" : "값"}]
		
		String json = "";
		json += "[";
		json += "	{";
		json += "		\"id\" : \"hong\", ";
		json += "		\"name\" : \"홍길동\", ";
		json += "		\"pass\" : \"1111\" ";
		json += "	},";
		json += "	{";
		json += "		\"id\" : \"kim\", ";
		json += "		\"name\" : \"김길동\", ";
		json += "		\"pass\" : \"2222\" ";
		json += "	}";
		json += "]";
		out.println(json);
		out.close();
	}
}
