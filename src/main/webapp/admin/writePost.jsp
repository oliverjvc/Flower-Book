<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <header class="text-center py-3">
        <h1>Admin Dashboard</h1>
    </header>

    <section class="container mt-4">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <form action="${pageContext.request.contextPath}/admin/submitRecommendation" method="post">
                    <div class="mb-3">
                        <label for="recommendationText" class="form-label">Write a Recommendation:</label>
                        <textarea class="form-control" id="recommendationText" placeholder="Review" name="recommendationText" rows="4" required></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit Recommendation</button>
                </form>
            </div>
        </div>
    </section>

    <footer class="text-center py-2">
        <p>&copy; Knjiga Cveća</p>
    </footer>
</sec:authorize>


<sec:authorize access="!hasRole('ROLE_ADMIN')">
    <div class="text-center">
        <p>Access Denied. You must be an admin to view this page.</p>
    </div>
</sec:authorize>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
