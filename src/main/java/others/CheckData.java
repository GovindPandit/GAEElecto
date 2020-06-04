package others;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckData")
public class CheckData extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String id=req.getParameter("id");//email, username
		String val=req.getParameter("val");
		
		try
		{
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from users where "+id+"=?");
			ps.setString(1,val);
			ResultSet rs=ps.executeQuery();
			
			PrintWriter out=resp.getWriter();
			
			
			
			if(rs.next()) 
			{
				con.close();
				out.println(id+" is already exist");
			}
			else
			{
				con.close();
				out.println("");
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}
