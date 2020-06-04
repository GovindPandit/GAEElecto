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
<jsp:include page="header.jsp"></jsp:include>
		<br>
		<Center>
		<form action="ChangePasswordServlet" method="post">
		<table border="1">
			<tr>
				<td>Enter New Password</td>
				<td><input type="text" name="password"/></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="text" name="confirmpassword"/></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Change Password"/></td>
				<td><input type="reset" value="Reset"/></td>
			</tr>
		</table>
		</form>
		</Center>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>