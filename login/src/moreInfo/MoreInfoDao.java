package moreInfo;

import java.util.*;
import movies.Film;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MoreInfoDao {
	public static boolean getMoreInfo(String thisID, Film movie) {
		boolean validSearch = false;

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
					.prepareStatement("SELECT * FROM `films` WHERE `id` = ?");	
			
			oPrStmt.setString(1, thisID);// parameter index start from 
			
			ResultSet rs = oPrStmt.executeQuery(); // executing the query and getting the resultset from databse
			
			//rs.next() shows that the resultset contains next value or not
			
			// for retrieving multiple results, you can use while(rs.next)
	
			if (rs.next()) { //checking if the resultset has any value?   
				//rs holds the results from the database

				movie.id = rs.getInt("id");
				movie.title = rs.getString("title");
				movie.description = rs.getString("description");
				movie.genre = rs.getString("genre");
				movie.duration = rs.getInt("duration");
				movie.year = rs.getInt("year");
				movie.stars = rs.getString("stars");
				movie.rating = rs.getDouble("rating");
				movie.url = rs.getString("url");	
			
				return true;
			}
		
		
		} 
		
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return validSearch;
	}
	
	

}
