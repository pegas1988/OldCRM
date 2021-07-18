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

        <div class="p-3 mb-2 bg-secondary text-white">
            <center>
                <h1>Nature have no bad weather!</h1>
            </center>
        </div>
        <center></center>
        <div class="coll mb-3">
            <label class="coll form-label">The city is: </label>
            <label name="city" class="coll form-label">${city}</label>
        </div>
        <div class="coll mb-3">
            <label class="coll form-label">The temperature is: </label>
            <label name="temp" class="coll form-label">${temp}</label>
        </div>
        <div class="coll mb-3">
            <label class="form-label">Fills like: </label>
            <label name="fillTemp" class="form-label">${fillTemp}</label>
        </div>
        <div class="coll mb-3">
            <label class="coll form-label">The pressure is: </label>
            <label name="pressure" class="form-label">${pressure}</label>
        </div>
        <div class="coll mb-3">
            <label class="form-label">The speed of the wind is: </label>
            <label name="windSpeed" class="form-label">${windSpeed}</label>
        </div>
        <div class="coll mb-3">
            <label class="coll form-label">The weather is: </label>
            <label name="weatherType" class="form-label">${weatherType}</label>
        </div>
        </center>

    </div>
</form>
<!-- </center> -->
</body>
</html>