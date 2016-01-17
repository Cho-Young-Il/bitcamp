package bitmem.servlets.algorithm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/algorithm/sort")
public class SortAlgoritmServlet extends HttpServlet{
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mode = request.getParameter("mode");
		if(mode == null) {
			mode = "1";
		}
		RequestDispatcher rd = request.getRequestDispatcher(
				"/algorithm/sortMode" + mode +".jsp");
		rd.forward(request, response);
	}
}
