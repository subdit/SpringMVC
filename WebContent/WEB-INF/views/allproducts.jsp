<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<script type="text/javascript"></script>

<title>Show All Products</title>
</head>

<style>
	.body-style{
	background-color:#dceced;
	color:black;
	}
</style>

<body class="body-style">
	<hr>
	<h2 style="text-align: center;">Show All Products</h2>
	<div class="tohome-style" style="text-align:center;">
	<a href="tohome">HOME</a> 
	</div>
	<hr>
		
	<div class="container marketing" style="display: center;">
		<div class="row">
			
			<c:forEach var="item" items="${productsList}">
			<hr>
			
				<div class="col-lg-4">
					<svg class="bd-placeholder-img rounded-circle" width="140"
						height="140" xmlns="http://www.w3.org/2000/svg"
						preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
						aria-label="Placeholder: 140x140">
	              	<title>Title: ${item.pName}</title>
	              <rect width="100%" height="100%" fill="#777" />
						<text x="50%" y="50%" fill="white" dy=".5em">${item.pName}</text>
	            </svg>
					<h2>Name: ${item.pName}</h2>
					<p>Description: ${item.pDescription}</p>
					<p>Price: ${item.pPrice}</p>
					<p>Quantity: ${item.pQuantity}</p>
					<p>
					<form action="addToCart" method="post">
						<input type="hidden" value="${item.pId}" name="itemId">
						<button>Add to cart</button>
					</form>
				<%-- <a class="btn btn-secondary" href="Cart/${item.pId}" role="button">Add to cart &raquo;</a> --%>
				
					</p>
					
				</div>
				<%-- <a href="${pageContext.request.contextPath}/updateProducts/${products.id}">Update</a>
			<a href="${pageContext.request.contextPath}/removeProducts/${Products.id}">Delete</a> --%>
				<hr>
	         </c:forEach>
         </div>
         <!-- /.col-lg-4 -->
	</div>
		
		
</body>
</html>