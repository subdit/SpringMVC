<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edited Products</title>
</head>
<body>
	<div>
		<div>PRODUCT EDIT FORM</div>
		<div> 
			<form action="${pageContext.request.contextPath}/saveProduct" method="post">
				<input type="text" name="id" placeholder="enter product id" value="${product.id}"> <br><br>
				<input type="text" name="name" placeholder="enter product name" value="${product.name}"><br><br>
				<input type="text" name="image" placeholder="enter product image" value="${product.image}"><br><br>
				<input type="text" name="description" placeholder="enter product description " value="${product.description}"><br><br>
				<input type="text" name="price" placeholder="enter product price " value="${product.price}"><br><br>
				<input type="submit" value="Save"><br><br>
			</form>
		</div>

	</div>
	
	
</body>
</html>