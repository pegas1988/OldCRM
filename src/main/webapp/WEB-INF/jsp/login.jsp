<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {box-sizing: border-box}
        input[type=text], input[type=password] {
            width: 50%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #ddd;
        }
        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        /* Set a style for all buttons */
        button {
            background-color: #04AA6D;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 25%;
            opacity: 0.9;
        }

        button:hover {
            opacity:1;
        }

        /* Extra styles for the cancel button */
        .cancelbtn {
            padding: 14px 20px;
            background-color: #f44336;
        }

        /* Float cancel and signup buttons and add an equal width */
        .cancelbtn, .signupbtn {

            width: 25%;
        }

        /* Add padding to container elements */
        .container {
            padding: 16px;
        }

        /* Clear floats */
        .clearfix::after {
            osition: absolute;
            left: 50%;
            margin: -25px 0 0 -25px;
            content: "";
            clear: both;
            display: table;
        }

        /* Change styles for cancel button and signup button on extra small screens */
        @media screen and (max-width: 300px) {
            .cancelbtn, .signupbtn {
                width: 25%;
            }
        }
    </style>
</head>
<body>
<center>
<form>
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
</center>
</body>
</html>