<%@ page import="java.util.List, java.util.ArrayList, movies.Film, accounts.User, database.MovieDB" language="java" contentType="text/html; charset=ISO-8859-1"
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
    height: 100%;
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
  height: 40px;
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
/*_______________________________________________________________________________*/

  html {
  background-color: #f2f2f2;
  box-sizing: border-box;
  font-family: 'Roboto', sans-serif;
  font-size: 14px;
  font-weight: 400;
}

*, *:before, *:after {
  box-sizing: inherit;
}

.u-float-right {
  float: right;
}

.u-clearfix:before,
.u-clearfix:after {
  content: " ";
  display: table;
}

.u-clearfix:after {
  clear: both;
}

.u-clearfix {
  *zoom: 1;
}

.u-flex-center {
  display: -webkit-flex;
  display: flex;
  -webkit-justify-content: center;
  justify-content: center;
  -webkit-align-items: center;
  align-items: center;
}

.container {
  margin: 50px auto;
  width: 560px;
}

.card {
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 3px rgba(0, 0, 0, .1);
  margin-bottom: 65px;
  width: 100%;
}

.card-media {
  float: left;
  padding: 0 0 25px 25px;
  position: relative;
  width: 145px;
}

.card-media-img {
  box-shadow: 0 4px 6px rgba(0, 0, 0, .3);
  float: left;
  margin-top: -25px;
  position: relative;
  width: 105%;
}

.card-media-preview {
  background-color: #00AEA2;
  border-radius: 50%;
  bottom: 11px;
  box-shadow: 0 0 4px rgba(0,0,0,.14), 0 4px 8px rgba(0,0,0,.28);
  cursor: pointer;
  height: 30px;
  opacity: 0;
  position: absolute;
  left: 70px;
  transform: translateY(5px);
  transition: all 300ms ease-out;
  width: 30px;
  z-index: 3;
}

.card-media-preview:hover {
  background-color: #009d92;
  box-shadow: 0 0 6px rgba(0,0,0,.16), 0 6px 12px rgba(0,0,0,.32);
}

.card:hover .card-media-preview {
  opacity: 1;
  transform: translateY(0);
}

.card-media-tag {
  border-radius: 2px;
  box-shadow: 3px 3px 10px rgba(0, 0, 0, .22);
  display: inline-block;
  font-size: 10px;
  font-weight: 500;
  letter-spacing: .4px;
  padding: 5px 8px;
  position: absolute;
  left: 110px;
  text-transform: uppercase;
  top: -10px;
}

.card-media-tag-orange {
  background-color: #FF982C;
  color: #FFE111;
}

.card-media-tag-brown {
  background-color: #855345;
  color: #E8CA69;
}

.card-body {
  float: left;
  padding: 25px 25px 25px 20px;
  width: 415px;
}

.card-body-heading {
  color: #6f6f6f;
  display: inline-block;
  font-size: 26px;
  width: 80%;
  margin-top: -15px;
}

.card-body-options {
  float: right;
}

.card-body-option {
  cursor: pointer;
  display: inline-block;
  position: relative;
  margin-left: 5px;
}

.card-body-stars {
  list-style-type: none;
  margin: 0px 0;
  padding: 0;
}

.card-body-stars > li {
  cursor: pointer;
  display: inline-block;
  float: left;
}

.card-button {
  color: #9C948A;
  display: inline-block;
  font-weight: 500;
  padding: 12px 20px;
  text-decoration: none;
  text-transform: uppercase;
  transition: all 200ms ease-out;
}

.card-button svg {
  fill: #9C948A;
  transition: all 200ms ease-out;
}

.card-button-cta {
  background-color: #9C948A;
  border-radius: 2px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, .15);
  color: #fff;
}

.card-button-cta:hover {
  box-shadow: 1px 5px 8px rgba(0, 0, 0, .18);
  background-color: #F44336;
}

.card-button-link:hover {
  color: #444;
}

.card-button-link:hover svg {
  fill: #444;
}

.card-button-icon {
  display:inline-block;
  vertical-align:middle;
}

.floating-action-button {
  background-color: #FF4133;
  border-radius: 50%;
  bottom: 25px;
  box-shadow: 0 0 4px rgba(0,0,0,.14), 0 4px 8px rgba(0,0,0,.28);
  cursor: pointer;
  height: 56px;
  position: absolute;
  right: 25px;
  transition: all 200ms ease-out;
  width: 56px;
}

.floating-action-button:hover {
  background-color: #ff2111;
  box-shadow: 0 0 6px rgba(0,0,0,.16), 0 6px 12px rgba(0,0,0,.32);
}

/*____________________________________________________________________*/


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
 
   			User thisUser = (User)request.getAttribute("thisUser");
			MovieDB topMovies = (MovieDB)request.getAttribute("topMovies");
			
		
   		out.println("<input type=\"hidden\" name=\"temp1\" value=\"" + thisUser.email + "\" />"
			+ "<input type=\"hidden\" name=\"temp2\" value=\"" + thisUser.password + "\" />");
 	  	%>
 	  	
 	
 	  	
   	  <button type="submit" class="searchButton">
        <i class="fa fa-search"></i>
     </button>
   	</form>
  
   </div>
</div>
    <div class="parallax"></div>
    <div class="par2">
    
  
  <!-- __________________________________________________________________________________________________ -->
    
    <form action="related" method="post">
    	<% 
   		out.println("<input type=\"hidden\" name=\"temp1\" value=\"" + thisUser.email + "\" />"
			+ "<input type=\"hidden\" name=\"temp2\" value=\"" + thisUser.password + "\" />");
 	  	%>
 	  	<input type="Submit" value="Get Related Films">
 	  	
    </form>
    
    
          
          
<form action="clear" method="post">
<% 
		out.println("<input type=\"hidden\" name=\"temp1\" value=\"" + thisUser.email + "\" />"
		+ "<input type=\"hidden\" name=\"temp2\" value=\"" + thisUser.password + "\" />");
%>
	  	<input type="Submit" value="Clear Favorites List">
</form>


<%
for(int i = 0; i < topMovies.movieList.size() ; i++)
{
%>
<div class="container">
  <div class="card u-clearfix">
    <div class="card-media">
          
		<% 
		out.println("<img src = \"https://raw.githubusercontent.com/montysaengsavang/Muvu-Images/master/"
					+ topMovies.movieList.get(i).url + "\" alt=\"Movie Image\" class=\"card-media-img\" />");		                 
		%>
  
      <div class="card-media-preview u-flex-center">
        <svg fill="#ffffff" height="18" viewBox="0 0 24 24" width="18" xmlns="http://www.w3.org/2000/svg">
          <path d="M8 5v14l11-7z"/>
          <path d="M0 0h24v24H0z" fill="none"/>
        </svg>
      </div>
      <span class="card-media-tag card-media-tag-orange">Action</span>
    </div>

    <div class="card-body">
    
 	<% 
      out.println("<h2 class=\"card-body-heading\">" + topMovies.movieList.get(i).title + "</h2>");
    %>
      
      <div class="card-body-options">
        <div class="card-body-option card-body-option-favorite">
           <svg fill="#9C948A" height="26" viewBox="0 0 24 24" width="26" xmlns="http://www.w3.org/2000/svg">
             <path d="M0 0h24v24H0z" fill="none"/>
             <path d="M16.5 3c-1.74 0-3.41.81-4.5 2.09C10.91 3.81 9.24 3 7.5 3 4.42 3 2 5.42 2 8.5c0 3.78 3.4 6.86 8.55 11.54L12 21.35l1.45-1.32C18.6 15.36 22 12.28 22 8.5 22 5.42 19.58 3 16.5 3zm-4.4 15.55l-.1.1-.1-.1C7.14 14.24 4 11.39 4 8.5 4 6.5 5.5 5 7.5 5c1.54 0 3.04.99 3.57 2.36h1.87C13.46 5.99 14.96 5 16.5 5c2 0 3.5 1.5 3.5 3.5 0 2.89-3.14 5.74-7.9 10.05z"/>
          </svg>
        </div>
        
        
        <div class="card-body-option card-body-option-share">
          <svg fill="#9C948A" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg">
            <path d="M0 0h24v24H0z" fill="none"/>
            <path d="M18 16.08c-.76 0-1.44.3-1.96.77L8.91 12.7c.05-.23.09-.46.09-.7s-.04-.47-.09-.7l7.05-4.11c.54.5 1.25.81 2.04.81 1.66 0 3-1.34 3-3s-1.34-3-3-3-3 1.34-3 3c0 .24.04.47.09.7L8.04 9.81C7.5 9.31 6.79 9 6 9c-1.66 0-3 1.34-3 3s1.34 3 3 3c.79 0 1.5-.31 2.04-.81l7.12 4.16c-.05.21-.08.43-.08.65 0 1.61 1.31 2.92 2.92 2.92 1.61 0 2.92-1.31 2.92-2.92s-1.31-2.92-2.92-2.92z"/>
          </svg>
        </div>
      </div>
      
      
      <ul class="card-body-stars u-clearfix">
        <li>
          <svg fill="#D3BCA2" height="28" viewBox="0 0 18 18" width="28" xmlns="http://www.w3.org/2000/svg">
            <path d="M9 11.3l3.71 2.7-1.42-4.36L15 7h-4.55L9 2.5 7.55 7H3l3.71 2.64L5.29 14z"/>
            <path d="M0 0h18v18H0z" fill="none"/>
          </svg>
        </li>
        
        
        <li>
          <svg fill="#D3BCA2" height="28" viewBox="0 0 18 18" width="28" xmlns="http://www.w3.org/2000/svg">
            <path d="M9 11.3l3.71 2.7-1.42-4.36L15 7h-4.55L9 2.5 7.55 7H3l3.71 2.64L5.29 14z"/>
            <path d="M0 0h18v18H0z" fill="none"/>
          </svg>
        </li>
        
        
        <li>
          <svg fill="#D3BCA2" height="28" viewBox="0 0 18 18" width="28" xmlns="http://www.w3.org/2000/svg">
            <path d="M9 11.3l3.71 2.7-1.42-4.36L15 7h-4.55L9 2.5 7.55 7H3l3.71 2.64L5.29 14z"/>
            <path d="M0 0h18v18H0z" fill="none"/>
          </svg>
        </li>
        
        
        <li>
          <svg fill="#D3BCA2" height="28" viewBox="0 0 18 18" width="28" xmlns="http://www.w3.org/2000/svg">
            <path d="M9 11.3l3.71 2.7-1.42-4.36L15 7h-4.55L9 2.5 7.55 7H3l3.71 2.64L5.29 14z"/>
            <path d="M0 0h18v18H0z" fill="none"/>
          </svg>
        </li>
        
        
        <li>
          <svg fill="#D3BCA2" height="28" viewBox="0 0 18 18" width="28" xmlns="http://www.w3.org/2000/svg">
            <path d="M9 11.3l3.71 2.7-1.42-4.36L15 7h-4.55L9 2.5 7.55 7H3l3.71 2.64L5.29 14z"/>
            <path d="M0 0h18v18H0z" fill="none"/>
          </svg>
        </li>
        
        
      </ul>
      <a href="#/" class="card-button card-button-cta">
        Add to Favorites
      </a>
      <a href="#/" class="card-button card-button-link">
        More info
        <span class="card-button-icon">
          <svg fill="#9C948A" height="16" viewBox="0 0 24 24" width="16" xmlns="http://www.w3.org/2000/svg">
            <path d="M0 0h24v24H0z" fill="none"/>
            <path d="M12 4l-1.41 1.41L16.17 11H4v2h12.17l-5.58 5.59L12 20l8-8z"/>
          </svg>
        </span>
      </a>
    </div>

  </div>


<!-- __________________________________________________________________________________________________________ -->
    </div>    
    
<%
}
%>



    </div>
    </body>
</html>