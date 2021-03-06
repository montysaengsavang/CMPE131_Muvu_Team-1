package search;

import java.util.*;
import movies.Film;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchDao {
	public static boolean search(String query, List<Film> searchResults) {
		boolean validSearch = false;
		
		if(query.equals(" "))
			return validSearch;
			
		try 
		{	
			//defining database driver to use
			Class.forName("com.mysql.jdbc.Driver");
			
			//getting connection from the mysql database
			//jdbc:mysql://localhost:3306 is database url
			//login is database name
			//root : username
			//root: password
			//syntex : databaseurl/databasename, username , password
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/movies", "root", "");

			
			//find films from database where title is like our query
			PreparedStatement oPrStmt = con
					.prepareStatement("SELECT * FROM `films` WHERE `title` LIKE ?");	
			
			
			oPrStmt.setString(1, "%" + query + "%");// parameter index start from 
			ResultSet rs = oPrStmt.executeQuery(); // executing the query and getting the resultset from databse
			
			//rs.next() shows that the resultset contains next value or not
			
			
			// for retrieving multiple results, you can use while(rs.next)
	
		
			
			
			while (rs.next()) { //checking if the resultset has any value?   
				//rs holds the results from the database

				Film movie = new Film();
				movie.id = rs.getInt("id");
				movie.title = rs.getString("title");
				movie.description = rs.getString("description");
				movie.genre = rs.getString("genre");
				movie.duration = rs.getInt("duration");
				movie.year = rs.getInt("year");
				movie.stars = rs.getString("stars");
				movie.rating = rs.getDouble("rating");
				movie.url = rs.getString("url");
				
				searchResults.add(movie);
			
				validSearch = true; //search was successful if there is a value
				
			
			}
		
		
		} 
		
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return validSearch;
	}
	
	

}
