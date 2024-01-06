package com.sathya.cookieEx;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the requetsd data
		String username = request.getParameter("username");
		String age = request.getParameter("age");
		
		//create the cookie object
		Cookie cokkie1 = new Cookie("username", username); 
		Cookie cokkie2 = new Cookie("age", age);
		//add the data to response object
		
		response.addCookie(cokkie1);
		response.addCookie(cokkie2);
		
		//forward the data to form2
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("Form2.html");
		dispatcher.forward(request, response);
				
	}

}
