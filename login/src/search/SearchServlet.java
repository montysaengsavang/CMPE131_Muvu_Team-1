package search;


import database.MovieDB;
import java.util.*;
import accounts.User;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.LoginDao;
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
			//print all movies in the searchResult list
			for(int i = 0; i < size; i++)
			{
		
				out.println("<h3>" + (i+1) + "). " + searchResults.get(i).title + " (" + searchResults.get(i).year + ")</h3>");
				out.println("<img src = \"https://raw.githubusercontent.com/montysaengsavang/Muvu-Images/master/"
					+ searchResults.get(i).url + "\" alt=\"Movie Image\" height=\"390\" width=\"280\"><br>" 
					+ "<h3><p style=\"color:red;\">Rating: " + searchResults.get(i).rating + "/10</p></h3>"
					+ searchResults.get(i).genre + " - " + searchResults.get(i).duration + " mins <br><br>");

				out.println("Starring: " + searchResults.get(i).stars + "<br><br>" + searchResults.get(i).description + "<br><br>");
			}
			 
		}
		else{ //if searchDao returns false, print to screen and recall the homepage.
			//must call all of these gets and sets in order to run homepage.jsp
			String temp1 = request.getParameter("temp1");
			String temp2 = request.getParameter("temp2");
			
			User thisUser = new User(temp1, temp2);
			LoginDao.validate(thisUser); 
			
			MovieDB topMovies = new MovieDB();
			LoginDao.getTopMovies(topMovies.movieList);

			request.setAttribute("error", "Search was unsuccessful. Please try again.");
			request.setAttribute("topMovies", topMovies);
			request.setAttribute("thisUser", thisUser);
			
			RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
		rd.include(request,response);
		}
		
		out.close();
	}


}
