package favorite;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.LoginDao;
import movies.Film;


public class favoriteServlet extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//request parameters from homepage, including the id of the movie where the button was clicked
		String temp1 = request.getParameter("temp1");
		String temp2 = request.getParameter("temp2");
		String favID = request.getParameter("favID");
		//convert string to int
		int favoriteID = Integer.parseInt(favID);
		
		//call these functions before calling homepage.jsp again
		List<Film> topMovies = new ArrayList<Film>();
		List<Film> favoritesList = new ArrayList<Film>();
		int[] favPID = new int[5];
		LoginDao.getTopMovies(topMovies);
		LoginDao.validate(temp1, temp2, favoritesList, favPID);
		
		//send user email, since it is a primary key, to find the user and add to the users column the id of requested movie
	    if(favoriteDao.addToFavorites(temp1, favoriteID, favPID))
		{
	    	//set attributes before changing servlets
			request.setAttribute("favoritesList", favoritesList);
			request.setAttribute("error", "");
			request.setAttribute("topMovies", topMovies);
			
			request.setAttribute("temp1", temp1);
			request.setAttribute("temp2", temp2);
			
			RequestDispatcher rd=request.getRequestDispatcher("favorited");
			rd.include(request,response);

		}
		
		else //if unable to add to the list, its because it is full, if full, print accordingly
		{		
			
			request.setAttribute("favoritesList", favoritesList);
			request.setAttribute("error", "Favorites list is full.");
			request.setAttribute("topMovies", topMovies);
			
			request.setAttribute("temp1", temp1);
			request.setAttribute("temp2", temp2);
			
			RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
			rd.include(request,response);	
		}

		
		out.close();
	}

}