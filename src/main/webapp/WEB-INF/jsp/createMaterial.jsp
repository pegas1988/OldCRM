<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>createMaterial</title>
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
                <h1>Add new Material!</h1>
                <p class="text-white-50">Please fill in this form to create new Material</p>
            </center>
        </div>
        <div class="mb-3">
            <label for="exampleInputName" class="form-label">Material name</label>
            <input type="text" class="form-control" id="exampleInputName" placeholder="Enter name" name="materialName"
                   required>
        </div>

        <div class="mb-3">
            <label for="exampleInputLastName" class="form-label">Type</label>
            <input type="text" class="form-control" id="exampleInputLastName" placeholder="Enter type of material"
                   name="type" required>
        </div>

        <div class="mb-3">
            <label for="exampleInputEmail" class="form-label">Colour</label>
            <input type="text" class="form-control" id="exampleInputEmail" placeholder="Enter colour" name="colour"
                   required>
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>

        <div class="mb-3">
            <label class="form-label">Price</label>
            <input type="text" class="form-control" placeholder="Enter price per dm2" name="price" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Quantity</label>
            <input type="text" class="form-control" placeholder="Enter quantity" name="quantity" required>
        </div>

        <div class="d-grid gap-2">
            <button type="submit" class="btn btn-outline-secondary">Add material</button>
            <button type="button" class="btn btn-secondary" onclick="window.location.href='/CRM_war/seeAllMaterials';">
                See list of materials
            </button>
        </div>

    </div>
</form>
</body>
</html>