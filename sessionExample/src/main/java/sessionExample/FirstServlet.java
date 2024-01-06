package sessionExample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the requested data 
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		//create the session Object 
		HttpSession session = request.getSession();
		
		//Place the data into session objecy 
		session.setAttribute("username", username);
		session.setAttribute("age", age);
		
		//forward the request to next form 
		RequestDispatcher dispatcher = request.getRequestDispatcher("Form2.html");
		dispatcher.forward(request, response);
	}
}

