package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import others.DatabaseConnection;
import others.Email;

@WebServlet(name="RegistrationServlet",urlPatterns = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		User u=new User();
		u.setUsername(req.getParameter("username"));
		u.setEmail(req.getParameter("email"));
		u.setPassword(req.getParameter("password"));
		u.setRole("user");
		
		try
		{
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into users (username,email,password,role) values (?,?,?,?)");
			ps.setString(1,u.getUsername());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getRole());
			ps.executeUpdate();
			
			//RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			//rd.forward(req, resp);
			
			//resp.sendRedirect("login.jsp");
			
			Email email=new Email(u.getEmail(),"GAE Registration","Registered Successfully!!!");
			email.sendEmail();
			
			PrintWriter out=resp.getWriter();
			out.println("<script>"
					+ "alert('Registered Successfully!!!');"
					+ "window.location='login.jsp';"
					+ "</script>");
		}
		catch(Exception e)
		{
			System.out.println(e);
			PrintWriter out=resp.getWriter();
			out.println("<script>"
					+ "alert('"+e.getMessage()+"');"
					+ "window.location='login.jsp';"
					+ "</script>");
		}
	}
	
}
