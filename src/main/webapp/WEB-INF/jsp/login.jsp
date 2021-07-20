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
        <center>
            <div class="col-sm-3">
                <div class="card m-3 mt-5" style="width: 18rem;">
                    <center>
                        <svg xmlns="http://www.w3.org/2000/svg" style="font-size: 2rem; color: cornflowerblue;"
                             width="200"
                             height="200" fill="currentColor" class="bi bi-people" viewBox="0 0 16 16">
                            <path d="M7 8a3.5 3.5 0 0 1 3.5 3.555.5.5 0 0 0 .624.492A1.503 1.503 0 0 1 13 13.5a1.5 1.5 0 0 1-1.5 1.5H3a2 2 0 1 1 .1-3.998.5.5 0 0 0 .51-.375A3.502 3.502 0 0 1 7 8zm4.473 3a4.5 4.5 0 0 0-8.72-.99A3 3 0 0 0 3 16h8.5a2.5 2.5 0 0 0 0-5h-.027z"/>
                            <path d="M10.5 1.5a.5.5 0 0 0-1 0v1a.5.5 0 0 0 1 0v-1zm3.743 1.964a.5.5 0 1 0-.707-.707l-.708.707a.5.5 0 0 0 .708.708l.707-.708zm-7.779-.707a.5.5 0 0 0-.707.707l.707.708a.5.5 0 1 0 .708-.708l-.708-.707zm1.734 3.374a2 2 0 1 1 3.296 2.198c.199.281.372.582.516.898a3 3 0 1 0-4.84-3.225c.352.011.696.055 1.028.129zm4.484 4.074c.6.215 1.125.59 1.522 1.072a.5.5 0 0 0 .039-.742l-.707-.707a.5.5 0 0 0-.854.377zM14.5 6.5a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1z"/>
                        </svg>
                    </center>
                    <div class="card-body">
                        <h5 class="card-title">Users</h5>
                        <a href="/CRM_war/CRM_war/weather" style="width: 6rem;" class="btn btn-secondary m-1">Check the
                            weather now</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="card m-3 mt-5" style="width: 18rem;">
                    <center>
                        <svg xmlns="http://www.w3.org/2000/svg" style="font-size: 2rem; color: cornflowerblue;"
                             width="200"
                             height="200" fill="currentColor" class="bi bi-people" viewBox="0 0 16 16">
                            <path d="M4 4a3 3 0 0 0-3 3v6h6V7a3 3 0 0 0-3-3zm0-1h8a4 4 0 0 1 4 4v6a1 1 0 0 1-1 1H1a1 1 0 0 1-1-1V7a4 4 0 0 1 4-4zm2.646 1A3.99 3.99 0 0 1 8 7v6h7V7a3 3 0 0 0-3-3H6.646z"/>
                            <path d="M11.793 8.5H9v-1h5a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.354-.146l-.853-.854zM5 7c0 .552-.448 0-1 0s-1 .552-1 0a1 1 0 0 1 2 0z"/>
                        </svg>
                    </center>
                    <div class="card-body">
                        <h5 class="card-title">Users</h5>
                        <a href="/CRM_war/CRM_war/post" style="width: 6rem;" class="btn btn-secondary m-1">Check the
                            delivery status</a>
                    </div>
                </div>
            </div>
        </center>
    </div>
    </div>
</form>
</body>
</html>