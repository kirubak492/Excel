package com.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	
	static String uname="root";
	static String pass="1234";
	static String url="jdbc:mysql://localhost:3306/excel";
	
	public static Connection getconnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url,uname,pass);
	}
}
