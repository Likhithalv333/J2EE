package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Transctionsex {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","likhi","welcome");
		Statement statement = connection.createStatement();
		connection.setAutoCommit(false);
		try {
			statement.executeUpdate("insert into emp values(1001,'Likhii',1000000.68)");
			statement.executeUpdate("insert into emp values(1002,'Saii',200000.58)");
			statement.executeUpdate("insert into emp values(1003,'Maha',300000.98)");
			statement.executeUpdate("insert into emp values(1004,'Mouni',400000.94)");
			statement.executeUpdate("insert into emp values(1005,'Harshu',500000.98)");
			statement.executeUpdate("delete from emp where empid=1001");
			
			connection.commit();
			System.out.println("trasactions are successful...");
			} catch (SQLException e) {
				e.printStackTrace();
				connection.rollback();
				System.out.println("transaction is fail & rollback..");
			}
			finally {
				connection.close();
				statement.close();
			}
		System.out.println("Operations are completed..");
		

	}

}
