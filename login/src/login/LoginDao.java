package login;

import movies.Film;

import java.sql.*;
import java.util.List;

public class LoginDao {

	public static boolean validate(String name, String pass) {
		boolean validLogin = false;
		try {
			//defining database driver to use
			Class.forName("com.mysql.jdbc.Driver");
			
			//getting connection from the mysql database
			//jdbc:mysql://localhost:3306 is database url
			//login is database name
			//root : username
			//root: password
			//syntex : databaseurl/databasename, username , password
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/login", "root", "");
			

			//prepared statement is used for secure access
			// ? used for data to put in query
			// actual query to execute is
			// select * from users where username = name and password = pass
			PreparedStatement oPrStmt = con
					.prepareStatement("SELECT * FROM `user_accounts` WHERE email=? AND password=?");// ? represents some parameter to include
																							
			oPrStmt.setString(1, name);// parameter index start from 1
			oPrStmt.setString(2, pass);
			ResultSet rs = oPrStmt.executeQuery(); // executing the query and getting the resultset from databse
			
			//rs.next() shows that the resultset contains nect value or not
			// for retrieving multiple results, you can use while(rs.next)
			
			if (rs.next()) { //checking if the resultset has any value?   
				validLogin = true;
			}
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return validLogin;
	}
	
	public static boolean getTopMovies(List<Film> topMovies) {
		boolean validReturn = false;
		try {
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
			

			//prepared statement is used for secure access
			// ? used for data to put in query
			// actual query to execute is
			// select * from users where username = name and password = pass
			PreparedStatement oPrStmt = con
					.prepareStatement("SELECT * FROM films ORDER BY rating DESC");// ? represents some parameter to include
																							
			ResultSet rs = oPrStmt.executeQuery(); // executing the query and getting the resultset from databse
			
			//rs.next() shows that the resultset contains next value or not
			// for retrieving multiple results, you can use while(rs.next)
			
			while(rs.next()) 
			{ //checking if the resultset has any value?   
				
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
				
				topMovies.add(movie);
			
				validReturn = true; //search was successful if there is a value
			}
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return validReturn;
	}
}
