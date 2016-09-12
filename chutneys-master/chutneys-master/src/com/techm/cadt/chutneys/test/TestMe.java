package com.techm.cadt.chutneys.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestMe {

	public static void main(String[] args) throws Exception {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		// add application code here
		conn.close();
	}

}
