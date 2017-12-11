package clear;


import database.MovieDB;
import java.io.IOException;
import accounts.User;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import login.LoginDao;


public class clearRelatedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public clearRelatedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String temp1 = request.getParameter("temp1");
		String temp2 = request.getParameter("temp2");
		
		User thisUser = new User(temp1,temp2);
		LoginDao.validate(thisUser);
		
		MovieDB topMovies = new MovieDB();
		LoginDao.getTopMovies(topMovies.movieList);

		
		if(clearRelatedDao.clearFavorites(thisUser.email))
		{
	    	//set attributes before changing servlets
			
			//update the user object after clearing the favorites list
			User updatedUser = new User(thisUser.email, thisUser.password);
			LoginDao.validate(updatedUser);
			
			request.setAttribute("thisUser", updatedUser);
			request.setAttribute("error", "");
			request.setAttribute("topMovies", topMovies);
			
			RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
			rd.include(request,response);

		}
		
		else //if unable to clear list
		{		
			request.setAttribute("error", "Unable to clear list. Please try again.");
			request.setAttribute("topMovies", topMovies);
			request.setAttribute("thisUser", thisUser);

			RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
			rd.include(request,response);	
		}
		out.close();
    
    }

}
