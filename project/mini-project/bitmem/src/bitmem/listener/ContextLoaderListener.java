package bitmem.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import bitmem.dao.board.OracleBoardDao;
import bitmem.dao.member.OracleMemberDao;
import bitmem.dao.message.OracleMsgDao;
import bitmem.dao.qna.OracleQnaDao;
import bitmem.util.DBConnectionPool;

@WebListener
public class ContextLoaderListener implements ServletContextListener{
	private DBConnectionPool connPool;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			ServletContext sc = event.getServletContext();
			
			connPool = new DBConnectionPool(
					sc.getInitParameter("driver"),
					sc.getInitParameter("url"),
					sc.getInitParameter("username"),
					sc.getInitParameter("password"));
			
			OracleMemberDao memberDao = new OracleMemberDao();
			OracleBoardDao  boardDao  = new OracleBoardDao();
			OracleQnaDao	qnaDao	  = new OracleQnaDao();
			OracleMsgDao	msgDao	  = new OracleMsgDao();
			
			memberDao.setDbConnectionPool(connPool);
			boardDao.setDbConnectionPool(connPool);
			qnaDao.setDbConnectionPool(connPool);
			msgDao.setDbConnectionPool(connPool);
			
			sc.setAttribute("memberDao", memberDao);
			sc.setAttribute("boardDao", boardDao);
			sc.setAttribute("qnaDao", qnaDao);
			sc.setAttribute("msgDao", msgDao);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		connPool.closeAll();
	}
}
