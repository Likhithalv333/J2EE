package com.sathya.loginex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the client request data
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//process the data
		
		if(username.equalsIgnoreCase("ratan") && password.equals("Ratan@123")) {
			response.sendRedirect("http://www.sathyatech.com");
			//RequestDispatcher dispatcher=request.getRequestDispatcher("success.html");
			//dispatcher.forward(request, response);
			
		}
		else {
			response.sendError(909,"login fail try with nother data..");
			//response.setContentType("text/html");
			//PrintWriter writer=response.getWriter();
			//writer.println("Login fail..try with valid data");
			//RequestDispatcher dispatcher=request.getRequestDispatcher("loginServlet.html");
			//dispatcher.include(request, response);
		}

	
	}
}
