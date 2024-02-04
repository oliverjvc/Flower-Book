<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>posts</title>
    
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        /* Style for the container div */
        .recommendation-container {
            width: 50%; /* Adjust the width as needed */
            margin: 20px auto; /* Center the container */
            display: flex;
            flex-direction: column; /* Arrange items vertically */
        }

        textarea {
            width: calc(100% - 22px); /* Adjust the width as needed */
            height: 100px; /* Adjust the height as needed */
            padding: 10px;
            margin-bottom: 20px; /* Adjust the margin between recommendations */
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            resize: none; /* Disable textarea resizing */
        }

        /* Style for the button */
        button {
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <%@include file="header.jsp"%>
    
    <form action="${pageContext.request.contextPath}/KnjigaCveca/showAllRecommendations" method="get">
        <!-- <button type="submit">Show All Recommendations</button>-->
    </form>
    
    <div class="recommendation-container">
        <c:forEach var="recommendation" items="${recommendations}">
            <textarea readonly>${recommendation.recommendationText}</textarea>
        </c:forEach>
    </div>
    
</body>
</html>
