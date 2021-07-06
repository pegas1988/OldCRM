<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 12.06.2021
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
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
<h1>Client was created!</h1>
<p>If you wish to add new one, please push button "Create one more client"</p>
<button class="button btn btn-secondary btn-lg" onclick="window.location.href='/CRM_war/CRM_war/createClient';">
    Create on more client
</button>
</body>
</html>
