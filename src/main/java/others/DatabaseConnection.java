package others;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection 
{
	public static Connection getConnection()
	{
		Connection con=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://34.93.171.229:3306/electo","root","root");
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		return con;
	}
}
