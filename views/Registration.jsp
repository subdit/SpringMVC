<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
	<h1 style="text-align: center;">Registration Page</h1>
	<hr>
	<h3 class="Registration" style="background-color: lightblue;">Register
		Here Please!</h3>
	<div>
		<form:form action="addCustomer" method="POST" modelAttribute="customerKey">
			Email: <input type="text" name="cEmail" /><br><br>
			
			Name: <form:input type="text" path="cName" label="name" id="cName" />
			  		<form:errors path="cName" /><br><br>
			
			Password: <input type="password" name="cPass" /><br><br>
				
			<input type="submit" value="Submit">
		</form:form>
	</div>
	<hr>

</body>
</html>