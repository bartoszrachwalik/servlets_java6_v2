<%--
  Created by IntelliJ IDEA.
  User: krzysztof.gonia
  Date: 3/5/2018
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/updateuser" method="post">
    Imie: <input type="text" name="firstName" placeholder="Imie" value="${user.firstName}">
    <input type="text" name="lastName" value="${user.lastName}">
    <input type="email" name="email" value="${user.email}">
    <input type="hidden" name="id" value="${user.id}">
    <input type="submit" value="Submit">
</form>
</body>
</html>
