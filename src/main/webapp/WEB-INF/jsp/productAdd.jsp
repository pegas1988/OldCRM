<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CreateProduct</title>
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
                <h1>Add new Product!</h1>
                <p class="text-white-50">Please fill in this form to create new Product</p>
            </center>
        </div>
        <div class="mb-3">
            <label for="exampleInputName" class="form-label">Product name</label>
            <input type="text" class="form-control" id="exampleInputName" placeholder="Enter name" name="productName"
                   required>
        </div>
        <SCRIPT language="javascript">
            function addRow(tableID) {

                var table = document.getElementById(tableID);

                var rowCount = table.rows.length;
                var row = table.insertRow(rowCount);

                var cell1 = row.insertCell(0);
                var element1 = document.createElement("input");
                element1.type = "checkbox";
                element1.name = "chkbox[]";
                cell1.appendChild(element1);

                var cell2 = row.insertCell(1);
                cell2.innerHTML = rowCount + 1;

                var cell3 = row.insertCell(2);
                var element2 = document.createElement("input");
                element2.type = "text";
                var length = (table.rows.length) - 1;
                element2.name = "operationParameterses[" + length + "].name";
                cell3.appendChild(element2);

            }

        </SCRIPT>
        <form:form commandName="user" action="lazyRowAdd.web" method="post">

            <fieldset>
                <legend>User details</legend>
                <ol>
                    <li>
                        <INPUT type="button" value="Add Row" onclick="addRow('dataTable')"/>
                        <TABLE id="dataTable" width="350px" border="1">
                            <TR>
                                <TD><INPUT type='text' name="operationParameterses[0].name"/></TD>
                            </TR>
                        </TABLE>
                    </li>

                </ol>
                <ol>
                    <c:forEach items="${user.operationParameterses}" var="value">
                        <li><c:out value="${value.name}"/></li>
                    </c:forEach>
                </ol>
            </fieldset>
        </form:form>
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