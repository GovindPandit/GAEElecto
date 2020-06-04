package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import others.DatabaseConnection;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet 
{	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int productid=Integer.parseInt(request.getParameter("productid"));
		
		try
		{
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update products set status='D' where productid=?");
			ps.setInt(1, productid);
			ps.executeUpdate();
			
			PrintWriter out=response.getWriter();
			out.println("<script>"
					+ "alert('Product Deleted Successfully!!!');"
					+ "window.location='products.jsp';"
					+ "</script>");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
