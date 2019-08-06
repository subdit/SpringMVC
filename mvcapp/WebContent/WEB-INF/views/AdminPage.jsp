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
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
						
						
						<a class="nav-link" href="AboutUs">About</a>
						<a class="nav-link" href="${pageContext.request.contextPath}/allproducts">Products</a>
						<a class="nav-link" href="${pageContext.request.contextPath}/Cart">Cart</a>
						
						
					<a class="nav-link" href="${pageContext.request.contextPath}/adminAllProducts">All Product</a>
						
						
					</ul>
					<ul class="nav navbar-nav navbar-right">
		 		      <li class="nav-item">
        			<a class="nav-link" href="registration">Registration</a>
 				</li>
						
						<li class="nav-item"><a class="nav-link" href="loginpage">LogIn</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="LogOut">LogOut</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="GetAddProducts">Add Product</a>
						</li>
						<!-- <li class="nav-item"><a class="nav-link" href="WelcomePage">Welcome Page</a>
						</li> -->
					</ul>
				</div>
				<!--/.navbar-collapse -->
			</div>
		</nav>
	</section>
	
<%-- 	<div>
		<div>PRODUCT EDIT FORM</div>
		<div> 
			<form action="${pageContext.request.contextPath}/saveProduct" method="post">
				
				<input type="text" name="name" placeholder="enter product name" value="${product.name}"><br><br>
				<input type="text" name="image" placeholder="enter product image" value="${product.image}"><br><br>
				<input type="text" name="description" placeholder="enter product description " value="${product.description}"><br><br>
				<input type="text" name="quantity" placeholder="enter quantity " value="${product.quantity}"><br><br>
				<input type="text" name="price" placeholder="enter product price " value="${product.price}"><br><br>
				<input type="submit" value="Save"><br><br>
			</form>
		</div>

	</div> --%>
	
	
	
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
