<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Registration</title>
</head>
<body>

<h2>User Registration</h2>
<form action="${pageContext.request.contextPath}/registration" method="post">
    <!-- Your registration form fields go here -->
    <input type="text" name="username" placeholder="Username" required>
    <input type="password" name="password" placeholder="Password" required>
    <input type="text" name="email" placeholder="Email" required>
    <button type="submit">Register</button>
</form>

</body>
</html>
