<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Product</title>
</head>
<body >
<h3 style="color:blue;font-size:22px;"><e:error property="reg_error"/></h3>
<form action="addProduct" method="post" enctype="multipart/form-data">
<center>
<table  >
<tr>
<td style="font-size:28px;">Product Name</td>
<td><input type = "text" name = "name"></td>
<td style="color:red;font-size:18px;"><e:error property="name"></e:error></td>
</tr>
<tr>
<td style="font-size:28px;">Quantity</td>
<td><input type = "text" name = "quantity"></td>
<td style="color:red;font-size:18px;"><e:error property="email"></e:error></td>
</tr>
<tr>
<td style="font-size:28px;">Price</td>
<td><input type = "text" name = "price"></td>
<td style="color:red;font-size:18px;"><e:error property="phone"></e:error></td>
</tr>

<td style="font-size:28px;">Image</td>
<td><input type = "file" name = "image"></td>
<td style="color:red;font-size:18px;"><e:error property="photo"></e:error></td>
</tr>

</table>
<br>

<input style="font-size:18px;background-color: yellow;" type="submit" value="submit">
</center></form>
<br>

</body>
</html>



