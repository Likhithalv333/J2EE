package com.sathya.registrationApp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/saveUserServlet")
public class SaveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data
		String userId=request.getParameter("userId");
		String userName=request.getParameter("userName");
		String userEmail=request.getParameter("userEmail");
		String userMobile=request.getParameter("userMobile");
		String userLocation=request.getParameter("userLocation");
		
		
		User user=new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setUserEmail(userEmail);
		user.setUserMobile(userMobile);  
		user.setUserLocation(userLocation);
		//calling the Dao method by passing servlet data
		UserDao userDao=new UserDao();
		int result = userDao.saveUser(user);
		
		//set the data into request object to use in jsp
		request.setAttribute("saveResult", result);
		
		//forward the request to jsp files
		RequestDispatcher dispatcher =request.getRequestDispatcher("saveStatus.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
