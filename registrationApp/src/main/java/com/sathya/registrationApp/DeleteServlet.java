package com.sathya.registrationApp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the request from client
		String userId=request.getParameter("userId");
		
		
		//give the request to dao layer
		UserDao dao=new UserDao();
		int result=dao.deleteById(userId);
		//send the request to jsp layer
		
		request.setAttribute("deletedresult", result);
		
		//forward the request to jsp file
		RequestDispatcher dispatcher=request.getRequestDispatcher("deletedrecord.jsp");
		dispatcher.forward(request, response);
		
	}

	

}
