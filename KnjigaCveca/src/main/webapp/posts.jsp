<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>posts</title>

<style>
 body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-image: url('<%= request.getContextPath() %>/background/pozadina2.jpg'); 
            background-size: cover; 
            background-repeat: no-repeat;         
        }


.recommendation-container {
	width: 100%;
	text-align: center;
	margin-top: 20px;
	overflow-y: auto;
}

.recommendation-post {
	display: inline-block;
	margin-right: 40px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 8px;
	overflow: hidden;
}

.post-content {
	padding: 10px;
	box-sizing: border-box;
	overflow: hidden;
	width: 400px;
	height: 200px;
}

textarea {
	width: 100%;
	height: 100%;
	border: none; /* Remove textarea border for a cleaner look */
	resize: none;
	margin-bottom: 10px; /* Add margin between textarea and button */
}

button {
	padding: 10px;
	background-color:#d64161;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

button:hover {
	background-color: #eca1a6;
}

.submit-button {
	display: block;
	width: 100%;
	padding: 10px;
	background-color: #d64161;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	margin-top: 10px;
}

.submit-button:hover {
	background-color: #eca1a6;
}

.comment-link {
	color: #fff; /* Set the desired text color */
	text-decoration: none; /* Remove underlining */
	background-color: #d64161; /* Set background color */
	border: 2px solid #d64161; /* Add a border */
	border-radius: 5px; /* Make it round */
	padding: 5px 10px; /* Adjust padding as needed */
	display: inline-block; /* Make it a block element */
	transition: background-color 0.3s, color 0.3s;
	/* Add a smooth transition effect */
	cursor: pointer;
}

.comment-link:hover {
	background-color: #eca1a6; /* Change background color on hover */
	color: #fff; /* Change text color on hover */
	text-decoration: none; /* Remove underlining on hover if desired */
}

</style>
</head>
<body>
	<%@include file="header2.jsp"%>

	<div class="container mt-4">
		<div class="row">
			<div class="col-md-8">
				<h2>Dobrodošli na stranicu za uputstva o očuvanju cveća</h2>
				<p>Saznajte sve o održavanju cveća, gde kupiti, i još mnogo toga.</p>

				<!-- 	<h2>NAPRAVI POST</h2>
				<a href="admin/dashboard.jsp" class="btn btn-primary"> dodaj</a> <br></br>
			 -->



				<h4>Linkovi ka radnjama</h4>
				<p>Posetite naše radnje kako biste pronašli savršeno cveće za
					vaš vrt.</p>
				<a href="http://localhost:8080/KnjigaCveca/KnjigaCveca/stores?" class="btn btn-primary">Radnje</a>
			</div>
		</div>
	</div>
	
	<h2>Objave:</h2>
	<form
		action="${pageContext.request.contextPath}/KnjigaCveca/showAllRecommendations"
		method="get">
		<!-- <button type="submit">Show All Recommendations</button>-->
	</form>

	<div class="recommendation-container">
		<c:forEach var="recommendation" items="${recommendations}">
			<div class="recommendation-post" contenteditable='false'>
				<div class="post-content">
					<textarea readonly>${recommendation.recommendationText}</textarea>
				</div>
				<button class="comment-link"
					onclick="window.location.href='${pageContext.request.contextPath}/KnjigaCveca/showIndividualRecommendation?id=${recommendation.recommendationId}&userId=${yourUserId}'">
					Pogledati celu objavu</button>
			</div>
		</c:forEach>
	</div>

</body>
</html>
