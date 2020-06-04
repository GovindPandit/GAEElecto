package others;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession hs=req.getSession();
		String email=(String)hs.getAttribute("email");
		
		String password=req.getParameter("password");
		String confipassword=req.getParameter("confirmpassword");
		
		if(password.equals(confipassword))
		{
			try
			{
				Connection con=DatabaseConnection.getConnection();
				PreparedStatement ps=con.prepareStatement("update users set password=? where email=?");
				ps.setString(1, password);
				ps.setString(2, email);
				ps.executeUpdate();
				
				PrintWriter out=resp.getWriter();
				out.println("<script>"
						+ "alert('Password Changed Successfully!!!');"
						+ "window.location='login.jsp';"
						+ "</script>");
			}
			catch (Exception e) 
			{
				System.out.println(e);
				PrintWriter out=resp.getWriter();
				out.println("<script>"
						+ "alert('"+e.getMessage()+"');"
						+ "window.location='changepassword.jsp';"
						+ "</script>");
			}
		}
		else
		{
			PrintWriter out=resp.getWriter();
			out.println("<script>"
					+ "alert('Password and confirm password is not same!!!');"
					+ "window.location='changepassword.jsp';"
					+ "</script>");	
		}
	}
}
