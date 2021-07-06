<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginPage</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%@include file="patterns/navbar.jsp" %>
<form method="post">
    <div class="container mb-3 mt-3 w-50 p-3" style="background-color: #fff;">
        <center>
            <h1>Welcome back!</h1>
            <p class="text-primary">Please fill this form to get in</p>
        </center>

        <div class="mb-3">
            <label for="exampleInputName" class="form-label">First Name</label>
            <input type="text" class="form-control" id="exampleInputName" placeholder="Enter FirstName"
                   name="firstName" required>
        </div>

        <div class="mb-3">
            <label for="exampleInputLastName" class="form-label">LastName</label>
            <input type="text" class="form-control" id="exampleInputLastName" placeholder="Enter LastName"
                   name="lastName" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Password</label>
            <input type="password" class="form-control" placeholder="Enter Password" name="psw" required>
        </div>
        <div class="d-grid gap-2">
            <button name="Submit" value="Login" type="Submit" class="btn btn-secondary">Login</button>
            </button>
        </div>
    </div>
</form>
</body>
</html>