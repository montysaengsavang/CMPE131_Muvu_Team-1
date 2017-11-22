package search;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movies.Film;


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n = request.getParameter("query");
	
		Film film1 = new Film();
		if(SearchDao.search(n, film1)){ //if searchDao returns true, 
			
	out.print("Movie: " + film1.title + " , where " + 
			film1.description + ", made in " + film1.year + ". Critics give it  " + film1.rating);
			
			
			//RequestDispatcher rd = request.getRequestDispatcher("homepage.html"); 
			//rd.forward(request,response); //forward to 
		}
		else{ //if searchDao returns false, print to screen and recall the homepage.
			out.print("<br><div style=\"text-align:center; color:red; font-size:90%\">"
					+ "<b>Search was unsuccessful. Please try again. </b>"
					+ "</div>");
			System.out.println("IM HERE,search returned false");
			RequestDispatcher rd=request.getRequestDispatcher("homepage.html");
			rd.include(request,response);
		}
		
		out.close();
	}


}
