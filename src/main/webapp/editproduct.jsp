<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="formstyle.css" rel="stylesheet"/>
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
	
	<br>
	<c:forEach items="${data.rows}" var="row">
			<form action="UpdateProductServlet" method="post">
			<table border="1" align="center">
				<tr>
					<td>Product Id:</td>
					<td><input type="text" name="productid" value="${row.productid}"/></td>
				</tr>
				<tr>
					<td>Product Name:</td>
					<td><input type="text" name="productname" value="${row.productname}"/></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="price" value="${row.price}"/></td>
				</tr>
				<tr>
					<td>Quantity</td>
					<td><input type="number" name="quantity" value="${row.quantity}"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update Product"/></td>
					<td><input type="reset" value="Reset"/></td>
				</tr>
			</table>
		</form>
	</c:forEach>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>