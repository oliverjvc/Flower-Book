<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Store Information Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
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

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <h2 class="mt-4 mb-3">‎ ‎ ‎ ‎ ‎ ‎ ‎ ‎ ‎‎ Unesite informacije o radnji</h2>

                <form action="${pageContext.request.contextPath}/admin/processStoreForm" method="post">
                    <div class="mb-3">
                        <label for="storeName" class="form-label">Ime radnje:</label>
                        <input type="text" id="storeName" name="storeName" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label for="storeLocation" class="form-label">Lokacija radnje:</label>
                        <input type="text" id="storeLocation" name="storeLocation" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label for="websiteLink" class="form-label">Website:</label>
                        <input type="text" id="websiteLink" name="websiteLink" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label for="additionalLink" class="form-label">Link za logo:</label>
                        <input type="text" id="additionalLink" name="additionalLink" class="form-control">
                    </div>

                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
