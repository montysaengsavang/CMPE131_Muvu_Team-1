package search;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SearchedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		 PrintWriter out = response.getWriter();
		String n=request.getParameter("query");
		out.print("Your search of " + n + " returned.");
		
		
		out.close();
	
	}
}
