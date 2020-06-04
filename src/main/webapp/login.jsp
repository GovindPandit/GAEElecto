<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="formstyle.css" rel="stylesheet"/>
</head>
<body>
	<!-- Scriplet Tag -->
	<!-- Scriplet tag is used in jsp page to write java code -->
	<%
		//Here session is built in object
		session.removeAttribute("user");
		session.invalidate();
	%>
	
	<%
		String username="",password="";
	
		try
		{
		
			Cookie ck[]=request.getCookies();
			
			for(Cookie c:ck)
			{
				if(c.getName().equals("un"))
				{
					username=c.getValue();
				}
				else if(c.getName().equals("pwd"))
				{
					password=c.getValue();
				}
			}
		}
		catch(Exception e)
		{
			
		}
	%>
	
	
	
	<jsp:include page="header.jsp"></jsp:include>
		<br>
		<Center>
		<form action="LoginServlet" method="post">
		<table border="1">
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" value="<%out.println(username);%>"/></td>
			</tr>
			
			<tr>
				<td>Password</td>
				<!-- Expression Tag -->
				<td><input type="password" id="password" name="password" value="<%=password%>"/></td>
			</tr>
			<tr>
				<td></td>
				<td><a href="collectemail.jsp" style="padding:0px 0px;background:none;border:none;">Forgot Password?</a></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"/></td>
				<td><input type="reset" value="Reset"/></td>
			</tr>
		</table>
		</form>
		</Center>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>