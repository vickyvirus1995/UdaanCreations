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
<link href="css/jspstyle.css" rel="stylesheet" type="text/css" media="all" />
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
<div  class="header_top">
	<div class="container" style= "background-color:#f65a5b;">
		
<header   style ="background:  #22242a;width: 100%" >
<marquee>
      <!--logo start-->
      <a href="home.jsp" class="logo" style="
    font-size: 24px;
    color: #f2f2f2;
    float: left;
    margin-top: 15px;
    text-transform: uppercase;"><b style="font-weight: 900;">Udaan <span style="color: #4ECDC4;">Creations</span></b></a>
      <!--logo end-->
      </marquee>
      
    </header>
		
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
			<li class="active grid"><a class="color1" href="products">Products</a></li>
			<li class="grid"><a class="color1" href="sale">Sale</a></li>
			<li class="grid"><a class="color1" href="#">About Us</a></li>
			<li class="grid"><a class="color1" href="contact">Contact</a></li>	
			<li class="grid"><a class="color1" href="#">Tutorial</a></li>
			
		</ul> <div class="search">
				 <form action="searchProduct" method="get">
					<input type="text"  placeholder="Search..." name = "searchKeyword">
					<input type="submit" value="">
					</form>
			</div>
			<div class="clearfix"></div>
		 </div>
	  </div>
</div>
<!---->
<!-- banner -->
	
<!-- //banner -->
<!-- cate -->
	<!-- //slider -->



<div class="products">
		<div class="container">
			
			<div class="col-md-8 products-right">
				<div class="products-right-grid">
					<div class="products-right-grids">
					<form action="sortProductsByType" method="post" name ="sortType">
						<div class="sorting">
							<select id="country" name = "sortType" onchange="document.sortType.submit();" class="frm-field required sect">
								<c:choose>
								<c:when test="${SORTTYPE == 'Default Sorting'}">
								<option selected value="null"><i class="fa fa-arrow-right" aria-hidden="true"></i>Default sorting</option>
								</c:when>
								<c:otherwise>
								<option value="null"><i class="fa fa-arrow-right" aria-hidden="true"></i>Default sorting</option>
								</c:otherwise>
								</c:choose>
								<c:choose>
								<c:when test="${SORTTYPE == 'Sort By Popularity'}">
								<option selected value="Sort By Popularity"><i class="fa fa-arrow-right" aria-hidden="true"></i>Sort by popularity</option> 
								</c:when>
								<c:otherwise>
								<option value="Sort By Popularity"><i class="fa fa-arrow-right" aria-hidden="true"></i>Sort by popularity</option>
								</c:otherwise>
								</c:choose>			
								<c:choose>
								<c:when  test="${SORTTYPE == 'Sort By Price'}">
								<option selected value="Sort By Price"><i class="fa fa-arrow-right" aria-hidden="true"></i>Sort by price</option>								
								</c:when>
								<c:otherwise>
								<option value="Sort By Price"><i class="fa fa-arrow-right" aria-hidden="true"></i>Sort by price</option>
								</c:otherwise>
								</c:choose>
							</select>
						</div>
						</form>
						<form action="sortProductsByRecords" method="post" name ="numberOfRecords">
						<div class="sorting-left">
						
							<select id ="country1" name="numberOfRecord" onchange="document.numberOfRecords.submit();" class="frm-field required sect" value="${SELECTEDRECORDS}">
								<c:choose>
								<c:when test = "${SELECTEDRECORDS == '9'}"><option selected value="9"><i class="fa fa-arrow-right" aria-hidden="true"></i>Item on page 09</option></c:when>
								 <c:otherwise><option  value="9"><i class="fa fa-arrow-right" aria-hidden="true"></i>Item on page 09</option></c:otherwise>
							</c:choose>
								<c:choose>	
								<c:when test = "${SELECTEDRECORDS == '18'}"><option selected value="18"><i class="fa fa-arrow-right" aria-hidden="true"></i>Item on page 18</option></c:when>
								 <c:otherwise><option  value="18"><i class="fa fa-arrow-right" aria-hidden="true"></i>Item on page 18</option></c:otherwise>
								</c:choose>
								<c:choose>
								<c:when test = "${SELECTEDRECORDS == '32'}"><option selected value="32"><i class="fa fa-arrow-right" aria-hidden="true"></i>Item on page 32</option></c:when>
								 <c:otherwise><option  value="32"><i class="fa fa-arrow-right" aria-hidden="true"></i>Item on page 32</option></c:otherwise>
								</c:choose>
								<c:choose>					
								<c:when test = "${SELECTEDRECORDS == 'all'}"><option selected value="all"><i class="fa fa-arrow-right" aria-hidden="true"></i>Item on page All</option></c:when>
								 <c:otherwise><option  value="all"><i class="fa fa-arrow-right" aria-hidden="true"></i>Item on page All</option></c:otherwise>
							</c:choose>									
							</select>
							
							<input type="submit" value="" hidden="true"> 
						</div></form>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div id="myTabContent" class="tab-content" style="padding-top: 0px;">
					
							
				
				<div class="agile_top_brands_grids" >
					<c:forEach items="${PRODUCTS}" var="product" >
					<div class="col-md-4 top_brand_left">
						<div class="hover14 column">
							<div class="agile_top_brand_left_grid" >
								<div class="agile_top_brand_left_grid_pos">
									
								</div>
								<div class="agile_top_brand_left_grid1">
									<figure>
										<div class="snipcart-item block">
											<div class="snipcart-thumb">
												<a href="single.html"><img title=" " alt=" " src="Product Images/${product.productImage}" width="130px" height="130px"></a>		
												<p style="font-size: 18px;font-weight: bolder;">${product.productName}</p>
												<h4 style="color:green;font-size: 18px;">$ ${product.productPrice} <span></span></h4>
											</div>
											
										</div>
									</figure>
								</div>
							</div>
						</div>
					</div>
	</c:forEach></div></div></div></div>
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
