package moreInfo;


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


public class MoreInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MoreInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String thisID = request.getParameter("thisID");
		
		//create search results array, fill array with empty nodes
		
		Film movie = new Film();
		if(MoreInfoDao.getMoreInfo(thisID, movie))
		{ //call search function given query n and an array for storing results 

			//print the movies info
		
				out.println("<h3>" + movie.title + " (" + movie.year + ")</h3>");
				out.println("<img src = \"https://raw.githubusercontent.com/montysaengsavang/Muvu-Images/master/"
					+ movie.url + "\" alt=\"Movie Image\" height=\"390\" width=\"280\"><br>" 
					+ "<h3><p style=\"color:red;\">Rating: " + movie.rating + "/10</p></h3>"
					+ movie.genre + " - " + movie.duration + " mins <br><br>");

				out.println("Starring: " + movie.stars + "<br><br>" + movie.description + "<br><br>");
			
			 
		}
		else{ //if searchDao returns false, print to screen and recall the homepage.
			//must call all of these gets and sets in order to run homepage.jsp
			String temp1 = request.getParameter("temp1");
			String temp2 = request.getParameter("temp2");
			
			User thisUser = new User(temp1, temp2);
			LoginDao.validate(thisUser); 
			
			MovieDB topMovies = new MovieDB();
			LoginDao.getTopMovies(topMovies.movieList);

			request.setAttribute("error", "Could not retrieve movie info. Please try again.");
			request.setAttribute("topMovies", topMovies);
			request.setAttribute("thisUser", thisUser);
			
			RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
		rd.include(request,response);
		}
		
		out.close();
	}


}
