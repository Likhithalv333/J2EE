package com.sathya.batch;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class batchex {

		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","likhi","welcome");
			
		Statement statement = connection.createStatement();
			
			statement.addBatch("create table okrams(color varchar2(30),height number)");
			statement.addBatch("insert into okrams values('black',5.6)");
			statement.addBatch("insert into okrams values('red',6.6)");
			statement.addBatch("insert into okrams values('green',7.6)");
			statement.addBatch("delete from okrams where height>=6.0");
			statement.addBatch("drop table okrams");
			
			int[] results = statement.executeBatch();
			
			for(int result : results) {
				System.out.println(result);
			}
			connection.close();
		}
	}
