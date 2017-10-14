package com.bridgelabz.filters;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class IndexFilter
 */
public class IndexFilter implements Filter {

	private final String regularExpressionForUserName="^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
	
	protected boolean validateEmailId(String emailId, HttpSession session) {
		if(!Pattern.matches(regularExpressionForUserName, emailId)) {
			session.setAttribute("error", "Invalid Email-ID");
			return false;
		}
		else if(emailId.equals("")||emailId.equals(null)) {
			session.setAttribute("error", "This Field is necessary");
			return false;
		}
		else
			return true;
	}
	
	protected boolean validatePassword(String password, HttpSession session) {
		if(password.length()<=5){
			session.setAttribute("error", "Password must be greater than 4");
			return false;
		}
		else if(password.equals("")) {
			session.setAttribute("error", "Password Cannot be Empty");
			return false;
		}
		else
			return true;
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpServletResponse httpResponse=(HttpServletResponse) response;
		HttpSession session=httpRequest.getSession();
		String emailId=httpRequest.getParameter("emailId");
		String password=httpRequest.getParameter("password");
		System.out.println("Filter");
		if(session!=null && session.getAttribute("error-flag").equals("0")) {
			if(!validateEmailId(emailId,session)) {
				session.setAttribute("error-flag", "1");
				httpResponse.sendRedirect("/Login/JSP/index");
			}
			else if(!validatePassword(password,session)) {
				session.setAttribute("error-flag", "2");
				httpResponse.sendRedirect("/Login/JSP/index");
			}	
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
}
