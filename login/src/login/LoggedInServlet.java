package login;

import movies.Film;

import java.io.IOException;
//import java.io.PrintWriter;

import java.io.PrintWriter;
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


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		List<Film> topMovies = new ArrayList<>();
		LoginDao.getTopMovies(topMovies);
		
		request.setAttribute("title", "SHOESHANK");
		
		RequestDispatcher rd=request.getRequestDispatcher("homepage.html");
		rd.include(request,response);
	
	}

}
