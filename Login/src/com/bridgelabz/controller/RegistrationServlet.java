package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.dao.RegistrationDao;
import com.bridgelabz.filters.RegistrationFormValidate;
import com.bridgelabz.model.AttributesFile;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected AttributesFile attributesFile;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();
		
		String userName=request.getParameter("name");
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		long mobileNumber=Long.parseLong(request.getParameter("mobileNumber"));
		
		session.setAttribute("error-flag", "0");
		if(session!=null && session.getAttribute("error-flag").equals("0")) {
			if(!RegistrationFormValidate.validateUserName(userName,session)) {
				session.setAttribute("error-flag", "1");
				response.sendRedirect("/Login/JSP/Registration");
			}
			else if(!RegistrationFormValidate.validateEmailId(emailId,session)) {
				session.setAttribute("error-flag", "2");
				response.sendRedirect("/Login/JSP/Registration");
			}
			else if(!RegistrationFormValidate.validatePassword(password,session)) {
				session.setAttribute("error-flag", "3");
				response.sendRedirect("/Login/JSP/Registration");
			}
			else if(!RegistrationFormValidate.validateMobileNumber(mobileNumber,session)) {
				session.setAttribute("error-flag", "4");
				response.sendRedirect("/Login/JSP/Registration");
			}
			else {
				session.removeAttribute("error-flag");
				try {
					RegistrationDao.register(userName, emailId, password, mobileNumber);
					response.sendRedirect("/Login/JSP/index");
				}catch(Exception e) {
					printWriter.print("Registration Failed");
					RequestDispatcher requestDispatch=request.getRequestDispatcher("JSP/Registration");
					requestDispatch.include(request, response);
				}
			}
		}
	}
}
