package clear;

import java.sql.*;

public class clearRelatedDao {

	public static boolean clearFavorites(String name) {
		boolean isCleared = false;
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
			{//continue through loop to clear all spaces
	
					//statement to update table where email is user's
					PreparedStatement oPrStmt = con
							.prepareStatement("UPDATE `user_accounts` SET `fav" + (i+1) +"`= ? WHERE email LIKE ? ");// ? represents some parameter to include
								
					//set variables with 0 to clear favorites list
					oPrStmt.setString(1, "0");
					oPrStmt.setString(2, name);// parameter index start from 1
		
					//execute update
					int n = oPrStmt.executeUpdate();
	
					if(n>0)
					{ // check that the data has been cleared or not
						isCleared = true;
					}
			}
		
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return isCleared;
	}
}