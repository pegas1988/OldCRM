<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="user" type="D:\MyApps\CRM\src\main\java\entity\User.java"--%>
<html>
<head>
    <title>Profile </title>
</head>
<body>
<p>Id : ${user.userID}</p>
<p>Name : ${user.firstname}</p>
<p>LastName : ${user.lastName}</p>
<p>Password : ${user.password}</p>
<p>UserRole : ${user.userRole}</p>
</body>
</html>