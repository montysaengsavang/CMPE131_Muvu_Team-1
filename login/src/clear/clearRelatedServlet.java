package clear;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.LoginDao;
import movies.Film;


@WebServlet("/clearRelatedServlet")
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
		
		List<Film> topMovies = new ArrayList<Film>();
		List<Film> favoritesList = new ArrayList<Film>();
		int[] favPID = new int[5];
		LoginDao.getTopMovies(topMovies);
		LoginDao.validate(temp1, temp2, favoritesList, favPID);

		
		if(clearRelatedDao.clearFavorites(temp1))
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
