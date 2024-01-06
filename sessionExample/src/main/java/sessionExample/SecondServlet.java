package sessionExample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the requested data 
				String qualification = request.getParameter("qualification");
				String designation = request.getParameter("designation");
				
				//create the session Object 
				HttpSession session = request.getSession(false);
				
				//Place the data into session object
				session.setAttribute("qualification", qualification);
				session.setAttribute("designation", designation);
				
				//forward the request to next form 
				RequestDispatcher dispatcher = request.getRequestDispatcher("Form3.html");
				dispatcher.forward(request, response);
	}

}
