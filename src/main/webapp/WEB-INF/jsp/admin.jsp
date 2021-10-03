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
                         height="200" fill="currentColor" class="bi bi-people" viewBox="0 0 16 16">
                        <path d="M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1h8zm-7.978-1A.261.261 0 0 1 7 12.996c.001-.264.167-1.03.76-1.72C8.312 10.629 9.282 10 11 10c1.717 0 2.687.63 3.24 1.276.593.69.758 1.457.76 1.72l-.008.002a.274.274 0 0 1-.014.002H7.022zM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0zM6.936 9.28a5.88 5.88 0 0 0-1.23-.247A7.35 7.35 0 0 0 5 9c-4 0-5 3-5 4 0 .667.333 1 1 1h4.216A2.238 2.238 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816zM4.92 10A5.493 5.493 0 0 0 4 13H1c0-.26.164-1.03.76-1.724.545-.636 1.492-1.256 3.16-1.275zM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0zm3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4z"/>
                    </svg>
                </center>
                <div class="card-body">
                    <h5 class="card-title">Users</h5>
                    <a href="/CRM_war/add" style="width: 6rem;" class="btn btn-secondary m-1">Create</a>
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
                         height="200" fill="currentColor" class="bi bi-bricks" viewBox="0 0 16 16">
                        <path d="M0 .5A.5.5 0 0 1 .5 0h15a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-.5.5H14v2h1.5a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-.5.5H14v2h1.5a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-.5.5H.5a.5.5 0 0 1-.5-.5v-3a.5.5 0 0 1 .5-.5H2v-2H.5a.5.5 0 0 1-.5-.5v-3A.5.5 0 0 1 .5 6H2V4H.5a.5.5 0 0 1-.5-.5v-3zM3 4v2h4.5V4H3zm5.5 0v2H13V4H8.5zM3 10v2h4.5v-2H3zm5.5 0v2H13v-2H8.5zM1 1v2h3.5V1H1zm4.5 0v2h5V1h-5zm6 0v2H15V1h-3.5zM1 7v2h3.5V7H1zm4.5 0v2h5V7h-5zm6 0v2H15V7h-3.5zM1 13v2h3.5v-2H1zm4.5 0v2h5v-2h-5zm6 0v2H15v-2h-3.5z"/>
                    </svg>
                </center>
                <div class="card-body">
                    <h5 class="card-title">Materials</h5>
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
        <div class="col-sm-3">
            <div class="card m-3 mt-5" style="width: 18rem;">
                <center>
                    <svg xmlns="http://www.w3.org/2000/svg" style="font-size: 2rem; color: cornflowerblue;" width="200"
                         height="200" fill="currentColor" class="bi bi-basket3" viewBox="0 0 16 16">
                        <path d="M5.757 1.071a.5.5 0 0 1 .172.686L3.383 6h9.234L10.07 1.757a.5.5 0 1 1 .858-.514L13.783 6H15.5a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5H.5a.5.5 0 0 1-.5-.5v-1A.5.5 0 0 1 .5 6h1.717L5.07 1.243a.5.5 0 0 1 .686-.172zM3.394 15l-1.48-6h-.97l1.525 6.426a.75.75 0 0 0 .729.574h9.606a.75.75 0 0 0 .73-.574L15.056 9h-.972l-1.479 6h-9.21z"/>
                    </svg>
                </center>
                <div class="card-body">
                    <h5 class="card-title">Products</h5>
                    <a href="/CRM_war/CRM_war/productAdd" style="width: 6rem;" class="btn btn-secondary m-1">Create</a>
                    <a href="/CRM_war/CRM_war/updateProduct" style="width: 6rem;" class="btn btn-secondary m-1">Update</a>
                    <a href="/CRM_war/CRM_war/deleteProduct" style="width: 6rem;" class="btn btn-secondary m-1">Delete</a>
                    <a href="/CRM_war/CRM_war/listOfProducts" style="width: 6rem;" class="btn btn-secondary m-1">See
                        all</a>
                </div>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="card m-3 mt-5" style="width: 18rem;">
                <center>
                    <svg xmlns="http://www.w3.org/2000/svg" style="font-size: 2rem; color: cornflowerblue;" width="200"
                         height="200" fill="currentColor" class="bi bi-archive" viewBox="0 0 16 16">
                        <path d="M0 2a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1v7.5a2.5 2.5 0 0 1-2.5 2.5h-9A2.5 2.5 0 0 1 1 12.5V5a1 1 0 0 1-1-1V2zm2 3v7.5A1.5 1.5 0 0 0 3.5 14h9a1.5 1.5 0 0 0 1.5-1.5V5H2zm13-3H1v2h14V2zM5 7.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z"/>
                    </svg>
                </center>
                <div class="card-body">
                    <h5 class="card-title">Leads</h5>
                    <a href="/CRM_war/CRM_war/createClient" style="width: 6rem;" class="btn btn-secondary m-1">Creat</a>
                    <a href="/CRM_war/updateLead" style="width: 6rem;" class="btn btn-secondary m-1">Update</a>
                    <a href="/CRM_war/deleteLead" style="width: 6rem;" class="btn btn-secondary m-1">Delete</a>
                    <a href="/CRM_war/CRM_war/listOfOrders" style="width: 6rem;" class="btn btn-secondary m-1">See all</a>
                </div>
            </div>
        </div>
    </div>


</center>
</form>
</body>
</html>
