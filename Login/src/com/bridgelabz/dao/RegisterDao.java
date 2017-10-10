package com.bridgelabz.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.model.AttributesFile;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterDao")
public class RegisterDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected AttributesFile attributesFile;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		attributesFile=new AttributesFile();
		attributesFile.setUserName(request.getParameter("name"));
		attributesFile.setEmailID(request.getParameter("emailId"));
		attributesFile.setPassword(request.getParameter("password"));
		attributesFile.setMobileNo(Long.parseLong(request.getParameter("mobileNumber")));
		databaseConnection();
		response.sendRedirect("JSP/index.jsp");
	}
	
	protected void insertElementInDatabase(PreparedStatement statement) {
		try {
			statement.setString(1, attributesFile.getUserName());
			statement.setString(2, attributesFile.getPassword());
			statement.setString(3, attributesFile.getEmailID());
			statement.setLong(4, attributesFile.getMobileNumber());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Statement Insertion Error");
		}
	}
	
	protected void databaseConnection() {
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/form","root","root");
			statement=connection.prepareStatement("Insert Into login Values(?,?,?,?)");
			insertElementInDatabase(statement);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("MySQL Driver Class Loading Error");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("May Be Connection or Statement Error");
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//System.out.println("Connection Closing Error");
				}
			}
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//System.out.println("Statement Closing Error");
				}
			}
		}
	}

}
