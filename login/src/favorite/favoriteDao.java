package favorite;

import java.sql.*;

public class favoriteDao {

	public static boolean addToFavorites(String name, int favID, int[] favPID) {
		boolean isFavInserted = false;
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
			

			
			//traverse at most 5 times
			for(int i = 0; i < 5; i++)
			{//continue through loop until we find an empty space
				if(favPID[i] == 0) //if any location in array has a 0 in it, it is empty, so we will store a movie id in there
				{
					//statement to update table where email is user's
					PreparedStatement oPrStmt = con
							.prepareStatement("UPDATE `user_accounts` SET `fav" + (i+1) +"`= ? WHERE email LIKE ? ");// ? represents some parameter to include
								
					//set variables with the id we want to put in and the name of the user
					oPrStmt.setInt(1, favID);
					oPrStmt.setString(2, name);// parameter index start from 1
		
					//execute update
					int n = oPrStmt.executeUpdate();
					
					if(n>0)
					{ // check that the data is inserted successfully or not
						isFavInserted = true;
						//if entry was inserted, return true and leave
						return isFavInserted;
						
					}
				}
				//if no empty space is found, we will return default, which is false. This means there is no room in database
			
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return isFavInserted;
	}
}