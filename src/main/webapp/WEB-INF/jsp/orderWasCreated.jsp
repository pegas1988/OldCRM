<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Congratulations!</title>
</head>
<body>
<%@include file="patterns/navbar.jsp" %>
<h1>Order was created!</h1>
<p>If you wish to add new one, please push button "Create one more order"</p>
<button class="button btn btn-secondary btn-lg"
        onclick="window.location.href='/CRM_war/CRM_war/createClient';">
    Create on more order
</button>
</body>
</html>
