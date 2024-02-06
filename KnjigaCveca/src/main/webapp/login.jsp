<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    
    <title>Login</title>
</head>
<body>

<h2>User Login</h2>
<form action="${pageContext.request.contextPath}/login" method="post">
    <!-- Your login form fields go here -->
    <input type="text" name="username" placeholder="Username" required>
    <input type="password" name="password" placeholder="Password" required>
    <button type="submit">Login</button>
</form> 

	<a href="${pageContext.request.contextPath}/registration">Nemate nalog?</a>

</body>
</html>
