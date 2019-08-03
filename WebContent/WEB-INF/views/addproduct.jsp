<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>
 	<h1>Add Product here</h1>
 	<a href="tohome">HOME</a> 
		<form action="addProduct">
			Bike Name: <input type="text" name="name" />
			
			Image: <input type="text" name="image"/>
			
			Description: <input type="text" name="description" />
			
			Quantity: <input type="text" name="Quantity"/>
			
			Price: <input type="text" name="price"/>
			
			Option <input type="text" name="Option"/>
			
			<input type="submit" value="Submit">
		</form>
 
</body>
</html>