<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>Udaan Creations Admin</title>

  <!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link rel="stylesheet" type="text/css" href="css/zabuto_calendar.css">
  <link rel="stylesheet" type="text/css" href="lib/gritter/css/jquery.gritter.css" />
  <!-- Custom styles for this template -->
  
  <link href="css/homestyle.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">
  <script src="lib/chart-master/Chart.js"></script>
  
  <link href="css/jspstyle.css" rel="stylesheet"  media="all" />
  <link href="css/main.css" rel="stylesheet" media="all">
  
  <!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>

<body>
  <section id="container">
    <!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
    <!--header start-->
    <header class="header black-bg">
      <div class="sidebar-toggle-box">
        <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
      </div>
      <!--logo start-->
      <a href="home.jsp" class="logo"><b>Udaan<span>Creations</span></b></a>
      <!--logo end-->
      <div class="nav notify-row" id="top_menu">
        <!--  notification start -->
        <ul class="nav top-menu">
          <!-- settings start -->
          
          <!-- settings end -->
          <!-- inbox dropdown start-->
                    <!-- notification dropdown end -->
       
        </ul>
        <!--  notification end -->
      </div>
      <div class="top-menu">
        <ul class="nav pull-right top-menu">
          <li><a class="logout" href="login.jsp">Logout</a></li>
        </ul>
      </div>
    </header>
    <!--header end-->
    <!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
    <!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
          <p class="centered"><a href="profile.html"><img src="img/ui-sam.jpg" class="img-circle" width="80"></a></p>
          <h5 class="centered">${USER}</h5>
          <li class="mt">
            <a href="home.jsp">
              <i class="fa fa-dashboard"></i>
              <span style="font-size: 18px;font-weight: lighter;">Dashboard</span>
              </a>
          </li>
         
          <li class="sub-menu" style="font-size: 12px;">
            <a href="javascript:;">
              <i class="fa fa-desktop"></i>
              <span style="font-size: 18px;font-weight: lighter;">Products</span>
              </a>
            <ul class="sub" style="font-size: 16px;">
              <li style="font-size: 16px;"><a href="adminAddProducts"><label style="font-size: 17px;">Add Products</label></a></li>
              <li><a href="adminUpdateProducts"><label style="font-size: 17px;">Update Products</label></a></li>
              <li><a href="adminDeleteProducts"><label style="font-size: 17px;">Delete Products</label></a></li>
              
            </ul>
          </li>
           <li class="sub-menu">
            <a class = "active" href="javascript:;">
              <i class="fa fa-desktop"></i>
              <span style="font-size:18px;font-weight:lighter;">Sale</span>
              </a>
            <ul class="sub">
              <li><a href="adminAddSales"><label style="font-size: 17px;">Add Sale</label></a></li>
              <li><a href="adminUpdateSales"><label style="font-size: 17px;">Update Sale</label></a></li>
              <li><a href="adminDeleteSales"><label style="font-size: 17px;">Delete Sale</label></a></li>
              
            </ul>
          </li>
         
         <li class="sub-menu">
            <a href="adminAllProducts">
              <i class="fa fa-desktop"></i>
              <span style="font-size: 18px;font-weight: lighter;">All Products</span>
              </a>
              </li>
              
        </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>
      
        
<section id="main-content" >
      <section class="wrapper">
        <div class="row">
          <div class="col-lg-9 main-chart">
            <!--CUSTOM CHART START -->
<c:choose>
            <c:when test="${not empty SELECTEDSALE.productId}">
                <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790" >
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Udaan Update Sale Product Database</h2>
                </div>
                <div class="card-body" style="background: white; height:590px;">
                    <form method="POST" action="updateSaleData" enctype = "multipart/form-data">
                        <input type="hidden"  value="${SELECTEDSALE.productId}" name="productId">
                        <input type="hidden"  value="${SELECTEDSALE.saleBase64Image}" name="productImage">
                        <div class="form-row">
                            <div class="name">Product Name</div>
                            <div>
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="productName" value ="${SELECTEDSALE.productName}">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Price</div>
                            <div >
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="productPrice" value ="${SELECTEDSALE.productPrice}">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Image</div>
                            <div >
                                
                            </div>
                             <img style="padding-left: 5px;" src="data:image/jpg;base64,${SELECTEDSALE.saleBase64Image}" width="70px;" height="70px;">
                        </div>
             
                        <div class="form-row">
                        <div class="name">Discounted Price</div>
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="productDiscountedPrice" value="${SELECTEDSALE.productDiscountedPrice}">
                                </div></div>
                        <div class="form-row">
                            <div class="name">Special Offer</div>
                            <div>
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="productOffer" value="${SELECTEDSALE.productOffer}" >
                                </div>
                            </div>
                        </div>
                                                <div>
                            <button class="btn btn--radius-2 btn--red" type="submit">Update Sale</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div></div></section></section>
                
            </c:when>
            <c:otherwise>

            </c:otherwise>
        </c:choose>            


<div class="products">
		<div class="container">
			
			<div class="col-md-8 products-right">
				
				<div id="myTabContent" class="tab-content" style="padding-top: 0px;">
					
				
							
				<c:forEach items="${PRODUCTS}" var="product" >
				<form action = "getSelectedSaleData" method="post">
				<input type="hidden" value="${product.productId}" name ="productId">
				<div class="agile_top_brands_grids" >
					<div class="col-md-4 top_brand_left">
						<div class="hover14 column">
							<div class="agile_top_brand_left_grid" >
								
								<div class="agile_top_brand_left_grid1">
									<figure>
										<div class="snipcart-item block">
											<div class="snipcart-thumb">
												<a href="single.html"><img title=" " alt=" " src="data:image/jpg;base64,${product.saleBase64Image}" width="120px" height="120px"></a>		
												<p style="font-size: 18px;font-weight: bolder;background: white;color:red;">${product.productName}</p>
												<h4 style="color:green;font-size: 18px;">$ ${product.productDiscountedPrice} <span>$ ${product.productPrice}</span></h4>
												<span>${product.productOffer}</span>
											</div><br>
											<button type="submit"  style="font-size:16px;background-color: red;color:white;border: thick;width: 80px;margin-left: 32px;border-color: black;border-style: outset;font-weight:bold;">Select</button>
											
										</div>
									</figure>
								</div>
							</div>
						</div>
					</div>
					</form>
	</div></c:forEach>
	
	</div></div></div>
</div>


    </section>
    
    
    
    
    
    <!--sidebar end-->
    <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
    <!--main content start-->
    
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="lib/jquery/jquery.min.js"></script>

  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="lib/jquery.scrollTo.min.js"></script>
  <script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
  <script src="lib/jquery.sparkline.js"></script>
  <!--common script for all pages-->
  <script src="lib/common-scripts.js"></script>
  <script type="text/javascript" src="lib/gritter/js/jquery.gritter.js"></script>
  <script type="text/javascript" src="lib/gritter-conf.js"></script>
  <!--script for this page-->
  <script src="lib/sparkline-chart.js"></script>
  <script src="lib/zabuto_calendar.js"></script>
  <script type="text/javascript">
    
  </script>
  <script type="application/javascript">
    $(document).ready(function() {
      $("#date-popover").popover({
        html: true,
        trigger: "manual"
      });
      $("#date-popover").hide();
      $("#date-popover").click(function(e) {
        $(this).hide();
      });

      $("#my-calendar").zabuto_calendar({
        action: function() {
          return myDateFunction(this.id, false);
        },
        action_nav: function() {
          return myNavFunction(this.id);
        },
        ajax: {
          url: "show_data.php?action=1",
          modal: true
        },
        legend: [{
            type: "text",
            label: "Special event",
            badge: "00"
          },
          {
            type: "block",
            label: "Regular event",
          }
        ]
      });
    });

    function myNavFunction(id) {
      $("#date-popover").hide();
      var nav = $("#" + id).data("navigation");
      var to = $("#" + id).data("to");
      console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
    }
  </script></body>
</html>
