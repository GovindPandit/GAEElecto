<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	#productdiv
	{
		margin:10%;
	}
	#imagediv
	{
		width:30%;
		float:left;
	}
	#imagediv img
	{
		width:300px;
		height:350px;
	}
	#contentdiv
	{
		width:35%;
		float:left;
	}
	#buttondiv
	{
		float:left;
		width:35%;
	}
	#buttondiv a
	{
		display:block;
		border:2px solid white;
	}
	#buttondiv a:hover
	{
		background:red;
		color:white;
	}
	
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
		
	<sql:setDataSource driver="com.mysql.jdbc.Driver"
					   url="jdbc:mysql://34.93.171.229:3306/electo"
					   user="root"
					   password="root"
					   var="con"/>
	
	<sql:query var="data" dataSource="${con}">
		select * from products where productid=?
		<sql:param>${param.productid}</sql:param>
	</sql:query>
	
	<c:forEach items="${data.rows}" var="row">
		<div id="productdiv">
			<Div id="imagediv">
				<img src="ImageServlet?productid=${row.productid}"/>
			</Div>
			<div id="contentdiv">
				<h2>Product Name:</h2>${row.productname}
				<h2>Product Price:</h2>${row.price}
				<h2>Product Quantity:</h2>${row.quantity}
			</div>
			<div id="buttondiv">
				<Br><br>
				<c:if test="${user.role=='admin'}">
					<a href="editproduct.jsp?productid=${row.productid}">Edit</a>
					<a href="DeleteServlet?productid=${row.productid}">Delete</a>
				</c:if>
				<a href="BuyServlet">Buy</a>
			</div>
		</div>
	</c:forEach>
</body>
</html>