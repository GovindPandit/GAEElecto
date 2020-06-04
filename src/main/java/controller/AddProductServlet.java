package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Product;
import others.DatabaseConnection;

@WebServlet(name = "AddProductServlet", urlPatterns = "/AddProductServlet")
@MultipartConfig(maxFileSize = 999999999999999L)
public class AddProductServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product p=new Product();
		p.setProductname(req.getParameter("productname"));
		p.setPrice(Float.parseFloat(req.getParameter("price")));
		p.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		p.setStatus("A");
		
		Part part=req.getPart("photo");
		InputStream is=part.getInputStream();
		
		try
		{
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into products (productname,price,quantity,status,photo) values (?,?,?,?,?)");
			ps.setString(1,p.getProductname());
			ps.setFloat(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.setString(4, p.getStatus());
			ps.setBlob(5, is);
			ps.executeUpdate();
			
			//RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			//rd.forward(req, resp);
			
			//resp.sendRedirect("login.jsp");
			
			PrintWriter out=resp.getWriter();
			out.println("<script>"
					+ "alert('Product Added Successfully!!!');"
					+ "window.location='products.jsp';"
					+ "</script>");
		}
		catch(Exception e)
		{
			System.out.println(e);
			PrintWriter out=resp.getWriter();
			out.println("<script>"
					+ "alert('"+e.getMessage()+"');"
					+ "window.location='addproduct.jsp';"
					+ "</script>");
		}
	}
	
}
