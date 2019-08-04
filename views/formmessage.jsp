<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORM MESAGESSSSSSSS</title>
</head>
<body>
<body>
	<h1>FORM MESSAGE</h1>
	<div>
	<hr>
	${viewMessage} <!--this is special language to point from eclipse  -->
	<hr>
	${userName} 
	</div>
	<a href="index">home</a>
				<hr>
	<div>
		<form action="myform" >
			<label>User Name:</label><input type="text" name="username" value="username"/>
			<label>User Name:</label><input type="text" name="username" value=${userName} />
			<label>Password:</label><input type="password" name="userpasswd" value="passwd"/>
									<input type="submit" value="Login">
			</form><br>
				<hr>
	</div>
   				<hr>	
</body>
</html>