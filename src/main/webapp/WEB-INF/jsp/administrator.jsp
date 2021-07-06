<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 14.06.2021
  Time: 23:18
  To change this template use File | Settings | File Templates.
    --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GOD_Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%@include file="patterns/navbar.jsp" %>
<center>
    <div class="row">
        <div class="col-sm-3">
            <div class="card m-3 mt-5" style="width: 18rem;">
                <center>
                    <svg xmlns="http://www.w3.org/2000/svg" style="font-size: 2rem; color: cornflowerblue;" width="200"
                         height="200" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                        <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                        <path fill-rule="evenodd"
                              d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                    </svg>
                </center>
                <div class="card-body">
                    <h5 class="card-title">Client</h5>
                    <a href="/CRM_war/CRM_war/createClient" style="width: 6rem;"
                       class="btn btn-secondary m-1">Create</a>
                    <a href="/CRM_war/CRM_war/updateUser" style="width: 6rem;" class="btn btn-secondary m-1">Update</a>
                    <a href="/CRM_war/CRM_war/userdelete" style="width: 6rem;" class="btn btn-secondary m-1">Delete</a>
                    <a href="/CRM_war/list" style="width: 6rem;" class="btn btn-secondary m-1">See all</a>
                </div>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="card m-3 mt-5" style="width: 18rem;">
                <center>
                    <svg xmlns="http://www.w3.org/2000/svg" style="font-size: 2rem; color: cornflowerblue;" width="200"
                         height="200" fill="currentColor" class="bi bi-currency-dollar" viewBox="0 0 16 16">
                        <path d="M4 10.781c.148 1.667 1.513 2.85 3.591 3.003V15h1.043v-1.216c2.27-.179 3.678-1.438 3.678-3.3 0-1.59-.947-2.51-2.956-3.028l-.722-.187V3.467c1.122.11 1.879.714 2.07 1.616h1.47c-.166-1.6-1.54-2.748-3.54-2.875V1H7.591v1.233c-1.939.23-3.27 1.472-3.27 3.156 0 1.454.966 2.483 2.661 2.917l.61.162v4.031c-1.149-.17-1.94-.8-2.131-1.718H4zm3.391-3.836c-1.043-.263-1.6-.825-1.6-1.616 0-.944.704-1.641 1.8-1.828v3.495l-.2-.05zm1.591 1.872c1.287.323 1.852.859 1.852 1.769 0 1.097-.826 1.828-2.2 1.939V8.73l.348.086z"/>
                    </svg>
                </center>
                <div class="card-body">
                    <h5 class="card-title">Order</h5>
                    <a href="/CRM_war/CRM_war/createMaterial" style="width: 6rem;"
                       class="btn btn-secondary m-1">Create</a>
                    <a href="/CRM_war/CRM_war/updateMaterial" style="width: 6rem;"
                       class="btn btn-secondary m-1">Update</a>
                    <a href="/CRM_war/CRM_war/deleteMaterial" style="width: 6rem;"
                       class="btn btn-secondary m-1">Delete</a>
                    <a href="/CRM_war/CRM_war/seeAllMaterials" style="width: 6rem;" class="btn btn-secondary m-1">See
                        all</a>
                </div>
            </div>
        </div>
    </div>
</center>
</form>
</body>
</html>
