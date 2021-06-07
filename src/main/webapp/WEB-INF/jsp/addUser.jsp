<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<link href="css/style.css" rel="stylesheet">
<center>
<form method = "post">
    <div class="container">
        <h1>Add a new User!</h1>
        <p>Please fill in this form to create a new User.</p>
        <hr>

        <input type="text" placeholder="Enter FirstName" name="firstName" required>

        <input type="text" placeholder="Enter LastName" name="lastName" required>

        <input type="text" placeholder="Enter Email" name="email" required>

        <input type="text" placeholder="Enter userRole" name="userRole" required>


        <input type="password" placeholder="Enter Password" name="psw" required>


        <div style="text-align: center;">
        <div class="clearfix">
            <button type="button" class="cancelbtn">Cancel</button>
            <button type="submit" class="signupbtn">Create</button>
        </div>
        </div>
    </div>
</form>
</center>
</body>
</html>