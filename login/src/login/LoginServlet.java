package login;

import movies.Film;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
    public LoginServlet() {
    	super();
        
        // TODO Auto-generated constructor stub
    }



	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//request from html the users email and password
		String n=request.getParameter("useremail");
		String p=request.getParameter("userpass");
		
		//create favorites list for this specific user
		List<Film> favoritesList = new ArrayList<Film>();
		
		//create array of favorite movie ID's for user
		int[] favPID = new int[5];
		
		//check to validate login credentials, while filling up favorites list and movie ID array
		if(LoginDao.validate(n, p, favoritesList, favPID))
		{	
			//before sending off to next page, set attributes to be shared with the next servlet
			request.setAttribute("temp1", n);
			request.setAttribute("temp2", p);
			
			//dispatch to next servlet
			RequestDispatcher rd = request.getRequestDispatcher("loggedin");
			rd.include(request,response);
		}
		
		else{ //if validation returns false, print to screen and dispatch back to login page
			out.print("<br><div style=\"text-align:center; color:red; font-size:90%\">"
					+ "<b>Your e-mail address or password is incorrect. Please try again.</b>"
					+ "</div>");
			
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request,response);
		}
		
		out.close();
	}

}
