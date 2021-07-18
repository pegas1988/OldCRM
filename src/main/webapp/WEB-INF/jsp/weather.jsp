<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddNewUser</title>
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
<!-- <link href="css/style.css" rel="stylesheet">
<center> -->
<form method="post">
    <div class="container mb-3 mt-3 w-50 p-3">
        <div class="d-grid gap-2 p-3 mb-2 bg-secondary text-white">
            <center>
                <H1 class="text-white-50">Choose the city you wish to see the weather</H1>
            </center>
        </div>
        <select class="form-select d-grid gap-2 p-3 mb-2" aria-label="Choose the city" name="city">
            <option selected>Click here to show the list of cities</option>
            <option value="London">London</option>
            <option value="Paris">Paris</option>
            <option value="Moscow">Moscow</option>
            <option value="New York">NewYork</option>
            <option value="Odesa">Odessa</option>
        </select>
        <div class="d-grid gap-2 p-3 mb-2">
            <button type="submit" class="btn btn-outline-secondary">Submit</button>
        </div>

    </div>
</form>
<!-- </center> -->
</body>
</html>