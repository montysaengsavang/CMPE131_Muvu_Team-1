package accounts;

import movies.Film;
import java.util.ArrayList;
import java.util.List;

public class User {

	public String email;
	public String password;
	public List<Film> favorites = new ArrayList<Film>(5);
	public int[] favPID = {0, 0, 0, 0, 0};
	
	
	public User(String n, String p)
	{
		email = n;
		password = p;
		
	}
	
}
