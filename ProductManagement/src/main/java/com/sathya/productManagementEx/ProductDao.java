package com.sathya.productManagementEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;

import java.io.IOException;


public class ProductDao {
    public int saveProduct(Product product) throws SQLException {
        int result = 0;
        try (Connection connection = DBConnectionUtils.createConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into product_data values(?,?,?,?,?,?,?,?)");
            // set the data to params
            preparedStatement.setString(1, product.getProId());
            preparedStatement.setString(2, product.getProName());
            preparedStatement.setDouble(3, product.getProPrice());
            preparedStatement.setString(4, product.getProBrand());
            preparedStatement.setString(5, product.getProMadeIn());

            preparedStatement.setDate(6, product.getProMfgDate());
            preparedStatement.setDate(7, product.getProExpDate());

            preparedStatement.setBlob(8, product.getProImage());

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
       
        	
        }
    public List<Product> findAll() {
    	List<Product> products =new ArrayList<Product>();
    	Product product=null;
    	try(Connection connection=DBConnectionUtils.createConnection()){
    		Statement statement=connection.createStatement();
    		ResultSet resultSet =statement.executeQuery("select * from product_data");
    		while(resultSet.next()) {
    			 product = new Product();
	         	  product.setProId(resultSet.getString("proId"));
				  product.setProName(resultSet.getString("proName"));
				  product.setProPrice(Double.parseDouble(resultSet.getString("proPrice")));
				  product.setProBrand(resultSet.getString("proBrand"));
				  product.setProMadeIn(resultSet.getString("proMadeIn"));
				  product.setProMfgDate(resultSet.getDate("proMfgdate"));
				  product.setProExpDate(resultSet.getDate("proExpDate"));
				  product.setReadImage(resultSet.getBytes("proImage"));
				  products.add(product);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return products;
  }
    public int deleteById(String proId) {
		int result=0;
		try(Connection connection=DBConnectionUtils.createConnection();) {
			PreparedStatement preparedStatement=connection.prepareStatement("delete from product_data where proId=?");
			preparedStatement.setString(1, proId);
			 result=preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		return result;
		
	}
    
	public Product findById(String proId) throws SQLException {
		Product product=null;
    	try(Connection connection=DBConnectionUtils.createConnection()){
    		PreparedStatement preparedStatement=connection.prepareStatement("select * from product_data where proId=?");
    		//set the data to params
    		 preparedStatement.setString(1, proId);
    		 ResultSet resultSet=preparedStatement.executeQuery();
    		 if(resultSet.next()) {
    			 product=new Product();
    			 product.setProId(resultSet.getString(1));
    			 product.setProName(resultSet.getString("proName"));
				  product.setProPrice(Double.parseDouble(resultSet.getString("proPrice")));
				  product.setProBrand(resultSet.getString("proBrand"));
				  product.setProMadeIn(resultSet.getString("proMadeIn"));
				  product.setProMfgDate(resultSet.getDate("proMfgdate"));
				  product.setProExpDate(resultSet.getDate("proExpDate"));
				  product.setReadImage(resultSet.getBytes("proImage"));
    		 }
    		
    		
    		
    		
    	}
		return product;
	}
	public int updateProduct(Product updatedProduct) {
	    int result = 0;
    try(Connection connection = DBConnectionUtils.createConnection())
    {
    	int parameterIndex = 1;
         // SQL query to update product details
    	 String sql = "UPDATE product_data SET proName=?, proPrice=?, proBrand=?, proMadeIn=?, " +
                 "proMfgDate=?, proExpDate=?" +
                 (updatedProduct.getProImage() != null ? ", proImage=?" : "") +
                 " WHERE proId=?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // Set the parameters for the update statement
        preparedStatement.setString(parameterIndex++, updatedProduct.getProName());
        preparedStatement.setDouble(parameterIndex++, updatedProduct.getProPrice());
        preparedStatement.setString(parameterIndex++, updatedProduct.getProBrand());
        preparedStatement.setString(parameterIndex++, updatedProduct.getProMadeIn());
        preparedStatement.setDate(parameterIndex++, updatedProduct.getProMfgDate());
        preparedStatement.setDate(parameterIndex++, updatedProduct.getProExpDate());
        
        if ( updatedProduct.getProImage() != null) {
            preparedStatement.setBinaryStream(parameterIndex++, updatedProduct.getProImage());
        }
        
        preparedStatement.setString(parameterIndex++, updatedProduct.getProId());

            // Execute the update
            result = preparedStatement.executeUpdate();
        }
     catch (SQLException e) {
        e.printStackTrace();
    } 
    return result;
	    }

    		    	
    }
    
    

