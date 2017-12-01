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
			

			
			//prepared statement is used for secure access
			// ? used for data to put in query
			// actual query to execute is
			// select * from users where username = name and password = pass
			for(int i = 0; i < 5; i++)
			{
				if(favPID[i] == 0)
				{
					PreparedStatement oPrStmt = con
							.prepareStatement("UPDATE `user_accounts` SET `fav" + (i+1) +"`= ? WHERE email LIKE ? ");// ? represents some parameter to include
								
					oPrStmt.setInt(1, favID);
					oPrStmt.setString(2, name);// parameter index start from 1
		
					int n = oPrStmt.executeUpdate();
	
					if(n>0)
					{ // check that the data is inserted successfully or not
						isFavInserted = true;
						return isFavInserted;
					}
				}

			
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return isFavInserted;
	}
}