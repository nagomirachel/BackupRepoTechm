package com.techm.cadt.chutneys.db.addons;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.h2.tools.RunScript;

@WebListener
public class DatabaseManager implements ServletContextListener {

	private static String DB_URL       = null;
	private static String DB_USER      = null;
	private static String DB_PASSWORD  = null;
	
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		try {
			org.h2.Driver.load();
			ServletContext servletContext = servletContextEvent.getServletContext();
			DB_URL      = servletContext.getInitParameter("H2_DB_URL");
			DB_USER     = servletContext.getInitParameter("H2_DB_USER");
			DB_PASSWORD = servletContext.getInitParameter("H2_DB_PASSWORD");
			
			//System.out.println("Database is to be created : " + DB_URL + " -> "+ DB_USER + "/" + DB_PASSWORD);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			servletContext.setAttribute("connection", conn);
			
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("/resources/chutneys_db.sql");
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream ));
			RunScript.execute(conn, reader);
			
			//Initialize entity Manager
			JPAEntityManager.initialize();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement stat = conn.createStatement();
			stat.execute("SHUTDOWN");
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
