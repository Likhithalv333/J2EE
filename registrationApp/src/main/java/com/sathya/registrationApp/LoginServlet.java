package com.sathya.registrationApp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the requested data
		String userId = request.getParameter("userId");
		String userEmail = request.getParameter("userEmail");
		
		
       //give the data to DAO layer
		UserDao dao = new UserDao();
		int result = dao.login(userId, userEmail);
		
	   //give the requested data to JSP
		request.setAttribute("result", result);
		
	  //forwarded data to JSP file
		RequestDispatcher dispatcher = request.getRequestDispatcher("logincheck.jsp");
	   dispatcher.forward(request, response);
	}

}