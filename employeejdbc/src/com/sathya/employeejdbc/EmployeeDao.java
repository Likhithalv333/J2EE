// EmployeeDao.java
package com.sathya.employeejdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class EmployeeDao {

    public int createEmployeeTable() {
        Connection connection = null;
        Statement statement = null;
        int result = 0;

        try {
            // Create a connection
            connection = DataBaseConnectionUtils.createConnection();

            // Create a statement
            statement = connection.createStatement();

            // Execute SQL to create a table
            String sql = "CREATE TABLE EMPLOYEE_INFO(empId VARCHAR2(30) PRIMARY KEY, empName VARCHAR2(20), empSalary NUMBER)";
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creating table: " + e.getMessage());
        } finally {
            // Close resources in a finally block to ensure they are closed even if an exception occurs
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    public int saveEmployee(Employee e) {
    	int result=0;
    	try(Connection connection=DataBaseConnectionUtils.createConnection()){
    		PreparedStatement preparedStatement=connection.prepareStatement("insert into EMPLOYEE_INFO values(?,?,?)");
    		//set the data to params
    		preparedStatement.setString(1, e.getEmpId());
    		preparedStatement.setString(2, e.getEmpName());
    		preparedStatement.setDouble(3, e.getEmpSalary());
    		//execute query
    		result=preparedStatement.executeUpdate();
    		//
    	}catch (SQLException e1) {
			// TODO: handle exception
    		e1.printStackTrace();
		}
		return result;
    	
    }
    public Employee findById(String empId) throws SQLException {
    	Employee e=null;
    	try(Connection connection = DataBaseConnectionUtils.createConnection() ){
    		PreparedStatement preparedStatement=connection.prepareStatement("select * from Employee_info where empId=?");
    		//set the data to params
    		preparedStatement.setString(1, empId);
    		//execute the query
    		ResultSet resultSet=preparedStatement.executeQuery();
    		if(resultSet.next()) {
    			e = new Employee();
    			e.setEmpId(resultSet.getString(1));
    			e.setEmpName(resultSet.getString(2));
    			e.setEmpSalary(resultSet.getDouble(3));
    			
    		}
    	}
    		catch (SQLException e2) {
				e2.printStackTrace();
			}
    	
		return e;
    	
    	}
    public List<Employee> findAll() throws SQLException {
		List<Employee> employees = new ArrayList<Employee>();
		Employee e=null;
		try(Connection connection = DataBaseConnectionUtils.createConnection()){
			Statement statement = connection.createStatement();
			//EXecute the query
			 ResultSet resultSet = statement.executeQuery("select * from EMPLOYEE_INFO");
			 while(resultSet.next()) {
				 e = new Employee();
				 e.setEmpId(resultSet.getString(1));
				 e.setEmpName(resultSet.getString(2));
				 e.setEmpSalary(resultSet.getDouble(3));
				 //add employee data to list onject
				 employees.add(e);
			 }
			
		}
		catch (SQLException e2) {
			e2.printStackTrace();
		}
		return employees;
		
    }
    public int updateEmployee(double empSalary,double incValue) throws SQLException {
    	int result=0;
    	try(Connection connection = DataBaseConnectionUtils.createConnection()){
    		PreparedStatement preparedStatement = connection.prepareStatement("update  EMPLOYEE_INFO set empSalary = empSalary+? where empSalary<?");
    		//set the data to params
    		preparedStatement.setDouble(1, incValue);
    		preparedStatement.setDouble(2, empSalary);
    		//execute the query
    		 result=preparedStatement.executeUpdate();
    	}
    	catch (SQLException e) {
		e.printStackTrace();
		}
		return result;
    	
    }
    public int deleteEmployeeById(String empId) throws ClassNotFoundException  {
		int result=0;
		try(Connection connection = DataBaseConnectionUtils.createConnection()){
			PreparedStatement preparedStatement=connection.prepareStatement("delete from EMPLOYEE_INFO where empId=?");
			//set the data to params
			preparedStatement.setString(1, empId);
			//execute the query
			result = preparedStatement.executeUpdate();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		}
    public int deleteEmployeeBySalary(double empSlary)  {
		int result=0;
		try(Connection connection = DataBaseConnectionUtils.createConnection()){
			PreparedStatement preparedStatement=connection.prepareStatement("delete EMPLOYEE_INFO where empSalary=?");
			//set the data to params
			preparedStatement.setDouble(1, empSlary);
			//execute the query
			result = preparedStatement.executeUpdate();
			}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
		}
    
	
	
	public int droptable() {
		int result=0;
		try(Connection connection=DataBaseConnectionUtils.createConnection())
		{
			//create the statement object
			Statement statement = connection.createStatement();
			//execute the query
			result = statement.executeUpdate("drop table EMPLOYEE_INFO");
		}
		catch(SQLException e)
		{	e.printStackTrace();
		}
		return result;
	}
}
	
