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
            <h1>New poshta API</h1>
            <p class="text-primary">Please fill this form to get delivery status</p>
        </center>

        <div class="mb-3">
            <label for="exampleInputName" class="form-label">Phone</label>
            <input type="text" class="form-control" id="exampleInputName" placeholder="Enter your phone number"
                   name="phoneNumber" required>
        </div>

        <div class="mb-3">
            <label for="exampleInputLastName" class="form-label">TTN</label>
            <input type="text" class="form-control" id="exampleInputLastName" placeholder="Enter TTN"
                   name="ttnNumber" required>
        </div>
        <div class="d-grid gap-2">
            <button name="Submit" value="Login" type="Submit" class="btn btn-secondary">Submit</button>
            </button>
        </div>
    </div>
    </div>
</form>
</body>
</html>