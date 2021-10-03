<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>createLead</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%@include file="patterns/navbar.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
        integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
        crossorigin="anonymous"></script>

<form method="post">
    <div class="container mb-3 mt-3 w-50 p-3">
        <div class="p-3 mb-2 bg-secondary text-white">
            <center>
                <h1>Add new Lead!</h1>
                <p class="text-white-50">Please fill in this form to create new Lead</p>
            </center>
        </div>
        <div class="mb-3">
            <label for="clientName" class="form-label">Client first name</label>
            <input type="text" class="form-control" id="clientName" placeholder="Enter first name" name="clientName"
                   required>
        </div>

        <div class="mb-3">
            <label for="clientLastName" class="form-label">Client last name</label>
            <input type="text" class="form-control" id="clientLastName" placeholder="Enter last name"
                   name="lastName" required>
        </div>

        <div class="mb-3">
            <label for="exampleInputEmail" class="form-label">Birthday</label>
            <input type="text" class="form-control" id="exampleInputEmail" placeholder="Enter product" name="dayOfBirth"
                   required>
        </div>

        <div class="mb-3">
            <label class="form-label">Sex</label>
            <input type="text" class="form-control" placeholder="Enter clients sex" name="sex" required>
        </div>

        <div class="d-grid gap-2">
            <button type="submit" class="btn btn-outline-secondary">Add client and go further</button>
        </div>

    </div>
</form>
</body>
</html>