<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<link href="css/style.css" rel="stylesheet">
<form action="action_page.php" style="border:1px solid #ccc">
    <div class="container">
        <h1>Welcome back!</h1>
        <p>Please fill this form to get in</p>
        <hr>

        <input type="text" placeholder="Enter FirstName" name="firstName" required>

        <input type="text" placeholder="Enter LastName" name="lastName" required>

        <input type="password" placeholder="Enter Password" name="psw" required>


        <div class="clearfix">

            <button type="submit" class="signupbtn">Sign in</button>
        </div>
    </div>
</form>
</body>
</html>