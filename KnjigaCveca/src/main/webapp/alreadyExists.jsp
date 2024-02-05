<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
        setTimeout(function(){
            window.location.href = "${pageContext.request.contextPath}/login.jsp";
        }, 3000); // Redirect after 3000 milliseconds (3 seconds)
    </script>
    
    <h3>username already exists</h3>
</body>
</html>