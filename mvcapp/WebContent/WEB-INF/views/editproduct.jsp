<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
</head>

 <style> 
 .div1 {
	  display:center;
	  width: 450px;
	  height: 250px;
	  border: 1px solid black;
	  box-sizing: border-box;
	  background-color: #b0c4c4;
}
</style>


<body>
 	<h1>Update Product here</h1>
 	<a href="${pageContext.request.contextPath}/updateProduct/${product.pId}">HOME</a> 
 	<hr>
 	<p style="float: center">${viewMessage }</p>
 	
 	<div class="div1">
 	

		<form action="${pageContext.request.contextPath}/updateProduct/${product.pId}">
		
			Bike Name: <input type="text" name="name" value="${product.pName}" placeholder="${product.pName}" /><br><br>
			
			Image: <input type="text" name="image" value="${product.pImage}" placeholder="${product.pImage}"/><br><br>
			 
			Description: <input type="text" name="description" value="${product.pDescription}" placeholder="${product.pDescription}"/><br><br>
			
			Quantity: <input type="text" name="Quantity" value="${product.pQuantity}" placeholder="${product.pQuantity}"/><br><br>
			
			Price: <input type="text" name="price" value="${product.pPrice}" placeholder="${product.pPrice}"/><br><br>
			
			Option <input type="text" name="Option" value="${product.pOption}" placeholder="${product.pOption}"/><br><br>
			
			<input type="submit" value="Submit">
		</form>
 	</div>
</body>
</html>