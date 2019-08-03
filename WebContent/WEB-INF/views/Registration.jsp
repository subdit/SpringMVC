<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
	<h1 style="text-align: center;">Registration Page</h1>
	<hr>
	<h3 class="Registration" style="background-color: lightblue;">Register Here Please!</h3>
	<div>
	<form action="addCustomer" method="POST">
		Name: <input type="text" name="name" label="name" />
		Email: <input type="text" name="email" label="email" />
		Password: <input type="password" name="password" label="password" />
		ConfirmPassword: <input type="password" name="confirmpassword" label="confirmpasswd" />
		<input type="submit" value="Submit">
	</form>
	</div>
	<hr> 
	<a href="index">Home</a> 

</body>
</html>