<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Account</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        header.navbar {
            background-color: #28a745 !important; /* Green color */
            color: #fff;
            padding: 15px 0;
        }

        footer {
            background-color: #28a745 !important; /* Green color */
            color: #fff;
            padding: 10px 0;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body style="margin: auto;">

    <header class="navbar text-center py-3">
        <h1>My Account</h1>
    </header>
    <nav class="bg-success text-white py-2"> <!-- Green color -->
        <div class="container" style="display: flex; justify-content: space-between; align-items: center;">
            <a href="/KnjigaCveca/logout.jsp" class="btn btn-light text-success">Logout</a> <!-- Bootstrap button styles -->
            <%@include file="header.jsp"%>
        </div>
    </nav>

    <section class="container mt-4">
        <div class="account-info">
            <p>Welcome, <sec:authentication property="principal.username" />!</p>

            <p>Your account details:</p>
            <ul>
                <li><strong>Email:</strong> <sec:authentication property="principal.email" /></li>
                <li><strong>Username:</strong> <sec:authentication property="principal.username" /></li>
            </ul>
        </div>
    </section>

    <footer class="text-center py-2">
        <p>&copy; Knjiga Cveća</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
