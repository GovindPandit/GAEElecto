package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import others.DatabaseConnection;

@WebServlet(name = "UpdateProductServlet",urlPatterns = "/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Product p = new Product();
		p.setProductid(Integer.parseInt(req.getParameter("productid")));
		p.setProductname(req.getParameter("productname"));
		p.setPrice(Float.parseFloat(req.getParameter("price")));
		p.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		
		try	
		{
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update products set productname=?,price=?,quantity=? where productid=?");
			ps.setString(1, p.getProductname());
			ps.setFloat(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.setInt(4, p.getProductid());
			ps.executeUpdate();
			resp.sendRedirect("products.jsp");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
