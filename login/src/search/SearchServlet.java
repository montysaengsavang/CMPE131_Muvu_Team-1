package search;
import java.util.*;
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
	
		//create search results array, fill array with empty nodes
		List<Film> searchResults = new ArrayList<>();
		
		if(SearchDao.search(n, searchResults))
		{ //call search function given query n and an array for storing results 
			
			int size = searchResults.size();
			
			for(int i = 0; i < size; i++)
			{
				
				out.println("<h3>" + (i+1) + "). " + searchResults.get(i).title + "</h3>");
				out.println("		" + searchResults.get(i).description);
				out.println("<br>");
			}
			 
		}
		else{ //if searchDao returns false, print to screen and recall the homepage.
			out.print("<br><div style=\"text-align:center; color:red; font-size:90%\">"
					+ "<b>Search was unsuccessful. Please try again. </b>"
					+ "</div>");
			
			RequestDispatcher rd=request.getRequestDispatcher("homepage.html");
			rd.include(request,response);
		}
		
		out.close();
	}


}
