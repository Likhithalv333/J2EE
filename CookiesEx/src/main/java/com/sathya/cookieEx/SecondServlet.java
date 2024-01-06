package com.sathya.cookieEx;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the requetsd data
				String qualification = request.getParameter("qualification");
				String designation = request.getParameter("designation");
				
				//create the cookie object
				Cookie cokkie3 = new Cookie("qualification", qualification);
				Cookie cokkie4 = new Cookie("designation", designation);
				//add the data to response object
				
				response.addCookie(cokkie3);
				response.addCookie(cokkie4);
				
				//forward the data to form2
				
				
				RequestDispatcher dispatcher=request.getRequestDispatcher("Form3.html");
				dispatcher.forward(request, response);
	}

}
