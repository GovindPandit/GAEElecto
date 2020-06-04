<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<sql:setDataSource driver="com.mysql.jdbc.Driver"
					   url="jdbc:mysql://34.93.171.229:3306/electo"
					   user="root"
					   password="root"
					   var="con"/>
		 -->
	<sql:query var="rs" dataSource="${con}">
		select * from products where status=?
		<sql:param>A</sql:param>
	</sql:query>
			
	<br>		   
	<table align="center" border="1">
		<tr>
			<th></th>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Product Quantity</th>
			<c:if test="${user.role=='admin'}">
				<th>Edit | Delete</th>
			</c:if>
		</tr>
		<c:forEach items="${rs.rows}" var="row">
			<tr>
				<td><a href="product.jsp?productid=${row.productid}" style="background:none;"><img src="ImageServlet?productid=${row.productid}" height="200px" width="200px"/></a></td>
				<td>${row.productid}</td>
				<td>${row.productname}</td>
				<td>${row.price}</td>
				<td>${row.quantity}</td>
				<c:if test="${user.role=='admin'}">
					<td>
						<a href="editproduct.jsp?productid=${row.productid}" style="padding:1px 1px; display:block; border-radius:0px;">Edit</a>
						<a href="DeleteServlet?productid=${row.productid}" style="padding:1px 1px; display:block; border-radius:0px;">Delete</a>
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>