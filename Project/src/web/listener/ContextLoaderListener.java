package web.listener;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import web.dao.BoardDao;
import web.dao.MysqlMemberDao;

public class ContextLoaderListener implements ServletContextListener {
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			System.out.println("contextDestroyed");

		}catch(Exception e) {
			e.printStackTrace();
		}		

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			System.out.println("contextInitialized");
			ServletContext sc = sce.getServletContext();

			InitialContext initialContext = new InitialContext();
			DataSource ds = (DataSource)initialContext.lookup(
					"java:comp/env/jdbc/knittingdb");
			BoardDao boardDao = new BoardDao();
			MysqlMemberDao memberDao = new MysqlMemberDao();
			boardDao.setDataSource(ds);
			memberDao.setDataSource(ds);
			
			
			sc.setAttribute("boardDao", boardDao);
			sc.setAttribute("memberDao", memberDao);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
