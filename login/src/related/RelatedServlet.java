package related;

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
		
		String temp1 = request.getParameter("temp1");
		String temp2 = request.getParameter("temp2");
		
		User thisUser = new User(temp1, temp2);
		LoginDao.validate(thisUser);

		MovieDB topMovies = new MovieDB();
		LoginDao.getTopMovies(topMovies.movieList);
		
		
		List<Film> relatedFilms = new ArrayList<>();
		
		
		if(thisUser.favorites.size() == 0) //if favorites list is empty, default to suggesting related films
		{
			int size = topMovies.movieList.size();
			
			for(int i = 0; i < size; i++)
			{
				
				out.println("		<h3>" + (i+1) + "). " + topMovies.movieList.get(i).title + "</h3>");
				out.println("<img src = \"https://raw.githubusercontent.com/montysaengsavang/Muvu-Images/master/"
				+ topMovies.movieList.get(i).url + "\" alt=\"Movie Image\" height=\"390\" width=\"280\"><br><br>");
				out.println("				" + topMovies.movieList.get(i).description);
				out.println("<br>");
			}
		}
		
		
		else if(RelatedDao.getRelated(relatedFilms, thisUser.favorites.get(0).genre.split(",")[0]))
		{ //if favorites list is not empty, get related films by sending empty list to be filled and first genre in favorites list
			
			int size = relatedFilms.size();
			
			for(int i = 0; i < size; i++)
			{
				/*
				out.println("		<h3>" + (i+1) + "). " + relatedFilms.get(i).title + "</h3>");
				out.println("<img src = \"https://raw.githubusercontent.com/montysaengsavang/Muvu-Images/master/"
				+ relatedFilms.get(i).url + "\" alt=\"Movie Image\" height=\"390\" width=\"280\"><br><br>");
				out.println("				" + relatedFilms.get(i).description);
				out.println("<br>");
				*/
				
				out.println("<h3>" + (i+1) + "). " + relatedFilms.get(i).title + " (" + relatedFilms.get(i).year + ")</h3>");
				out.println("<img src = \"https://raw.githubusercontent.com/montysaengsavang/Muvu-Images/master/"
					+ relatedFilms.get(i).url + "\" alt=\"Movie Image\" height=\"390\" width=\"280\"><br>" 
					+ "<h3><p style=\"color:red;\">Rating: " + relatedFilms.get(i).rating + "/10</p></h3>"
					+ relatedFilms.get(i).genre + " - " + relatedFilms.get(i).duration + " mins <br><br>");

				out.println("Starring: " + relatedFilms.get(i).stars + "<br><br>" + relatedFilms.get(i).description + "<br><br>");
			}
			 
		}
		
		else //if relatedDao returns false, print to screen and recall the homepage.
		{ 
				
			request.setAttribute("thisUser", thisUser);
			request.setAttribute("error", "Getting related films returned unsuccessful. Please try again.");
			request.setAttribute("topMovies", topMovies);

			
			RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
			rd.include(request,response);
		}
		
		out.close();
	}


}
