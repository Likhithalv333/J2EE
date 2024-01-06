package com.sathya.firstsevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		
		PrintWriter write = response.getWriter();
		write.println("this is first servlet..");
		write.println("adv java class by Mr.Ratan sir...");
		write.println("servlets application very good...");
		write.println("ganesh having dummy laptop...");
	}

	
	

}
