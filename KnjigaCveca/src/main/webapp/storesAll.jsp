<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of Stores</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .store {
            border: 1px solid #ccc;
            border-radius: 8px;
            padding: 10px;
            margin-bottom: 20px;
            max-width: 300px; /* Adjust the width as needed */
        }
        .website-button {
            background-color: #007bff;
            color: white;
            padding: 5px 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            display: block;
            margin-top: 10px; /* Add some margin between button and text */
        }
        .store img {
            max-width: 100%; /* Ensure images don't exceed the width of their container */
            height: auto;
            margin-top: 10px; /* Add some margin between image and other content */
        }
    </style>
</head>
<body>

<div class="container mt-4">

	<%@include file="header2.jsp"%>

    <h1>Lista radnji</h1>

    <div class="row">
        <c:forEach var="store" items="${stores}">
            <div class="col-md-4">
                <div class="store">
                    <p><strong>Naziv:</strong> ${store.name}</p>
                    <p><strong>Lokacija:</strong> ${store.location}</p>
                    <a href="${store.link}" target="_blank" class="website-button">Website</a>
                    <img src="${store.pic}" alt="Additional Image">
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
