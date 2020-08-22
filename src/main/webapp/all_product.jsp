<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Decoration Store </title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Pendent Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/menu_jquery.js"></script>
<script src="js/simpleCart.min.js"> </script>
<link href='http://fonts.googleapis.com/css?family=Monda:400,700' rel='stylesheet' type='text/css'>
</head>
	
<body>
<!-- header -->
	
<!-- //header -->
<!-- top-header -->
<div class="top_bg">
	<div class="container">
		<div class="header_top-sec">
			<div class="top_right">
				<ul>
					<li>Contact &nbsp;</li>+91 970 250 3220 /
					
				</ul>
			</div>
			<div class="top_left">
				<ul>
					<li style="font-size: 18px;">rnas_udaancreations@yahoo.com</li>
										
				</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
</div>
<!-- top-header -->
<!-- logo-cart -->
<div class="header_top">
	<div class="container">
		<div class="logo">
		 	<a href="index.html"><p style="color:red;font-size:28px;">&nbsp; &nbsp; Udaan Store</p></a>			 
		</div>
		
		<div class="clearfix"></div>	
	</div>
</div>
<!-- //logo-cart -->
<!------>
<div class="mega_nav">
	 <div class="container">
		 <div class="menu_sec">
		 <!-- start header menu -->
		<ul class="megamenu skyblue">
			<li class="grid"><a class="color1" href="home">Home</a></li>
			<li class="grid"><a class="color1" href="#">Products</a></li>
			<li class="grid"><a class="color1" href="#">Sale</a></li>
			<li class="grid"><a class="color1" href="#">About Us</a></li>
			<li class="active grid"><a class="color1" href="contact.html">Contact</a></li>	
			<li class="grid"><a class="color1" href="#">Tutorial</a></li>								
		</ul>  
			<div class="search">
				 <form>
					<input type="text" value="" placeholder="Search...">
					<input type="submit" value="">
					</form>
			</div>
			<div class="clearfix"></div>
		 </div>
	  </div>
</div>
<!-- products -->
	<div class="products">
		<div class="container">
			<div class="products-grids">
				<div class="col-md-8 products-grid-left">
						<c:forEach items="${Products}" var="lists">
					<div class="products-grid-lft">
			
						<div class="products-grd">
						
       										<div class="p-one simpleCart_shelfItem prd">
								<a href="single.html">
										<img src="../Product Images/${lists.image}" alt="" class="img-responsive" />
										<div class="mask">
											<span>Quick View</span>
										</div>
								</a>
								<h4>${lists.name}</h4>
								<p><a class="item_add" > <span class=" item_price valsa">${lists.price} Rs<br>Remaining Quantity : ${lists.quantity}</span></a></p>
								<div class="pro-grd">
									<a href="single.html">10% Off</a>
								</div>
							</div>	
		
      </div>
		       </div>
</c:forEach>
						</div>
						</div>
						</div>
						</div>
						
						<div class="footer">
		<div class="container">
			<div class="col-md-3 footer-grid">
				<h6>Information</h6>
				<ul>
					<li><a href="#">About Us</a></li>
					<li><a href="#">Delivery Information</a></li>
					<li><a href="#">Privacy Policy</a></li>
					<li><a href="#">Terms &amp; Conditions</a></li>
				</ul>
			</div>
			
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="footer-copy">
		<p>© 2020 Udaan Store. All rights reserved | Design by Vicky Poojari</p>
	</div>
<!-- //footer -->
<!-- for bootstrap working -->
		<script src="js/bootstrap.js"> </script>
<!-- //for bootstrap working -->

</body>
</html>
</body>
</html>