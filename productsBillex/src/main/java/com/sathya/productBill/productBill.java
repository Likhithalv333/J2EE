package com.sathya.productBill;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class productBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //get the client request data
	int proId =  Integer.parseInt(request.getParameter("proId"));	
	String proName = request.getParameter("proName");
	Double proPrice = Double.parseDouble(request.getParameter("proPrice"));
	int proQuantity = Integer.parseInt(request.getParameter("proQuantity"));
	//process the data
	Double TotalBill;
	 TotalBill = proPrice * proQuantity;
	double Discount = 0;
	 String DiscountMessage= "No Discount";
	 
	 if(TotalBill >1000 && TotalBill < 5000 ) {
		 Discount = TotalBill * 0.05 ; 
		DiscountMessage = " 5% Discount";
	 }
	 if(TotalBill > 5000 && TotalBill < 10000) {
		 Discount = TotalBill * 0.1;
		 DiscountMessage = "10% Discount";
	 }
	 if (TotalBill > 10000) {
		 Discount = TotalBill * 0.15;
		 DiscountMessage = "15% Discount";
	 }
	 
	 Double FinalBill;
	 FinalBill = TotalBill - Discount;
	 
	 // Render the response
	 response.setContentType("text/html");
	 PrintWriter writer = response.getWriter();
	 
	 writer.println("<html><body bgcolor = 'aqua'>");
	 writer.println("<h1>  ****Product Invoice**********</h1>");
	 writer.println("<p> Your Product Id....."+proId+ "</p>");
	 writer.println("<p> Your Product Name....."+proName+ "</p>");
	 writer.println("<p> Your Product Price....."+proPrice+ "</p>");
	 
	 writer.println("<p> Total Price of " +proQuantity + " Products:  $" +TotalBill + "</p>");
	 writer.println(DiscountMessage+ " Amount....."+Discount);
	 writer.println("<p> Net Amount to Pay: $ "+FinalBill  + "</p>");
	 writer.println("</body></html>");


	
	
	

	
	}

}
