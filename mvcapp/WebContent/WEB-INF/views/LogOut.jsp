<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log out Page</title>
</head>
	<%
	session.invalidate();
	response.sendRedirect("WelcomePage");
	%>
<body>
    
</body>
</html>