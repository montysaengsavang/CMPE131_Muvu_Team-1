package login;


import movies.Film;

import java.io.IOException;
//import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;

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
	
		//we MUST request all these attributes and call these functions in order to run homepage.jsp
		String temp1 = (String) request.getAttribute("temp1");
		String temp2 = (String) request.getAttribute("temp2"); 
		
		List<Film> topMovies = new ArrayList<Film>();
		List<Film> favoritesList = new ArrayList<Film>();
		int[] favPID = new int[5];
		LoginDao.getTopMovies(topMovies);
		LoginDao.validate(temp1, temp2, favoritesList, favPID); 
		
		//MUST set these attributes before running homepage.jsp
		request.setAttribute("favoritesList", favoritesList);
		request.setAttribute("error", "");
		request.setAttribute("topMovies", topMovies);
		
		
		RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
		rd.include(request,response);
	
	}


}
