package others;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ConfirmOTPServlet")
public class ConfirmOTPServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession hs=req.getSession();
		String randomnumber=(String)hs.getAttribute("randomnumber");
		
		String otp=req.getParameter("otp");
		
		if(otp.equals(randomnumber))
		{
			PrintWriter out=resp.getWriter();
			out.println("<script>"
					+ "alert('OTP Confirmed!!!');"
					+ "window.location='changepassword.jsp';"
					+ "</script>");
		}
		else
		{
			PrintWriter out=resp.getWriter();
			out.println("<script>"
					+ "alert('OTP is incorrect please try again!!!');"
					+ "window.location='confirmotp.jsp';"
					+ "</script>");
		}
		
	}
}
