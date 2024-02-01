<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Prodaja i Uputstva za Očuvanje Cveća</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">


<style>
header {
	background-color: #007bff;
	color: #fff;
	padding: 15px 0;
}

section {
	margin-top: 30px;
}

.account-info {
	background-color: #f8f9fa;
	padding: 20px;
	border-radius: 8px;
}

footer {
	background-color: #007bff;
	color: #fff;
	padding: 10px 0;
	position: fixed;
	bottom: 0;
	width: 100%;
}
</style>
</head>

<body>

    <%@include file="header.jsp"%>

    <div class="container mt-4">
        <div class="row">
            <div class="col-md-8">
                <h2>Dobrodošli na stranicu "Prodaja i Uputstva za Očuvanje Cveća"</h2>
                <p>Saznajte sve o održavanju cveća, gde kupiti, preporuke za zalivanje, prskanje, i još mnogo toga.</p>


                <h4>Linkovi ka radnjama</h4>
                <p>Posetite naše radnje kako biste pronašli savršeno cveće za vaš vrt.</p>
                <a href="https://www.cvecarastrelitzia.com/" target="_blank" class="btn btn-primary">Radnja 1</a>
                <a href="https://www.dalija.rs/" target="_blank" class="btn btn-primary">Radnja 2</a>
                <!-- Dodajte ostale linkove po potrebi -->

                <h4>Komentari Ljudi</h4>
                <div>
                    <p>Pročitajte iskustva drugih ljudi sa našim cvećem:</p>
                    <!-- Prikazi komentare ljudi -->
                </div>
                <form>
                    <div class="mb-3">
                        <label for="changeRecommendation" class="form-label">Imate li preporuku za promene na stranici?</label>
                        <textarea class="form-control" id="changeRecommendation" name="changeRecommendation" rows="3"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Pošalji Preporuku</button>
                </form>
            </div>

            <div class="col-md-4">
                <!-- Prikazi korisničke profile, bašte i povezane linkove -->
                <!-- Dodaj obavezno administratora i korisnike -->
            </div>
        </div>
    </div>

    <!-- Dodajte Bootstrap JS i ostale skripte po potrebi -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
