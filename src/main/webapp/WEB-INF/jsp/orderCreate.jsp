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
            <p class="text-primary">Please fill this form to create an Order</p>
        </center>

        <div class="mb-3">
            <label for="exampleInputName" class="form-label">First Name</label>
            <input type="text" class="form-control" id="exampleInputName" placeholder="Enter FirstName"
                   name="clientFirstName" required>
        </div>

        <div class="mb-3">
            <label for="exampleInputLastName" class="form-label">LastName</label>
            <input type="text" class="form-control" id="exampleInputLastName" placeholder="Enter LastName"
                   name="clientLastName" required>
        </div>
        <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" name="comment" rows="3"></textarea>
        </div>
        <select class="form-select mb-2" name="productOne">
            <c:forEach var="dd" items="${list}">
                <option><c:set var="d" value="${dd}"/><c:out value="${d}"/></option>
            </c:forEach>
        </select>
        <select class="form-select mb-2" name="productTwo">
            <c:forEach var="dd" items="${list}">
                <option><c:set var="d" value="${dd}"/><c:out value="${d}"/></option>
            </c:forEach>
        </select>
        <div class="d-grid gap-2">
            <button name="Submit" value="Login" type="Submit" class="btn btn-secondary">Create order</button>
            </button>
        </div>
    </div>
</form>
</body>
</html>