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
    <title>Moj nalog</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <header class="navbar navbar-expand-lg navbar-dark bg-primary py-3">
        <div class="container">
            <a class="navbar-brand" href="#">Moj nalog (ADMIN)</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/KnjigaCveca/logout.jsp">Logout</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/KnjigaCveca/admin/dashboard.jsp">Početna</a>
                    </li>
                </ul>
            </div>
        </div>
    </header>

    <section class="container mt-4">
        <div class="account-info">
            <p>
                Dobrodošli,
                <sec:authentication property="principal.username" />
                !
            </p>

            <p>Detalji vašeg naloga:</p>
            <ul class="list-group">
                <li class="list-group-item"><strong>Email:</strong> <sec:authentication property="principal.email" /></li>
                <li class="list-group-item"><strong>Username:</strong> <sec:authentication property="principal.username" /></li>
            </ul>
        </div>
    </section>

    <footer class="bg-primary text-white text-center py-2 fixed-bottom">
        <p>&copy; Knjiga Cveća</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
