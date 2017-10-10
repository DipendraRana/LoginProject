package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.dao.LoginDao;

/**
 * Purpose: Capture the input parameter from the index.jsp file and validate it against the LoginDao
 * @author Dipendra Rana
 * @since 6 Oct 2017
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * User Name and Password are valuable and should be kept secret thats why we used doPost method for it
	 * and in it we get username and password and use it to validate it by calling validate method of class LoginDao.
	 * We also look for any sessions being used by using request.getSession(false). 
	 * Note: the significance of the above sentence because it is important to understand the use of this specific 
	 * request.getSession(false) method. When we set it to false then no new session is created only the session is get
	 * if there is one present else it will just returns null. A new attribute is added to this session as name.  
	 * When the validation gets done and it gets success then we prompt the user to welcome.jsp page else Display the error message
	 * and prompt the user to index.jsp page. 
	 * Note: error message and index.jsp page is include in one LoginServlet class by using include method. 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		HttpSession session=request.getSession(false); //returns session object if exists else returns null. Note the significance of boolean value 
		String userName=LoginDao.validate(emailId, password);
		
		if(session!=null)
			session.setAttribute("name", userName);
		if(userName!=null) {
			RequestDispatcher requestDispatch=request.getRequestDispatcher("JSP/welcome.jsp");
			requestDispatch.forward(request, response);
		}
		else {
			out.print("<p style=\"clour:red\">Invalid emailId or password</p>");
			RequestDispatcher requestDispatch=request.getRequestDispatcher("JSP/index.jsp");
			requestDispatch.include(request, response);
		}
		out.close();
	}

}
