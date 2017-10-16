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
 * Servlet implementation class ValidationServlet
 */
public class LoginValidationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String regularExpressionForEmailId="^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
	
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
		if(session!=null && session.getAttribute("error-flag").equals("0")) {
			if(!validateEmailId(emailId,session)) {
				session.setAttribute("error-flag", "1");
				response.sendRedirect("/Login/JSP/index");
			}
			else if(!validatePassword(password,session)) {
				session.setAttribute("error-flag", "2");
				response.sendRedirect("/Login/JSP/index");
			}
			else {
				session.removeAttribute("error-flag");
				RequestDispatcher requestDispatch=request.getRequestDispatcher("/LoginServlet");
				requestDispatch.forward(request, response);
			}
		}
	}

}
