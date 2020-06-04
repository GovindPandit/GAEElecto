<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="header.css" rel="stylesheet"/>
</head>
<body>
	<!-- JSTL (JSP Standard Tag Libraries) -->
	<header>
		<h1>Welcome To Electo</h1>
		<nav>
			
			<a href="index.jsp">Home</a>
			
			<!-- Expression Language (EL) -->
			<c:if test="${user.username==null}">	
				<a href="login.jsp">Login</a>
				<a href="register.jsp">Register</a>
				<a href="aboutus.jsp">About Us</a>
				<a href="contactus.jsp">Contact Us</a>
			</c:if>
			
			
			
			<c:if test="${user.username!=null}">
				<c:if test="${user.role=='admin'}">
					<a href="addproduct.jsp">Add Product</a>
				</c:if>
				<a href="products.jsp">Products</a>
				<a href="login.jsp">Logout</a>
			</c:if>
		</nav>
	</header>
</body>
</html>