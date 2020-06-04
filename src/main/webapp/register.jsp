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
	<script>
		function myfunction(element)
		{
			var id=element.id;
			var val=element.value;
			
			var url="CheckData?id="+id+"&val="+val;
			
			 var xhttp = new XMLHttpRequest();
			 
			  xhttp.onreadystatechange = function() 
			  {
			    if (this.readyState == 4 && this.status == 200) 
			    {
			    	 document.getElementById("msg"+id).innerHTML = this.responseText;
			    }
			  };
			  
			  xhttp.open("GET", url);
			  xhttp.send();
		}
	</script>
	<jsp:include page="header.jsp"></jsp:include>
		<br>
		<Center>
		<form action="RegistrationServlet" method="post">
		<table border="1">
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" id="username" onkeyup="myfunction(this)"/></td>
				<td><span id="msgusername" style="color:red"></span></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" id="email" onkeyup="myfunction(this)"/></td>
				<td><span id="msgemail"  style="color:red"></span></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"/></td>
				<td><input type="reset" value="Reset"/></td>
			</tr>
		</table>
		</form>
		</Center>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>