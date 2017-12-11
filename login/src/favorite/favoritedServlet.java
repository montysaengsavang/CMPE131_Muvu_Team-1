package favorite;

import database.MovieDB;
import accounts.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import login.LoginDao;



public class favoritedServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		
	
		//update user object by sending to validate function
		User thisUser = (User)request.getAttribute("thisUser");
		User updatedUser = new User(thisUser.email, thisUser.password);
		LoginDao.validate(updatedUser);
		
		//fill up top movies list
		MovieDB topMovies = new MovieDB();
		LoginDao.getTopMovies(topMovies.movieList);
		
		//set attributes before running homepage.jsp
		request.setAttribute("thisUser", updatedUser);
		request.setAttribute("error", "");
		request.setAttribute("topMovies", topMovies);
		
		RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
		rd.include(request,response);
		
		out.close();
	}

}