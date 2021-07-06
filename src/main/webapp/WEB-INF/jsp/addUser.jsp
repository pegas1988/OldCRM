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
                <h1>Add a new User!</h1>
                <p class="text-white-50">Please fill in this form to create a new User</p>
            </center>
        </div>
        <div class="mb-3">
            <label for="exampleInputName" class="form-label">First Name</label>
            <input type="text" class="form-control" id="exampleInputName" placeholder="Enter FirstName" name="firstName"
                   required>
        </div>

        <div class="mb-3">
            <label for="exampleInputLastName" class="form-label">Last Name</label>
            <input type="text" class="form-control" id="exampleInputLastName" placeholder="Enter LastName"
                   name="lastName" required>
        </div>

        <div class="mb-3">
            <label for="exampleInputEmail" class="form-label">Email address</label>
            <input type="text" class="form-control" id="exampleInputEmail" placeholder="Enter Email" name="email"
                   required>
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>

        <!--
        <div class="mb-3">
            <label class="form-label">UserRole</label>
            <input type="text" class="form-control" placeholder="Enter userRole" name="userRole" required>
        </div>
        -->


        <select class="form-select" aria-label="Choose the role" id="userRole" name="userRole">
            <option selected>Click here to show the list of roles</option>
            <option value="DOCTOR">The Doctor</option>
            <option value="MASTER">The Master</option>
            <option value="DESIGNER">The Designer</option>
            <option value="ADMIN">The GOD</option>
            <option value="ADMINISTRATOR">Administrator</option>
        </select>


        <div class="mb-3">
            <label class="form-label">Password</label>
            <input type="password" class="form-control" placeholder="Enter Password" name="psw" required>
        </div>

        <div class="d-grid gap-2">
            <button type="button" class="btn btn-secondary">Cancel</button>
            <button type="submit" class="btn btn-outline-secondary">Create</button>
            <button type="button" class="btn btn-secondary" onclick="window.location.href='/CRM_war/list';">
                See list of users
            </button>
        </div>

    </div>
</form>
<!-- </center> -->
</body>
</html>