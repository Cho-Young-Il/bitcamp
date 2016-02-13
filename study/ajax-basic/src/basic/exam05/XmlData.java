package basic.exam05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/xmlData")
public class XmlData extends HttpServlet{
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/xml; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String xml = "";
		xml += "<members>";
		xml += "	<member>";
		xml += "		<id>hong</id>";
		xml += "		<name>홍길동</name>";
		xml += "		<pass>1111</pass>";
		xml += "	</member>";
		xml += "	<member>";
		xml += "		<id>kim</id>";
		xml += "		<name>김길동</name>";
		xml += "		<pass>2222</pass>";
		xml += "	</member>";
		xml += "</members>";
		out.println(xml);
		out.close();
	}
}
