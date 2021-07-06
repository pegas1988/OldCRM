<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="material" type="entity.Material"--%>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 13.06.2021
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DeleteMaterialPage</title>
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
    <center>
        <div class="container m-3">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Type</th>
                    <th scope="col">Colour</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <c:forEach items="${list}" var="material">
                <tr>
                    <td><c:out value="${material.materialName}"/></td>
                    <td><c:out value="${material.type}"/></td>
                    <td><c:out value="${material.colour}"/></td>
                    <td><c:out value="${material.price}"/></td>
                    <td><c:out value="${material.quantity}"/></td>
                    <td>
                        <form method="post">
                            <div class="d-grid gap-2">
                                <input type="hidden" name="materialName" value="${material.materialName}">
                                <input type="hidden" name="type" value="${material.type}">
                                <input type="hidden" name="colour" value="${material.colour}">
                                <input type="hidden" name="price" value="${material.price}">
                                <input type="hidden" name="quantity" value="${material.quantity}">
                                <button name="Submit" type="Submit" class="btn btn-secondary">
                                    Update
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
</body>
</html>
