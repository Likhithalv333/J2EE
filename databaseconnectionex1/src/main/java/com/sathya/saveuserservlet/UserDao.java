package com.sathya.saveuserservlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	public int saveUser(User user) {
		int result=0;
		//get the connection
		Connection connection = DBConnectionUtils.createConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into user_details values(?,?,?,?,?)");
			preparedStatement.setString(1, user.getUserId());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getUserEmail());
			preparedStatement.setString(4, user.getUserMobile());
			preparedStatement.setString(5, user.getUserLocation());
			result=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	public User findById(String userId)
	{
		User user = null; 
		try(Connection connection = DBConnectionUtils.createConnection())
		{
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user_table where userId=?");
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{	user = new User();
				user.setUserId(resultSet.getString(1));
				user.setUserName(resultSet.getString(2));
				user.setUserEmail(resultSet.getString(3));
				user.setUserMobile(resultSet.getString(4));
				user.setUserLocation(resultSet.getString(5));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
