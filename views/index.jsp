<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<link href="carousel.css" rel="style.css">
<link rel="canonical"
	href="https://getbootstrap.com/docs/4.3/examples/carousel/">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="./resources/img">
<!-- Bootstrap core CSS -->
<link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="animate.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
</script>

<title>BikeShop-Landing-Page</title>

<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
}

</style>
</head>

<body>

	<header class="header">
		<h2 class="animated rotateIn delay-2s" style="text-align:center;">Welcome to Bike shop</h2>
		<h3 class="animated fadeIn delay-4s" style="text-align:center;">You will find your dream
			bike here</h3>
	</header>
	
	<section>
		<p style="float: center">${viewMessage }</p>
		<c:forEach var="customer" items="${customerList}">
						${customer.Name}
						${customer.cEmail}
							<br><br>
		</c:forEach>
		<nav class="navbar navbar-inverse navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<!-- <a class="navbar-brand" href="#">Brand Name</a> -->

				</div>
				<div id="navbar" class="navbar-collapse collapse" style="display:float-right;">
					<ul class="nav navbar-nav">
						<li>
							<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
						</li>
						<li>
							<a class="nav-link" href="AboutUs">About</a>
						</li>
						<li>
							<a class="nav-link" href="${pageContext.request.contextPath}/allproducts">Products</a>
						</li>
						<li>
							<a class="nav-link" href="${pageContext.request.contextPath}/Cart">Cart</a>
						</li>
						<li>
							 <a class="nav-link" href="LogOut">LogOut</a>
						</li>
						<!-- <li class="nav-item"><a class="nav-link" href="GetAddProducts">Add Product</a>
						</li> -->
						
					</ul>
					<!-- <ul class="nav navbar-nav navbar-right">
		 		      <li class="nav-item">
        			<a class="nav-link" href="registration">Registration</a>
 				</li> -->
						
						<!-- <li class="nav-item"><a class="nav-link" href="loginpage">LogIn</a>
						</li> -->
						<!-- <li class="nav-item"><a class="nav-link" href="LogOut">LogOut</a>
						</li> -->
						<!-- <li class="nav-item"><a class="nav-link" href="GetAddProducts">Add Product</a>
						</li> -->
						<!-- <li class="nav-item"><a class="nav-link" href="WelcomePage">Welcome Page</a>
						</li> -->
					</ul>
				</div>
				<!--/.navbar-collapse -->
			</div>
		</nav>
	</section>
	
	
	
	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="<c:url value="/resources/img/bicycle-cycling-roadbike.jpg"/>" alt="road bike"
						width="460" height="345"/> 
					<div class="caption1" style="text-align: center;">
						<h3>Road Bike</h3>
						<h4>Ride on your own risk. Just lookout for the cars</h4>
					</div>
				</div>

				<div class="item" style="text-align: center;">
					<img src="<c:url value="/resources/img/mountain-bikeshop.jpg" />" alt="mountain bike"
						width="460" height="345" />
					<div class="caption2" style="text-align: center;">
						<h3>Mountain Bike</h3>
						<h4>Trails rider: Up and down hill anywhere you want to go.</h4>
					</div>
				</div>

				<div class="item" style="text-align: center;">
					<img src="<c:url value="/resources/img/bicycle-daylight-forest.jpg" />" alt="hybrid bike"
						width="460" height="345"/> 
					<div class="caption3">
						<h3>Hybrid Bike</h3>
						<h4>You can ride on the road and trials</h4>
					</div>
				</div>
			</div><br><br>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> 
			<a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<br>
	<!-- Marketing messaging and featurettes
    ================================================== -->
	<!-- Wrap the rest of the page in another container to center all the content. -->
	<br>
	<div class="container marketing" style="display: center;">

		<!-- Three columns of text below the carousel -->
		<div class="row">
			<div class="col-lg-4">
				<svg class="bd-placeholder-img rounded-circle" width="140"
					height="140" xmlns="http://www.w3.org/2000/svg"
					preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
					aria-label="Placeholder: 140x140">
              <title>Road Bike</title>
              <rect width="100%" height="100%" fill="#777" />
					<text x="50%" y="50%" fill="white" dy=".5em">Road Bike</text>
            </svg>
				<h2>Road Bike</h2>
				<p>Description: 26 inches, </p>
				<p>
					<!-- <a class="btn btn-secondary" href="registration" role="button">Add to
						cart &raquo;</a> -->
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<svg class="bd-placeholder-img rounded-circle" width="140"
					height="140" xmlns="http://www.w3.org/2000/svg"
					preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
					aria-label="Placeholder: 180x140">
            <title>Mountain Bike</title>
            <rect width="100%" height="100%" fill="#776" />
					<text x="50%" y="50%" fill="white" dy=".5em">Mountain Bike</text>
          </svg>
				<h2>Mountain Bike</h2>
				<p>Description: 29er, fox shocks: full suspension, front & back
					disbreaks</p>
				<p>
					<!-- <a class="btn btn-secondary" href="registration" role="button">Add to
						cart &raquo;</a> -->
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<svg class="bd-placeholder-img rounded-circle" width="140"
					height="140" xmlns="http://www.w3.org/2000/svg"
					preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
					aria-label="Placeholder: 140x140">
              <title>Hybrid Bike</title>
              <rect width="100%" height="100%" fill="#775" />
					<text x="50%" y="50%" fill="white" dy=".3em">Hybrid Bike</text>
            </svg>
				<h2>Hybrid Bike</h2>
				<p>Hybrid bike can ride on both tails and roads.</p>
				<p>
					<!-- <a class="btn btn-secondary" href="registration" role="button">Add to
						cart &raquo;</a> -->
				</p>
			</div>
			<!-- /.col-lg-4 -->
		</div>
		<div>
		<%-- <%@ include file="allproducts.jsp" %> --%>
		</div>
	
		<!-- /.row -->
		<!-- </main> -->
	</div>

	<!-- FOOTER -->
	<hr>
	<footer class="footer" style="text-content: center;">
		<h3 style="text-align:center;">Contact Info</h3>
		
		<p style="text-align: center;">
			<em>Copyrigth@BikeShop.com-2019</em>
		</p>
	</footer>
	<hr>
	
<!--scripts   -->

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
	<script src="/docs/4.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o"
		crossorigin="anonymous"></script>
	<script>
  $(document).ready(function(){
    // Activate Carousel
    $("#myCarousel").carousel();

    // Enable Carousel Indicators
    $(".item1").click(function(){
      $("#myCarousel").carousel(0);
    });
    $(".item2").click(function(){
      $("#myCarousel").carousel(1);
    });
    $(".item3").click(function(){
      $("#myCarousel").carousel(2);
    });
    $(".item4").click(function(){
      $("#myCarousel").carousel(3);
    });

    // Enable Carousel Controls
    $(".left").click(function(){
      $("#myCarousel").carousel("prev");
    });
    $(".right").click(function(){
      $("#myCarousel").carousel("next");
    });
  });
  </script>
  
<!--End  All Scripts -->

</body>
</html>
