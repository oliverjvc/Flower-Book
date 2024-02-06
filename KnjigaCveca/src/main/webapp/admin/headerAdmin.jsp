<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Knjiga cveća</title>
    <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">


<style>
body {
	margin: 0;
	padding: 0;
	font-family: 'Arial', sans-serif;
}

header.navbar {
	background-color: #007BFF !important; /* Blue color */
	color: #fff;
	padding: 15px 0;
	text-align: left;
}

nav.bg-success {
	background-color: #007BFF !important; /* Blue color */
	color: #fff;
	padding: 10px 0;
}

nav .container {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

nav a.btn {
	color: #007BFF;
	background-color: #fff;
	border: none;
}

section.container {
	margin-top: 50px;
}

.account-info ul {
	list-style: none;
	padding: 0;
}

.account-info ul li {
	margin-bottom: 10px;
}

footer {
	background-color: #007BFF !important; /* Blue color */
	color: #fff;
	padding: 10px 0;
	position: fixed;
	bottom: 0;
	width: 100%;
	text-align: center;
}
</style>

    <!-- Add other stylesheets or scripts as needed -->
</head>

<body>

    <!-- Your site's navigation bar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="/KnjigaCveca/admin/dashboard.jsp">Knjiga cveća</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/KnjigaCveca/admin/dashboard.jsp">Početna</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="http://localhost:8080/KnjigaCveca/KnjigaCveca/showAllRecommendations?">Objave</a>
                    </li>
                     <li class="nav-item">
                        <a class="nav-link" href="http://localhost:8080/KnjigaCveca/KnjigaCveca/stores?">Radnje</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/KnjigaCveca/aboutUS.jsp">O nama</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Kontakt</a>
                    </li>
                    <sec:authorize access="isAuthenticated()">
                        <li class="nav-item">
                            <a class="nav-link" href="myAccountAdmin.jsp">Dobrodošli, <sec:authentication property="principal.username" /></a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <li class="nav-item">
                            <a class="nav-link" href="/KnjigaCveca/login.jsp">Prijavljivanje</a>
                        </li>
                    </sec:authorize>
                    <!-- Add more menu items as needed -->
                </ul>
            </div>
        </div>
    </nav>

    <!-- Add more elements to your header if necessary -->

</body>

</html>
