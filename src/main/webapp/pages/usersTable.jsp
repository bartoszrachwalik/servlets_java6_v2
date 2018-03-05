<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <th>Imie</th>
        <th>Nazwisko</th>
        <th>Email</th>
        <th>Akcje</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>
                <form action="/deleteuser" method="post">
                    <input type="submit" value="remove">
                    <input type="hidden" name="id" value="${user.id}">
                </form>
                <form action="/getuserdata" method="get">
                    <input type="submit" value="edit">
                    <input type="hidden" name="id" value="${user.id}">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
