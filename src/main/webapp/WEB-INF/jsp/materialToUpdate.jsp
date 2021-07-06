<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="material" type="entity.Material"--%>
<html>
<head>
    <title>UpdateMaterial</title>
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
            <h1>Update Material...</h1>
            <p class="text-primary">Please fill in this form to update material</p>
        </center>

        <div class="mb-3">

            <p>Current name: ${material.materialName}</p>
            <label for="exampleInputName" class="form-label"></label>
            <input type="text" class="form-control" id="exampleInputName" placeholder="Please enter new name"
                   name="materialName"
                   required>
            <input type="hidden" class="form-control" name="oldName" value="${material.materialName}">

        </div>
        <div class="mb-3">
            <p>Current type: ${material.type}</p>
            <label for="exampleInputLastName" class="form-label"></label>
            <input type="text" class="form-control" id="exampleInputLastName" placeholder="Please enter new material type"
                   name="type" required>
            <input type="hidden" class="form-control" name="oldType" value="${material.type}">
        </div>

        <div class="mb-3">
            <p>Current price: ${material.price}</p>
            <input type="text" class="form-control" placeholder="Enter new price" name="price" required>
            <input type="hidden" class="form-control" name="oldPrice" value="${material.price}">
        </div>

        <div class="mb-3">
            <p>Current quantity: ${material.quantity}</p>
            <input type="text" class="form-control" placeholder="Enter new quantity" name="quantity" required>
            <input type="hidden" class="form-control" name="oldQuantity" value="${material.quantity}">
        </div>

        <div class="mb-3">
            <p>Current colour: ${material.colour}</p>
            <input type="text" class="form-control" placeholder="Enter new colour" name="colour" required>
            <input type="hidden" class="form-control" name="oldColour" value="${material.colour}">
        </div>

        <div class="d-grid gap-2">
            <button name="Submit" type="submit" class="btn btn-secondary">Update</button>
        </div>

    </div>
</form>
</body>
</html>