package com.bridgelabz.filters;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationFormVaildator
 */
public class RegistrationFormVaildator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String regularExpressionForEmailId="^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
	
	private static final String regularExpressionForUserName="^[A-Za-z ]+$";
	
	private static final String regularExpressionForMobileNumber="^[0-9]+$";
	
	protected boolean validateUserName(String userName,HttpSession session) {
		if(userName!=null) {
			if(userName.equals("")) {
				session.setAttribute("error", "Enter the User Name");
				return false;
			}
			else if(!Pattern.matches(regularExpressionForUserName, userName)) {
				session.setAttribute("error", "Invalid User Name");
				return false;
			}
			else
				return true;
		}
		else {
			session.setAttribute("error", "Enter the User Name");
			return false;
		}
		
	}
	
	protected boolean validateEmailId(String emailId, HttpSession session) {
		if(emailId!=null) {
			if(emailId.equals("")) {
				session.setAttribute("error", "Enter the email-ID");
				return false;
			}
			else if(!Pattern.matches(regularExpressionForEmailId, emailId)) {
				session.setAttribute("error", "Invalid Email-ID");
				return false;
			}
			else
				return true;
		}
		else {
			session.setAttribute("error", "Enter the email-ID");
			return false;
		}
	}
	
	protected boolean validatePassword(String password, HttpSession session) {
		if(password!=null) {
			if(password.equals("")) {
				session.setAttribute("error", "Password Cannot be Empty");
				return false;
			}
			else if(password.length()<=5){
				session.setAttribute("error", "Password must be greater than 4");
				return false;
			}
			else
				return true;
		}
		else {
			session.setAttribute("error", "Password Cannot be Empty");
			return false;
		}
		
	}
	
	protected boolean validateMobileNumber(String mobileNumber, HttpSession session) {
		if(mobileNumber!=null) {
			if(mobileNumber=="") {
				session.setAttribute("error", "Enter the Password");
				return false;
			}
			else if(!Pattern.matches(regularExpressionForMobileNumber, mobileNumber)) {
				session.setAttribute("error", "Invalid Mobile Number");
				return false;
			}
			else if(mobileNumber.length()!=10) {
				session.setAttribute("error", "Password Length must be 10");
				return false;
			}
			else
				return true;
		}
		else {
			session.setAttribute("error", "Password Cannot be Empty");
			return false;
		}
	}
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		String userName=request.getParameter("name");
		String mobileNumber=request.getParameter("mobileNumber");
		session.setAttribute("error-flag", "0");
		if(session!=null && session.getAttribute("error-flag").equals("0")) {
			if(!validateUserName(userName,session)) {
				session.setAttribute("error-flag", "1");
				response.sendRedirect("/Login/JSP/Registration");
			}
			else if(!validateEmailId(emailId,session)) {
				session.setAttribute("error-flag", "2");
				response.sendRedirect("/Login/JSP/Registration");
			}
			else if(!validatePassword(password,session)) {
				session.setAttribute("error-flag", "3");
				response.sendRedirect("/Login/JSP/Registration");
			}
			else if(!validateMobileNumber(mobileNumber,session)) {
				session.setAttribute("error-flag", "4");
				response.sendRedirect("/Login/JSP/Registration");
			}
			else {
				session.removeAttribute("error-flag");
				RequestDispatcher requestDispatch=request.getRequestDispatcher("/RegisterDao");
				requestDispatch.forward(request, response);
			}
		}
	}

}
