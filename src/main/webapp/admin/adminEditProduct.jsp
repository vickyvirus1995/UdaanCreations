<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Product</title>
</head>
<body>

<form action="saveProduct" method="post">
<table border="1" align="center">
<tr>
<td>Name</td>
<td><input type="text" value="${editProduct.name}"/></td>
<td>
</tr>
<tr>
<td>Price</td>
<td><input type="text" value="${editProduct.price}"/></td>
<td>
</tr>
<tr>
<td>Quantity</td>
<td><input type="text" value="${editProduct.quantity}"/></td>
<td>
</tr>
<tr>
<td>Image</td>
<td><input type="file" value="Browse And Upload"/>
</td>
<td><img src="../Product Images/${editProduct.image}" alt="" height="90px" width="90px"/></td>
<td>
</tr>
<tr>
<td></td><td><input style="font-size: 26px;background-color: green;color: yellow;" type="submit" value="Save"></td>
</tr>
</table>

</form>
<br><br><br>
<table border="1" style="width: 800px;font-size: 18px;font-weight: bold;" align="center">
<tr><td>Id</td><td>Name</td><td>Price</td><td>Quantity</td><td>Image</td></tr>
<c:forEach items="${product}" var="product">
<tr>
<form action="editProductDetails" method="post">

<td><input type="hidden" name = "product_id" value="${product.product_id}">${product.product_id}</td>
<td style="background-color: yellow">${product.name}</td>
<td style="background-color: green">${product.price}</td>
<td style="background-color: blue">${product.quantity}</td>
<td style="width: 100px;"><img src="../Product Images/${product.image}" alt="" height="90px" width="90px" /></td>
<td><input type="submit" value="Edit"/></td>


</form>
</c:forEach>
</table>
</body>
</html>