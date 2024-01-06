package com.sathya.generatingnumberlist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class generatatingNumberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        // Step 1: Get parameters from the request
        int startNumber = Integer.parseInt(request.getParameter("startNumber"));
        int endNumber = Integer.parseInt(request.getParameter("endNumber"));
        String category = request.getParameter("category");
        RequestDispatcher dispatcher = request.getRequestDispatcher("generatingnumberlist.html");
        dispatcher.include(request, response);
        writer.println("your "+category+" "+"result...");
        

      		

        // Step 2: Process the data based on the selected category
        processRequest(writer, startNumber, endNumber, category);

        // No need for Step 3, as the response is written directly to the PrintWriter

    }

    private void processRequest(PrintWriter writer, int start, int end, String category) {
        switch (category.toLowerCase()) {
            case "even":
                getEvenNumbers(writer, start, end);
                break;
            case "odd":
                getOddNumbers(writer, start, end);
                break;
            case "prime":
            	getPrimeNumbers(writer,start,end);
            	break;
            case "perfect":
            	getPerfectNumbers(writer,start,end);
            	break;
            case "amstrong":
            	getAmstrongNumbers(writer,start,end);
            	break;
           
            default:
                writer.println("Invalid category selected");
        }
      
	
    }

    private void getPerfectNumbers(PrintWriter writer, int start, int end) {
    	
		for(int i=start;i<=end;i++) {
			int sum=0;
		
			 for (int j = 1; j <= i / 2; j++) {
		            if (i % j == 0) {
		                sum = sum + j;
		            }
		        }
		        if (i == sum) {
		            writer.println(i + " ");
		        }
		}
		
	}

	private void getPrimeNumbers(PrintWriter writer, int start, int end) {
    	
		// TODO Auto-generated method stub
		for(int i=start;i<=end;i++) {
			int c=0;
			for(int j=2;j<i;j++) {
				if(i%j==0) {
					c++;
					break;
				}
			}
			if(c==0) {
				writer.println(i+" ");
			}
		}
	}

	private void getEvenNumbers(PrintWriter writer, int start, int end) {
        for (int i = start; i <= end; i ++) {
        	if(i%2==0) {
        		writer.print(i + " ");
        		}
            
        }
       

    }

    private void getOddNumbers(PrintWriter writer, int start, int end) {
        for (int i = start ; i <= end; i ++) {
        	if(i%2!=0) {
        		writer.print(i + " ");}
            
        }
    }
    private void getAmstrongNumbers(PrintWriter writer, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isArmstrong(i)) {
                writer.println(i + " ");
            }
        }
    }

    // Helper method to check if a number is Armstrong
    private boolean isArmstrong(int num) {
        int originalNum = num;
        int sum = 0;
        int numberOfDigits = String.valueOf(num).length();

        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, numberOfDigits);
            num /= 10;
        }

        return sum == originalNum;
    }

   

    }