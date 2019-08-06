<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>

<style>
.div1 {
	display: center;
	width: 450px;
	height: 250px;
	border: 1px solid black;
	box-sizing: border-box;
	background-color: #b0c4c4;
}
</style>


<body>
	<h1>Add Product here</h1>
	<a href="tohome">Welcome</a>
	<hr>
	<p style="float: center">${viewMessage }</p>
	<c:forEach var="customer" items="${customerList}"></c:forEach>

	<div class="div1">
		<form action="addProduct">
			Bike Name: <input type="text" name="name" /><br>
			<br> Image: <input type="text" name="image" /><br>
			<br> Description: <input type="text" name="description" /><br>
			<br> Quantity: <input type="text" name="Quantity" /><br>
			<br> Price: <input type="text" name="price" /><br>
			<br> Option <input type="text" name="Option" /><br>
			<br> <input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>