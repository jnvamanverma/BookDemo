package com.db.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private Connection connection;

	public Connection getConnection() {
		// load the driver class

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver loading Error..." + e);
		}

		// Connection object

		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
			System.out.println("Connected successfully");
		} catch (SQLException e) {
			System.out.println("Connection error..." + e);
		}

		return connection;
	}

	/*
	public static void main(String args[]){
		System.out.print(new DBUtil().geConnection());
	}
	*/
}
