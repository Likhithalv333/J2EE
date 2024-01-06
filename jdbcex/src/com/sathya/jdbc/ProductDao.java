package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	
	public int createProducttable()
	{
		Connection connection = null; 
		Statement statement = null; 
		int result = 0; 
		
		try {
		connection = DataBaseConnectionUtils.createConnection();	
		statement = connection.createStatement();
		String query = "create table PRODUCT_INFO(proId varchar2(30) primary key, proName varchar2(20), proPrice number)";

		result = statement.executeUpdate(query);
		}
		catch(SQLException e) {
		    e.printStackTrace();
		    System.out.println("Error creating table: " + e.getMessage());
		}

		finally {
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
	
	
	public int saveProduct(Product p) {
		int result=0;
		try(Connection connection = DataBaseConnectionUtils.createConnection()){
			//create the ps object with params
			PreparedStatement preparedStatement = connection.prepareStatement("insert into product_info values(?,?,?)");
			
			//set the data to params
			preparedStatement.setString(1, p.getProId());
			preparedStatement.setString(2, p.getProName());
			preparedStatement.setDouble(3, p.getProPrice());
			
			//execute the query
			result = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	 

	
	public Product findById(String proId) {
		// TODO Auto-generated method stub
		Product p=null;
		  try(Connection connection = DataBaseConnectionUtils.createConnection()){
	
				PreparedStatement preparedStatement = connection.prepareStatement("select * from product_info where proId=?");
				//set the data to params
				preparedStatement.setString(1, proId);
				//execute the query
				 ResultSet resultSet=preparedStatement.executeQuery();
				 if(resultSet.next()) {
					 //read the data and setting data to product object
					 p = new Product();
					 p.setProId(resultSet.getString(1));
					 p.setProName(resultSet.getString(2));
					 p.setProPrice(resultSet.getDouble(3));
				 }
		  }
			 catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return p;
		  
	}


	public List<Product> findAll()
	{	List<Product> products = new ArrayList<Product>();
		Product p = null;
		try(Connection connection = DataBaseConnectionUtils.createConnection())
		{
			Statement statement = connection.createStatement();
			ResultSet resultSet =  statement.executeQuery("select * from product_info");
			
			while(resultSet.next())
			{	//read the data from ResultSer & setting to product
				p = new Product();
				p.setProId(resultSet.getString(1));
				p.setProName(resultSet.getString(2));
				p.setProPrice(resultSet.getDouble(3));
				
				//adding the product into List.
				products.add(p);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return products;


}
	public int updateProduct(double price,double incValue)
	{	int result = 0;
		try(Connection connection = DataBaseConnectionUtils.createConnection())
		{	//create the PS object
			PreparedStatement preparedStatement = connection.prepareStatement("update product_info set proPrice=proPrice+? where proPrice>?");
			//set the data to params 
			preparedStatement.setDouble(1, incValue);
			preparedStatement.setDouble(2, price);
			//execute the query 
			result =  preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{	e.printStackTrace();
		}
		return result;
	}		
	public int deleteProductById(String proId)  {
		int result=0;
		try(Connection connection = DataBaseConnectionUtils.createConnection()){
			PreparedStatement preparedStatement=connection.prepareStatement("delete from product_info where proId=?");
			//set the data to params
			preparedStatement.setString(1, proId);
			//execute the query
			result = preparedStatement.executeUpdate();
			}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
		}
	public int deleteProductByPrice(double price)  {
		int result=0;
		try(Connection connection = DataBaseConnectionUtils.createConnection()){
			PreparedStatement preparedStatement=connection.prepareStatement("delete from product_info where proPrice=?");
			//set the data to params
			preparedStatement.setDouble(1, 200);
			//execute the query
			result = preparedStatement.executeUpdate();
			}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
		}

	public int droptable()
	{	int result=0;
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