<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@ variable id="user" type="D:\MyApps\CRM\src\main\java\entity\User.java" --%>
<html>
<head>
    <title>List of all users </title>
</head>
<body>

<table>
    <c:forEach items="${list}" var="item">
        <tr>
            <td><c:out value="${item}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>