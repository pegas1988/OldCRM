<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@ variable id="user" type="\servlet\ShowListOfUsersServlet" --%>
<html>
<head>
    <title>List of all users </title>
</head>
<body>

<table border="1" cellpadding="5">
    <caption><h2>List of users</h2></caption>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>LastName</th>
        <th>Password</th>
        <th>UserRole</th>
        <th>Email</th>
    </tr>
    <c:forEach items="${list}" var="name">
        <tr>
            <td><c:out value="${name.userID}" /></td>
            <td><c:out value="${name.firstName}" /></td>
            <td><c:out value="${name.lastName}" /></td>
            <td><c:out value="${name.password}" /></td>
            <td><c:out value="${name.userRole}" /></td>
            <td><c:out value="${name.email}" /></td>
        </tr>
    </c:forEach>
</table>
<button onclick="window.location.href='/CRM_war/CRM_war/login';">
    Back to login </button>
</body>
</html>