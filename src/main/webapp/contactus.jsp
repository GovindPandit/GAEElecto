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
		<form>
		<table border="1">
			<tr>
				<td><input type="text" name="name" placeholder="Enter Name"/></td>
			</tr>
			
			<tr>
				<td><input type="email" name="email" placeholder="Enter Email"/></td>
			</tr>
			
			<tr>
				<td><textarea rows="8" cols="21" name="query" placeholder="Enter Your Query"></textarea></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Submit"/></td>
			</tr>
			
			<tr>
				<td><input type="reset" value="reset"/></td>
			</tr>
		</table>
		</form>
		</Center>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>