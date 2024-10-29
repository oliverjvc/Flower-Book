<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Prodaja i Uputstva za Očuvanje Cveća</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-image: url('<%= request.getContextPath() %>/background/pozadina2.jpg'); 
            background-size: cover; 
            background-repeat: no-repeat;         
        }

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

        .textbox-container {
            border: 1px solid #ccc;
            padding: 10px;
            margin: 20px;
        }

    </style>
</head>

<body>

    <%@include file="headerAdmin.jsp"%>

    <div class="container mt-4">
        <div class="row">
            <div class="col-md-8">
                <h2>Dobrodošli na stranicu za upravljanje sistemom</h2>

                <br>
                <h2>Napravi objavu</h2>
                <a href="writePost.jsp" class="btn btn-primary"> dodaj</a> <br><br>

                <h2>Dodaj radnju</h2>
                <a href="stores.jsp" class="btn btn-primary"> dodaj</a> <br><br>
                
                <br>
                <h2>Vidi sve korisnike</h2>
                <a href="http://localhost:8080/KnjigaCveca/admin/getAllUsers?" class="btn btn-primary">Pogledaj</a>
            </div>
        </div>
    </div>

    <!-- Dodajte Bootstrap JS i ostale skripte po potrebi -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
