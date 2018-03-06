<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="head.html" %>
</head>
<body>

<%@include file="menu.jsp" %>

<div class="container">

    <table class="table table-striped">
        <tr>
            <th><fmt:message key="users.table.headers.firstname"/></th>
            <th><fmt:message key="users.table.headers.lastname"/></th>
            <th><fmt:message key="users.table.headers.email"/></th>
            <th><fmt:message key="users.table.headers.delete"/></th>
            <th><fmt:message key="users.table.headers.edit"/></th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr scope="row">
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>
                    <form action="/deleteuser" method="post">
                        <input class="btn btn-danger" type="submit" value="<fmt:message key="users.table.headers.delete"/>">
                        <input type="hidden" name="id" value="${user.id}">
                    </form>
                </td>
                <td>
                    <form action="/getuserdata" method="get">
                        <input class="btn btn-warning" type="submit" value="<fmt:message key="users.table.headers.edit"/>">
                        <input type="hidden" name="id" value="${user.id}">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
