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
            <p class="text-primary">Please choose the product you need</p>
        </center>
    </div>
    <select class="form-select mb-2" name="productOne">
        <c:forEach var="dd" items="${list}">
            <option><c:set var="d" value="${dd}"/><c:out value="${d.productName}"/></option>
        </c:forEach>
    </select>
    <div class="d-grid gap-2">
        <input type="hidden" class="form-control" value = "add" id="exampleInputName" name="keyAdd"
               required>
        <button name="KeyAdd" value="keyAdd" type="Submit" class="btn btn-secondary">Add product</button>
        </button>
    </div>

</form>
<form method="post">
    <div class="d-grid gap-2">
        <input type="hidden" class="form-control" value = "proceed" name="keyProceed"
               required>
        <button name="KeyProceed" value="KeyProceed" type="Submit" class="btn btn-secondary">Proceed with order</button>
        </button>
    </div>
    </div>
</form>
</body>
</html>