<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%@include file="patterns/navbar.jsp" %>
<center>
    <form class="row g-3 m-3 needs-validation" method="post" novalidate>
        <div class="col-sm-3">
            <label for="validationCustom01" class="form-label">First name</label>
            <input type="text" class="form-control" id="validationCustom01" name="clientName" required>
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>
        <div class="col-md-4">
            <label for="validationCustom02" class="form-label">Last name</label>
            <input type="text" class="form-control" id="validationCustom02" name="clientLastName" required>
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>
        <div class="col-md-4">
            <label for="validationCustomUsername" class="form-label">Gender</label>
            <div class="input-group has-validation">
                <input type="text" class="form-control" id="validationCustomUsername"
                       aria-describedby="inputGroupPrepend" name="gender" required>
                <div class="invalid-feedback">
                    Please choose a username.
                </div>
            </div>
        </div>
        <div class="col-12">
            <input type="hidden" class="form-control" value = "addClient" id="exampleInputName" name="addClient"
                   required>
            <button class="btn btn-outline-secondary" name= "ifClientWasCreated" value="ifClientWasCreated" type="submit">Create</button>
        </div>
    </form>
    <form method="post">
        <center>
            <div class="container m-3">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col">ClientName</th>
                        <th scope="col">ClientLastName</th>
                        <th scope="col">Gender</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <c:forEach items="${clientList}" var="client">
                    <tr>
                        <td><c:out value="${client.firstName}"/></td>
                        <td><c:out value="${client.lastName}"/></td>
                        <td><c:out value="${client.sex}"/></td>
                        <td>
                            <form method="post">
                                <div class="d-grid gap-2">
                                    <input type="hidden" name="clientFirstName" value="${client.firstName}">
                                    <input type="hidden" name="clientLastName" value="${client.lastName}">
                                    <input type="hidden" name="gender" value="${client.sex}">
                                    <button name="Submit" type="Submit" class="btn btn-secondary">
                                        UseIt
                                    </button>
                                </div>
                            </form>
                        </td>
                    </tr>
                    </c:forEach>
                    </tr>
                    </tbody>
                </table>
            </div>
        </center>
    </form>
</center>
</body>
</html>