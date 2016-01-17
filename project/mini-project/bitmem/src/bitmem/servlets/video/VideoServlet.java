package bitmem.servlets.video;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitmem.vo.video.VideoVo;


@SuppressWarnings("serial")
@WebServlet("/video/main")
public class VideoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int index = 1;
		Parser parser = new Parser();
		if(req.getParameter("index")!=null){
			index = Integer.parseInt(req.getParameter("index"));
		}
		try {
			List<VideoVo> list = new ArrayList<>();
			List<VideoVo> videoList = parser.execute();
			int size = 0;
			double temp = (double)videoList.size()/15;
			if(videoList.size()/15 < temp){
				size=videoList.size()/15+1;
			}else{
				size=videoList.size();
			}
			int max = index*15;
			if(max>videoList.size()){
				max=videoList.size();
			}
			for(int i=(index*15)-14 ;i<=max;i++){	
				list.add(videoList.get(i-1));
			}
			RequestDispatcher rd = req.getRequestDispatcher("video.jsp");
			req.setAttribute("recentIndex", index);
			req.setAttribute("size", size);
			req.setAttribute("videos", list);
			rd.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
