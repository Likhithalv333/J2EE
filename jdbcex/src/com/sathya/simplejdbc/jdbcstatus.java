package com.sathya.simplejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class jdbcstatus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","likhi","welcome");
		System.out.println("connection created");
		}
		catch (Exception e) {
						e.printStackTrace();
		}
		try {
			connection.close();
			System.out.println("connection closed..");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
