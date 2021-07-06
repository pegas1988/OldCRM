<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Update Material</title>
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
        <center>
            <h1>Update Material</h1>
            <p class="text-primary">Please fill the material type update other fields</p>
        </center>
        <div class="mb-3">
            <label class="form-label">Type</label>
            <input type="text" class="form-control" id="type" placeholder="Enter type" name="type"
                   required>
        </div>
        <div class="d-grid gap-2">
            <button type="submit" class="btn btn-secondary">Proceed</button>
        </div>

    </div>
</form>

</body>
</html>