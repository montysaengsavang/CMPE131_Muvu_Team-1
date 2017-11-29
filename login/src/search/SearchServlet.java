package search;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.LoginDao;
import movies.Film;


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n = request.getParameter("query");
	
		//create search results array, fill array with empty nodes
		List<Film> searchResults = new ArrayList<>();
		
		if(SearchDao.search(n, searchResults))
		{ //call search function given query n and an array for storing results 
			
			int size = searchResults.size();
			
			for(int i = 0; i < size; i++)
			{
				
				out.println("		<h3>" + (i+1) + "). " + searchResults.get(i).title + "</h3>");
				out.println("<img src = \"https://raw.githubusercontent.com/montysaengsavang/Muvu-Images/master/"
				+ searchResults.get(i).url + "\" alt=\"Movie Image\" height=\"390\" width=\"280\"><br><br>");
				out.println("				" + searchResults.get(i).description);
				out.println("<br>");
			}
			 
		}
		else{ //if searchDao returns false, print to screen and recall the homepage.
			
			List<Film> topMovies = new ArrayList<>();
			LoginDao.getTopMovies(topMovies);
			
			out.println("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Muvu Login</title>"
					+"<style>@import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);"
					+"@import url(http://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300);"
					+"@import url('https://fonts.googleapis.com/css?family=Quicksand');@import url(https://fonts.googleapis.com/css?family=Open+Sans);"
					+"@import url(http://www.material-ui.com/styles/colors.js)body{background: #f2f2f2;  font-family: 'Open Sans', sans-serif;}"
					+".title {    font-family: Quicksand; text-align: center;position: relative;color: whitesmoke;font-weight: bold;font-size: 100px;}"
					+".subtitle {font-family: Quicksand;text-align: center;position: relative;color: whitesmoke;"
					+"font-weight: bold; font-size: 20px;margin-top: -20px; padding-bottom: 15px;}"
					+".parallax { /* The image used */ background-image: url(\"https://raw.githubusercontent.com/montysaengsavang/Muvu-Images/master/camera.jpg\");"
					+" /* Set a specific height */ min-height: 900px;/* Create the parallax scrolling effect */ background-attachment: fixed;"
					+"background-position: center;background-repeat: no-repeat;background-size: cover;}.par2 {background-color: #f2f2f2;"
					+"background-position: center;background-repeat: no-repeat;background-size: cover;height: 1000px;filter: alpha(opacity=50);}"
					+".par2_text {font-family: Quicksand;text-align: center;  position: relative; color: black;font-weight: bold;font-size: 30px;"
					+"padding-top: 200px;}.search {width: 100%;position: relative}.searchTerm { float: left;width: 100%;border: 3px solid #00B4CC;padding: 5px;"
					+"height: 20px;border-radius: 5px;outline: none;color: #9DBFAF;}.searchTerm:focus{color: #00B4CC;}.searchButton {position: absolute;"
					+" right: -50px;width: 40px;height: 36px;border: 1px solid #00B4CC;background: #00B4CC;text-align: center;color: #fff; border-radius: 5px;"
					+"cursor: pointer;font-size: 20px;}/*Resize the wrap to see the search bar change!*/.wrap{width: 30%;position: absolute;top: 50%;"
					+" left: 50%;transform: translate(-50%, -50%);}</style> </head> <body><div class=\"wrap\"><div class=\"title\">muvu</div> <div class=\"subtitle\">movies that move you</div>"
					+"<div style=\"text-align:center; color:red; font-size:95%\"><b>Search was unsuccessful. Please try again.</b></div><br>"
					+"<div class=\"search\"><form action=\"search\" method=\"post\"><input type=\"text\" name=\"query\" class=\"searchTerm\" placeholder=\"Search for a film...\">"
					+"<button type=\"submit\" class=\"searchButton\"><i class=\"fa fa-search\"></i></button></form></div></div>"
					+"<div class=\"parallax\"></div><div class=\"par2\"><div class=\"par2_text\"><h2>Top 20 Rated Movies<h2><br><br>");
					
			int size = topMovies.size();
			for(int i = 0; i < size; i++)
			{
				out.println("<h3>" + (i+1) + "). " + topMovies.get(i).title + "</h3>");
				out.println("<img src = \"https://raw.githubusercontent.com/montysaengsavang/Muvu-Images/master/"
				+ topMovies.get(i).url + "\" alt=\"Movie Image\" height=\"390\" width=\"280\"><br><br>");
				out.println(topMovies.get(i).description + " <div style=\" color:red; \">" + topMovies.get(i).rating + "</div>");
				out.println("<br>");
			}
					
			out.println("</div>"
				+"</div></body></html>");
						
						
			//RequestDispatcher rd=request.getRequestDispatcher("homepage.html");
			//rd.include(request,response);
		}
		
		out.close();
	}


}
