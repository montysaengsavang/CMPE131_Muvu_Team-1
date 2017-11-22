package search;

import movies.Film;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchDao {
	public static boolean search(String query, Film film1) {
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

			System.out.println("IM HERE in search dao about to talk to database");
			//prepared statement is used for secure access
			// ? used for data to put in query
			// actual query to execute is
			// select * from users where username = name and password = pass
			
			PreparedStatement oPrStmt = con
					.prepareStatement("SELECT * FROM `films` WHERE `title` LIKE ?");// ? represents some parameter to include
																							
			oPrStmt.setString(1, query);// parameter index start from 
			ResultSet rs = oPrStmt.executeQuery(); // executing the query and getting the resultset from databse
			System.out.println("IM HERE just talked to database");
			//rs.next() shows that the resultset contains next value or not
			
			
			// for retrieving multiple results, you can use while(rs.next)
			
			if (rs.next()) { //checking if the resultset has any value?   
				//rs holds the results from the database
				
				film1.id = rs.getInt("id");
				film1.title = rs.getString("title");
				film1.description = rs.getString("description");
				film1.genre = rs.getString("genre");
				film1.duration = rs.getInt("duration");
				film1.year = rs.getInt("year");
				film1.stars = rs.getString("stars");
				film1.rating = rs.getDouble("rating");
				film1.url = rs.getString("url");
			
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
