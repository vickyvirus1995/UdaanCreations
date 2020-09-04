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
<table border="1" style="width: 800px;font-size: 18px;font-weight: bold;" align="center">
<tr><td>Name</td><td>Price</td><td>Quantity</td><td>Image</td></tr>
<c:forEach items="${Products}" var="product">
<tr>
<td style="background-color: yellow">${product.name}</td>
<td style="background-color: green">${product.price}</td>
<td style="background-color: blue">${product.quantity}</td>
<td style="width: 100px;"><img src="../Product Images/${product.image}" alt="" height="90px" width="90px" /></td>
</tr>
</c:forEach>
</table>
</body>
</html>