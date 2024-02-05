<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Moj nalog</title>
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
	background-color: #28a745 !important; /* Green color */
	color: #fff;
	padding: 15px 0;
	text-align: left;
}

nav.bg-success {
	background-color: #28a745 !important; /* Green color */
	color: #fff;
	padding: 10px 0;
}

nav .container {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

nav a.btn {
	color: #28a745;
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
	background-color: #28a745 !important; /* Green color */
	color: #fff;
	padding: 10px 0;
	position: fixed;
	bottom: 0;
	width: 100%;
	text-align: center;
}
</style>

</head>
<body>

	<header class="navbar text-center py-3">
		<%@include file="headerAdmin.jsp"%>
		<h1>Moj nalog</h1>
	</header>

	<nav class="bg-success text-white py-2">
		<div class="container">
			<a href="/KnjigaCveca/logout.jsp" class="btn btn-light text-success">Logout</a>
		</div>
	</nav>

	<section class="container">
		<div class="account-info">
			<p>
				Dobrodošli,
				<sec:authentication property="principal.username" />
				!
			</p>

			<p>Detalji vašeg naloga:</p>
			<ul>
				<li><strong>Email:</strong> <sec:authentication
						property="principal.email" /></li>
				<li><strong>Username:</strong> <sec:authentication
						property="principal.username" /></li>
			</ul>
		</div>
	</section>

	<footer class="text-center py-2">
		<p>&copy; Knjiga Cveća</p>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
