<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of Stores</title>
    <!-- Add Bootstrap or any other CSS framework if needed -->
    <style>
        .store {
            border: 1px solid #ccc;
            border-radius: 8px;
            padding: 10px;
            margin-bottom: 10px;
            width: 300px; /* Adjust the width as needed */
            display: inline-block; /* Make divs inline */
            vertical-align: top; /* Align divs at the top */
            margin-right: 20px; /* Add some margin between divs */
        }
        .website-button {
            background-color: #007bff;
            color: white;
            padding: 5px 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            margin-top: 10px; /* Add some margin between button and text */
        }
        .store img {
            max-width: 100%; /* Ensure images don't exceed the width of their container */
            height: auto;
        }
    </style>
</head>
<body>

<h1>Lista radnji</h1>

<c:forEach var="store" items="${stores}">
    <div class="store">
        <p><strong>Naziv:</strong> ${store.name}</p>
        <p><strong>Lokacija:</strong> ${store.location}</p>
        <a href="${store.link}" target="_blank" class="website-button">Website</a>
        <p> </p>
        <img src="${store.pic}" alt="Additional Image">
    </div>
</c:forEach>

</body>
</html>
