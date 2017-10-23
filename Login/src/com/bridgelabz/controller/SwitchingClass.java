package com.bridgelabz.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Purpose: Receives the actions from index.jsp and accordingly calls the appropriate servlet
 * @author Dipendra Rana
 * @since 9 Oct 2017
 */
public class SwitchingClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		session.setAttribute("error-flag", "0");
		if(request.getParameter("action").equals("Register")) { 
			response.sendRedirect("/Login/JSP/Registration");
		}	
		else {
			RequestDispatcher requestDispatch=request.getRequestDispatcher("/LoginServlet");
			requestDispatch.forward(request, response);
		}	
	}

}
