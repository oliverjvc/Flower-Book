<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Knjiga cveća</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>

	<!-- Your site's navigation bar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Knjiga cveća</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="/KnjigaCveca/admin/dashboard.jsp">Početna</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/KnjigaCveca/stores.jsp">Radnje</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/KnjigaCveca/aboutUS.jsp">O nama</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Kontakt</a>
					</li>
					<sec:authorize access="isAuthenticated()">
						<li class="nav-item"><a class="nav-link" href="MyAccount.jsp">Dobrodošli,
								<sec:authentication property="principal.username" />
						</a></li>
					</sec:authorize>
					<sec:authorize access="!isAuthenticated()">
						<li class="nav-item"><a class="nav-link"
							href="/KnjigaCveca/login.jsp">Prijavljivanje</a></li>
					</sec:authorize>
					<!-- Add more menu items as needed -->
				</ul>
			</div>
		</div>
	</nav>

	<!-- Add more elements to your header if necessary -->

</body>

</html>
