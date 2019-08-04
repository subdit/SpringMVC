<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogIn Page</title>
</head>
<body>
	<div class="container-login">
		
	<h1 class="login" style=" text-align:center; color: lightblue;">Please login!</h1>
	<br><br>
	<a href="tohome">HOME</a> 
	<hr>
	<form action="LogIn" method="POST">
		Email: <input type="text" name="email"  label="email"/>
		Password: <input type="password" name="password" label="password"/>
				<input type="submit" value="submit">
	</form><br><br>
	</div>
	<hr>
	
</body>
</html>