package login;

import database.MovieDB;

import accounts.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoggedInServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       

    public LoggedInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    //after we have been logged in, we come here
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	

		User thisUser = (User)request.getAttribute("thisUser");
		
		MovieDB topMovies = new MovieDB();
		LoginDao.getTopMovies(topMovies.movieList);
		
		//MUST set these attributes before running homepage.jsp
		request.setAttribute("thisUser", thisUser);
		request.setAttribute("error", "");
		request.setAttribute("topMovies", topMovies);
		
		
		RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
		rd.include(request,response);
	
	}


}
