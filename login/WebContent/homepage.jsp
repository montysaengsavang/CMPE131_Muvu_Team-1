<%@ page import="java.util.List, java.util.ArrayList, movies.Film" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>


<!DOCTYPE html>
<html>
<head>

<title>Muvu Login</title>

<style>
@import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);
@import url(http://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300);
@import url('https://fonts.googleapis.com/css?family=Quicksand');
@import url(https://fonts.googleapis.com/css?family=Open+Sans);
@import url(http://www.material-ui.com/styles/colors.js)

body{
  background: #f2f2f2;
  font-family: 'Open Sans', sans-serif;
}
  
.title {
    font-family: Quicksand;
    text-align: center;
    position: relative;
    color: whitesmoke;
    font-weight: bold;
    font-size: 100px;
    
    } 
    
.subtitle {
    font-family: Quicksand;
    text-align: center;
    position: relative;
    color: whitesmoke;
    font-weight: bold;
    font-size: 20px;
    margin-top: -20px;
    padding-bottom: 15px;
    }
    
.parallax {
    /* The image used */
    background-image: url("https://raw.githubusercontent.com/montysaengsavang/Muvu-Images/master/camera.jpg");

    /* Set a specific height */
    min-height: 900px; 

    /* Create the parallax scrolling effect */
    background-attachment: fixed;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}
.par2 {
    background-color: #f2f2f2;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
    height: 1000px;
    /*background-image: url("computer.jpg");*/
    filter: alpha(opacity=50);
}
.par2_text {
    font-family: Quicksand;
    text-align: center;
    position: relative;
    color: black;
    font-weight: bold;
    font-size: 30px;
    padding-top: 200px;
    }

    
.search {
  width: 100%;
  position: relative
}

.searchTerm {
  float: left;
  width: 100%;
  border: 3px solid #00B4CC;
  padding: 5px;
  height: 20px;
  border-radius: 5px;
  outline: none;
  color: #9DBFAF;
}

.searchTerm:focus{
  color: #00B4CC;
}

.searchButton {
  position: absolute;  
  right: -50px;
  width: 40px;
  height: 36px;
  border: 1px solid #00B4CC;
  background: #00B4CC;
  text-align: center;
  color: #fff;
  border-radius: 5px;
  cursor: pointer;
  font-size: 20px;
}

/*Resize the wrap to see the search bar change!*/
.wrap{
  width: 30%;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
    </style>
    </head>
    
<body>    
<div class="wrap">
    <div class="title">muvu</div>
    <div class="subtitle">movies that move you</div>
   <div style="text-align:center; color:red; font-size:95%">
   <b>
	<% String error = (String)request.getAttribute("error");
		out.println(error);
	%>
	</b></div>
      <br>
   <div class="search">
   
   	<form action="search" method="post">
   	  <input type="text" name="query" class="searchTerm" placeholder="Search for a film...">
   	  <% 
   		String temp1 = (String) request.getAttribute("temp1");
   		String temp2 = (String) request.getAttribute("temp2");
   		List<Film> topMovies = (List<Film>) request.getAttribute("topMovies");
   		List<Film> favoritesList = (List<Film>) request.getAttribute("favoritesList");
   		
   		out.println("<input type=\"hidden\" name=\"temp1\" value=\"" + temp1 + "\" />"
			+ "<input type=\"hidden\" name=\"temp2\" value=\"" + temp2 + "\" />");
 	  	%>
   	  <button type="submit" class="searchButton">
        <i class="fa fa-search"></i>
     </button>
   	</form>
  
   </div>
</div>
    <div class="parallax"></div>
    <div class="par2">
    <div class="par2_text">
    
    <form action="related" method="post">
    	<% 
   		out.println("<input type=\"hidden\" name=\"temp1\" value=\"" + temp1 + "\" />"
			+ "<input type=\"hidden\" name=\"temp2\" value=\"" + temp2 + "\" />");
 	  	%>
 	  	<input type="Submit" value="Get Related Films">
 	  	
    </form>
<% 
if(favoritesList.size() != 0)
	out.println("<h2>Your Favorites List</h2>");

for(int i = 0; i < favoritesList.size(); i++)
{
	out.println("<h3>" + favoritesList.get(i).title + " (" + favoritesList.get(i).year + ")</h3>");
	out.println("<img src = \"https://raw.githubusercontent.com/montysaengsavang/Muvu-Images/master/"
	+ favoritesList.get(i).url + "\" alt=\"Movie Image\" height=\"390\" width=\"280\"><br><br>");
	
	out.println("<br>");
}
%>


<form action="clear" method="post">
<% 
		out.println("<input type=\"hidden\" name=\"temp1\" value=\"" + temp1 + "\" />"
		+ "<input type=\"hidden\" name=\"temp2\" value=\"" + temp2 + "\" />");
	%>
	  	<input type="Submit" value="Clear Favorites List">
</form>

<%
out.println("<h2>Top Rated Movies</h2>");
for(int i = 0; i < topMovies.size(); i++)
{
	out.println("<h3>" + (i+1) + "). " + topMovies.get(i).title + " (" + topMovies.get(i).year + ")</h3>");
	out.println("<img src = \"https://raw.githubusercontent.com/montysaengsavang/Muvu-Images/master/"
		+ topMovies.get(i).url + "\" alt=\"Movie Image\" height=\"390\" width=\"280\"><br><br>");

	
	out.println(" <form action=\"favorite\" method=\"post\"> "
			+ "<input type=\"hidden\" name=\"temp1\" value=\"" + temp1 + "\" />"
			+ "<input type=\"hidden\" name=\"temp2\" value=\"" + temp2 + "\" />"
			+ "<input type=\"hidden\" name=\"favID\" value=" + topMovies.get(i).id +  " />"
		 	+ "<input type=\"Submit\" value=\"Add To Favorites\">"
		 	+ "</form><br>");
	
	
	out.println("Starring: " + topMovies.get(i).stars + "<br><br>" + topMovies.get(i).description + "<br> (" 
		+ topMovies.get(i).duration + " mins)<br>" + topMovies.get(i).genre + "<div style=\" color:red; \">" 
		+ topMovies.get(i).rating + "</div> ");
}
%>
    </div>
    
    </div>
    </body>
</html>