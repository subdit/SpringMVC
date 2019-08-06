<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
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
		<p style="float: center">${viewMessage }</p>
		<c:forEach var="customer" items="${customerList}">
						${customer.Name}
						${customer.cEmail}
							<br><br>
		</c:forEach>
			<hr>
	
	<form action="LogIn" method="POST">
		Email: <input type="email" name="email"  label="email"/><br><br>
		Password: <input type="password" name="password" label="password"/><br><br>
				<input type="submit" value="submit">
	</form><br><br> 
	
	
	<%-- <form action="LogIn" method="POST" name="form_name" id="form_id" class="form_class" >
	<form action="LogIn" method="POST">
		<input type="text" name="email" id="email" placeholder="Valid Email" />
		
		
	</form><br><br>  --%>
			<%-- <form:form action="LogIn" method="POST" modelAttribute="customerKey">
			
			Email: <input type="email" name="cEmail" label="email"/><br><br>

			Password: <form:input type="text" path="cPass" label="password" id="cPass"/>
					<form:errors path="cPass"/><br><br>
					
			<input type="submit" value="Submit">
		</form:form> --%>
		
	</div>
	<hr>
	
</body>
</html>