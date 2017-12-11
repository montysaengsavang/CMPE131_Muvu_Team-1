package login;

import movies.Film;
import accounts.User;
import java.sql.*;
import java.util.List;

public class LoginDao {

	public static boolean validate(User thisUser) {
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
					"jdbc:mysql://localhost:3306/users", "root", "");
			

			//prepared statement is used for secure access
			// ? used for data to put in query
			// actual query to execute is
			// select * from users where username = name and password = pass
			PreparedStatement oPrStmt = con
					.prepareStatement("SELECT * FROM `user_accounts` WHERE email=? AND password=?");// ? represents some parameter to include
								
			//setting ? variables in the above statement
			oPrStmt.setString(1, thisUser.email);// parameter index start from 1
			oPrStmt.setString(2, thisUser.password);
			ResultSet rs = oPrStmt.executeQuery(); // executing the query and getting the resultset from databse
			
			//rs.next() shows that the resultset contains nect value or not
			// for retrieving multiple results, you can use while(rs.next)
			
		
			if(rs.next()) { //checking if the resultset has any value? 
				
				validLogin = true;
				 //retrieve users list of favorite movies from users database, in this case all we need are the id's of each movie
				thisUser.favPID[0] = rs.getInt("fav1");
				thisUser.favPID[1] = rs.getInt("fav2");
				thisUser.favPID[2] = rs.getInt("fav3");
				thisUser.favPID[3] = rs.getInt("fav4");
				thisUser.favPID[4] = rs.getInt("fav5");
				
				//make a new connection to the movie database
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/movies", "root", "");
				
				//for each favorites list entry
				for(int i = 0; i < thisUser.favPID.length; i++)
				{
					
					//select from films table where id is favPID[i], which are the values we just got from the users table
					oPrStmt = con
							.prepareStatement("SELECT * FROM `films` WHERE id=?");
					oPrStmt.setInt(1, thisUser.favPID[i]);
					rs = oPrStmt.executeQuery(); 
				
					//check to see if rs has a next value, the search should only return 1 film
					if(rs.next())
					{
						//save film into an object and add to favorites list
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
						thisUser.favorites.add(movie);
					}
					
				}//end for loop
				
				//for(int i = 0; i < 5; i++)
				//	System.out.println("THIS IS THE FAV LIST: " + favoritesList.get(i).title);
			
				
			}//end rs.next if statement
	
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
			
			//ask database for movies in descending order by rating
			PreparedStatement oPrStmt = con
					.prepareStatement("SELECT * FROM films ORDER BY rating DESC");// ? represents some parameter to include
																							
			ResultSet rs = oPrStmt.executeQuery(); // executing the query and getting the resultset from databse
			
			//rs.next() shows that the resultset contains next value or not
			// for retrieving multiple results, you can use while(rs.next)
			
			//while there is a next entry result, add it to the topMovies list
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
