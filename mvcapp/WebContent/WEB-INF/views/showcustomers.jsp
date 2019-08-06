<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Customers</title>
</head>
<body>

	<div>
		<h2>ALL CUSTOMERS</h2>
		<div>
		</div>
		
		<c:forEach var="customer" items="${customerList}">
			<p>${customer.cName}</p>
 			<p>${customer.cEmail}</p>
			<p>${customer.cPass}</p>
 			<hr>
		</c:forEach>
		
		<br><br><br><br>
	</div>
	
</body>
</html>