package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import others.DatabaseConnection;

@WebServlet(name="LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		User u=new User();
		u.setUsername(req.getParameter("username"));
		u.setPassword(req.getParameter("password"));
		
		try
		{
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from users where username=? and password=?");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				User user=new User();
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setRole(rs.getString("role"));
				
				HttpSession hs=req.getSession();
				hs.setAttribute("user", user);
				
				Cookie ck1=new Cookie("un", u.getUsername());
				Cookie ck2=new Cookie("pwd", u.getPassword());
				
				ck1.setMaxAge(60);
				ck2.setMaxAge(30);
				
				resp.addCookie(ck1);
				resp.addCookie(ck2);
				
				PrintWriter out=resp.getWriter();
				out.println("<script>"
						+ "alert('welcome user');"
						+ "window.location='index.jsp';"
						+ "</script>");
			}
			else
			{
				PrintWriter out=resp.getWriter();
				out.println("<script>"
						+ "alert('incorrect username or password');"
						+ "window.location='login.jsp';"
						+ "</script>");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}

