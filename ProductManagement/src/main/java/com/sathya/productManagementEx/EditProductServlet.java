package com.sathya.productManagementEx;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data from client
		String proId=request.getParameter("proId");
		
		//call the dao layer
		ProductDao dao=new ProductDao();
		Product existingProduct =null;
		try {
			 existingProduct= dao.findById(proId);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
			request.setAttribute("existingProduct", existingProduct);
			RequestDispatcher dispatcher=request.getRequestDispatcher("edit-form.jsp");
			dispatcher.forward(request, response);
	

	}
}
