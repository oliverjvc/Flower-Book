<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Individual Recommendation</title>
<style>
body {
	font-family: Arial, sans-serif;
	text-align: center;
	margin-top: 20px;
}

.individual-recommendation {
	width: 60%;
	margin: 0 auto;
}

.post-content {
	padding: 10px;
	box-sizing: border-box;
	overflow: hidden;
	widtxh: 100%;
	border: 1px solid #ccc;
	border-radius: 8px;
}

textarea {
	width: 100%;
	height: 100px;
	border: none;
	resize: none;
	margin-bottom: 10px;
}

.submit-button {
	padding: 10px;
	background-color: #007BFF;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.submit-button:hover {
	background-color: #0056b3;
}

.comment-section {
	margin-top: 20px;
	text-align: center;
}

.comment {
	border: 1px solid #ccc;
	border-radius: 8px;
	padding: 10px;
	margin-bottom: 10px;
}
</style>
</head>
<body>

	<%@include file="header2.jsp"%>
	<div class="individual-recommendation">
		<form
			action="${pageContext.request.contextPath}/KnjigaCveca/addComment"
			method="post">
			<div class="post-content">
				<textarea readonly style="height: 306px;">${individualRecommendation.recommendationText}</textarea>
				<textarea name="commentText" placeholder="Add your comment..."></textarea>
				<input type="hidden" name="recommendationId"
					value="${individualRecommendation.recommendationId}"> <input
					type="hidden" name="userId" value="${yourUserId}">
				<button class="submit-button" type="submit">Submit Comment</button>
			</div>
		</form>
	</div>

	<div class="comment-section">
		<h3>Comments:</h3>
		<form
			action="${pageContext.request.contextPath}/KnjigaCveca/showComments"
			method="post">
			<input type="hidden" name="recommendationId"
				value="${individualRecommendation.recommendationId}">
			<!-- 			<button class="show-comments-button" type="submit">Show Comments</button>  -->
		</form>
	</div>
	<div>
		<c:forEach var="comment" items="${comments}">
			<div class="comment-post" contenteditable='false'>
				<div class="comment-content">
					<h4>${comment.userName}:</h4>
					<h6>${comment.timestamp}</h6>
					<textarea readonly>${comment.commentText}</textarea>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>
