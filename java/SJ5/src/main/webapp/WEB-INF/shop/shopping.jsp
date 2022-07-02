<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Phong's Store</title>
</head>
<body>
	<h2>Phong's Store</h2>
	<a href="/product/new">Go to Cart</a>
	<table border=1>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.productId}</td>
					<td>${product.productName}</td>
					<td>${product.quantity}</td>
					<td>${product.price}</td>
					<td><a href="/shop/add-to-cart/${product.productId}">Add to Cart</a> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>