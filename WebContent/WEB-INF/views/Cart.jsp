<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart Page</title>
</head>

<body>
	<hr>

	<div class="my-class" style="text-align:center; color: lightblue;">
		<h2>Your Shopping Cart</h2>
		<h3>${messageResult}</h3>

		<a href="tohome">HOME</a> 

	
	</div>
		<div>
		<c:forEach var="item" items="${cartList}">
		<hr>
		
			<div class="col-lg-4">

				<h2>Name: ${item.pName}</h2>
				<p>Photo: ${item.pImage}</p>
				<p>Description: ${item.pDescription}</p>
				<p>Price: ${item.pPrice}</p>
				<p>Quantity: ${item.pQuantity}</p>
				<!-- <a class="remove-button" href="Cart" role="button">Remove Item</a> -->
				<form action="removeProduct" method="post">
				<input type="hidden" value="${item.pId}" name="itemId">
				<input type="submit" value="Remove Item">
				</form>
				
<%-- <a class="btn btn-secondary" href="${pageContext.request.contextPath}/removeProduct/${item.pId}" role="button">Remove Item</a> --%>
			<%-- <a class="nav-link" href="${pageContext.request.contextPath}/removeProducts/${item.id}">Remove</a> --%>
			<%-- <a href="${pageContext.request.contextPath}/updateProducts/${products.id}">Update</a>
			<a href="${pageContext.request.contextPath}/removeProducts/${Products.id}">Delete</a> --%>
		</c:forEach>
			</div>
        </div>
	<hr>
		
		<a class="nav-link" href="${pageContext.request.contextPath}/allproducts">Continue Shopping</a>
	<hr>
</body>
</html>