package others;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SendOTPServlet")
public class SendOTPServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email=req.getParameter("email");
		
		try
		{
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from users where email=?");
			ps.setString(1, email);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				Random r=new Random();
				int randomnumber=r.nextInt(8999)+1000;
				
				Email e=new Email(email, "Password Reset OTP", "OTP is: "+randomnumber);
				e.sendEmail();
				
				HttpSession hs=req.getSession();
				hs.setAttribute("randomnumber", randomnumber+"");
				hs.setAttribute("email", email);
				
				
				PrintWriter out=resp.getWriter();
				out.println("<script>"
						+ "alert('Please check email for OTP!!!');"
						+ "window.location='confirmotp.jsp';"
						+ "</script>");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			PrintWriter out=resp.getWriter();
			out.println("<script>"
					+ "alert('"+e.getMessage()+"');"
					+ "window.location='changepassword.jsp';"
					+ "</script>");
		}
	}
}
