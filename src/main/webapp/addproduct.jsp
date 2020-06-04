<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
<link href="formstyle.css" rel="stylesheet"/>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
		<br>
		<Center>
		<form action="AddProductServlet" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>Product Name:</td>
				<td><input type="text" name="productname"/></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price"/></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input type="number" name="quantity"/></td>
			</tr>
			<tr>
				<td>Select Image</td>
				<td><input type="file" accept="image/*" name="photo"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Product"/></td>
				<td><input type="reset" value="Reset"/></td>
			</tr>
		</table>
		</form>
		</Center>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>