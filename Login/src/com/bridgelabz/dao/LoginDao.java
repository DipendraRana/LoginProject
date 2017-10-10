
package com.bridgelabz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Purpose: To establish the connection with our database and 
 * 			looking in to it to validate the username and password
 * 			provided to it. It's only purpose is to validate therefore it has
 * 			only one method i.e validate(String username,String password)
 * @author Dipendra Rana
 * @since 6 Oct 2017
 *
 */
public class LoginDao {

	/**
	 * This method validates the the username and password it receives.
	 * To validate we retrieve the specific row(whole data of that row) using
	 * DQL statement like SELECT and executes query using executeQuery() method which
	 * return the ResultSet object containing the data we requested. Now we want to check
	 * whether it have some data or not. So to do this we use the method next(). It return 
	 * True if there is some data in the ResultSet object else returns false.   
	 * @param username 
	 * @param password its data type is String
	 * @return returns True if found else returns False
	 */
	public static String validate(String emailId,String password) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String userName=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/form","root","root");
			statement=connection.prepareStatement("Select * from login where emailid=? and password=?");
			statement.setString(1, emailId);
			statement.setString(2, password);
			resultSet=statement.executeQuery();
			resultSet.next();
			userName=resultSet.getString(1);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("Some Error has Occurred While Connecting to Database");
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return userName;
	}

}
