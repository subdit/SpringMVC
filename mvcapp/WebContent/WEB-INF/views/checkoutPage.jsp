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

<title>Checkout Page</title>

<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
}

</style>
</head>
<body>

<header class="header">
			
	<h1 class="Checkout" style="text-align:center; color: white;">Coming Soon</h1><br><br>
	<h3 class="checkout-page" style="text-align:center;color: white;">Sorry for an inconvenience Please come back to visit us again</h3>
	</header>
	<p style="float: center">${viewMessage }</p>
						     ${customer.Name}
						     ${customer.cEmail}
<nav class="navbar navbar-inverse navbar-static-top"style="display: float-right;">
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
					<div id="navbar" class="navbar-collapse collapse">
				<!-- <div id="navbar" class="navbar-collapse collapse" style="display:float-right;"> -->
					<ul class="nav navbar-nav">
						<li>
							<a class="nav-link" href="${pageContext.request.contextPath}/tohome">Home <span class="sr-only">(current)</span></a>
						</li>
						<li>
							<a class="nav-link" href="${pageContext.request.contextPath}/allproducts">Continue Shopping</a><br>
						</li>
						<li>
							 <a class="nav-link" href="LogOut">LogOut</a>
						</li> 
						
					</ul>
			
				</div>
			</div>
	</nav>	
		<c:forEach var="item" items="${cartList}">
		
			<p style="float: center">${viewMessage }</p>
		
		<c:forEach var="customer" items="${customerList}">
						${customer.Name}
						${customer.cEmail}
		</c:forEach>
		<%-- <h3>${messageResult}</h3> --%>
	
		
			<div class="col-lg-4">

				<h2>Name: ${item.pName}</h2>
				<p>Photo: ${item.pImage}</p>
				<p>Description: ${item.pDescription}</p>
				<p>Price: ${item.pPrice}</p>
				<p>Quantity: ${item.pQuantity}</p>
				<!-- <a class="remove-button" href="Cart" role="button">Remove Item</a> -->
				<%-- <form action="removeProduct" method="post">
					<input type="hidden" value="${item.pId}" name="itemId">
					<input type="submit" value="Remove Item">
				</form> --%>
				
<%-- <a class="btn btn-secondary" href="${pageContext.request.contextPath}/removeProduct/${item.pId}" role="button">Remove Item</a> --%>
			<%-- <a class="nav-link" href="${pageContext.request.contextPath}/removeProducts/${item.id}">Remove</a> --%>
			<%-- <a href="${pageContext.request.contextPath}/updateProducts/${products.id}">Update</a>
			<a href="${pageContext.request.contextPath}/removeProducts/${Products.id}">Delete</a> --%>
			</c:forEach>

	<footer class="footer" style="text-content: center;">
		<h3 style="text-align:center;">Contact Info</h3>
		
		<p style="text-align: center;">
			<em>Copyrigth@BikeShop.com-2019</em>
		</p>
	</footer>
</body>
</html>