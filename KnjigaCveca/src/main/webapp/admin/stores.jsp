<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Store Information Form</title>
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Arial', sans-serif;
            margin: 20px;
        }

        h2 {
            color: #007bff;
        }

        form {
            max-width: 400px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #007bff;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
        }
    </style>
</head>
<body>

    <h2>Enter Store Information</h2>

    <form action="${pageContext.request.contextPath}/admin/processStoreForm" method="post">
        <!-- Name of the store -->
        <label for="storeName">Store Name:</label>
        <input type="text" id="storeName" name="storeName" required>

        <!-- Location of the store -->
        <label for="storeLocation">Store Location:</label>
        <input type="text" id="storeLocation" name="storeLocation" required>

        <!-- Link to the store's website -->
        <label for="websiteLink">Website Link:</label>
        <input type="text" id="websiteLink" name="websiteLink" required>

        <!-- Another link (example) -->
        <label for="additionalLink">Additional Link:</label>
        <input type="text" id="additionalLink" name="additionalLink">

        <!-- Submit button -->
        <input type="submit" value="Submit">
    </form>

</body>
</html>
