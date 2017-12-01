package related;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.LoginDao;
import movies.Film;


public class RelatedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RelatedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	
		//create search results array, fill array with empty nodes
		List<Film> relatedFilms = new ArrayList<>();
		
		if(RelatedDao.getRelated(relatedFilms))
		{ //call search function given query n and an array for storing results 
			
			int size = relatedFilms.size();
			
			for(int i = 0; i < size; i++)
			{
				
				out.println("		<h3>" + (i+1) + "). " + relatedFilms.get(i).title + "</h3>");
				out.println("<img src = \"https://raw.githubusercontent.com/montysaengsavang/Muvu-Images/master/"
				+ relatedFilms.get(i).url + "\" alt=\"Movie Image\" height=\"390\" width=\"280\"><br><br>");
				out.println("				" + relatedFilms.get(i).description);
				out.println("<br>");
			}
			 
		}
		else{ //if searchDao returns false, print to screen and recall the homepage.
			
			List<Film> topMovies = new ArrayList<>();
			LoginDao.getTopMovies(topMovies);
			
			request.setAttribute("error", "");
			request.setAttribute("topMovies", topMovies);		
			RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
			rd.forward(request,response);
		}
		
		out.close();
	}


}
