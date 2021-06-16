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

<center>
    <h2>Choose the option, Master:</h2>

    <div class="card m-3" style="width: 18rem;">
        <img src="icons/users.png" class="card-img-top" alt="users">
        <div class="card-body">
            <h5 class="card-title">Users</h5>
            <p class="card-text">Created, Update, Delete user. See list of all users</p>
            <a href="/CRM_war/add" class="btn btn-primary">Choose the option</a>
        </div>
    </div>
    <div class="card m-3" style="width: 18rem;">
        <img src="icons/materials.png" class="card-img-top" alt="Card image">
        <div class="card-body">
            <h5 class="card-title">Materials</h5>
            <p class="card-text">Created, Update, Delete material. See list of all materials</p>
            <a href="icons/bird.jpg" class="btn btn-primary">Choose the option</a>
        </div>
    </div>
    <div class="card m-3" style="width: 18rem;">
        <img src="D:\MyApps\CRM\src\main\resources\icons\products" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">Products</h5>
            <p class="card-text">Created, Update, Delete product. See list of all products</p>
            <a href="/CRM_war/addProduct" class="btn btn-primary">Choose the option</a>
        </div>
    </div>
    <div class="card m-3" style="width: 18rem;">
        <img src="D:\MyApps\CRM\src\main\resources\icons\leads.png" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">User work</h5>
            <p class="card-text">Created, Update, Delete lead. See list of all leads</p>
            <a href="/CRM_war/addLead" class="btn btn-primary">Choose the option</a>
        </div>
    </div>


</center>
</form>
</body>
</html>
