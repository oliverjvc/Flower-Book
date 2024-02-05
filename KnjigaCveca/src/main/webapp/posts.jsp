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
	font-family: Arial, sans-serif;
}

/* Style for the container div */
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
	/* Make textarea width 100% of its parent (.recommendation-post) */
	height: 100%;
	/* Make textarea height 100% of its parent (.recommendation-post) */
	border: none; /* Remove textarea border for a cleaner look */
	resize: none;
	margin-bottom: 10px; /* Add margin between textarea and button */
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

.submit-button {
	display: block;
	width: 100%;
	padding: 10px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	margin-top: 10px;
}

.submit-button:hover {
	background-color: #45a049;
}

/* Add this style to your existing CSS styles */
.comment-link {
	color: black; /* Set the desired text color */
	text-decoration: none; /* Remove underlining */
	background: none; /* Remove any background color */
	border: none; /* Remove border if needed */
	cursor: pointer;
	padding: 0; /* Adjust padding as needed */
}

.comment-link:hover {
	/* Optional: Add styles for hover state */
	text-decoration: underline; /* Add underlining on hover if desired */
}
</style>
</head>
<body>
	<%@include file="header2.jsp"%>
	
	<div class="container mt-4">
		<div class="row">
			<div class="col-md-8">
				<h2>Dobrodošli na stranicu "Prodaja i Uputstva za Očuvanje
					Cveća"</h2>
				<p>Saznajte sve o održavanju cveća, gde kupiti, preporuke za
					zalivanje, prskanje, i još mnogo toga.</p>

			<!-- 	<h2>NAPRAVI POST</h2>
				<a href="admin/dashboard.jsp" class="btn btn-primary"> dodaj</a> <br></br>
			 -->
				


				<h4>Linkovi ka radnjama</h4>
				<p>Posetite naše radnje kako biste pronašli savršeno cveće za
					vaš vrt.</p>
				<a href="https://www.cvecarastrelitzia.com/" target="_blank"
					class="btn btn-primary">Radnja 1</a> <a
					href="https://www.dalija.rs/" target="_blank"
					class="btn btn-primary">Radnja 2</a>
				<!-- Dodajte ostale linkove po potrebi -->

			</div>
		</div>
	</div>

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
					Pogledati komentare</button>
			</div>
		</c:forEach>
	</div>

</body>
</html>
