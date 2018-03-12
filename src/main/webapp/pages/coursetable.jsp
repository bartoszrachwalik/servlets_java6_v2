<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display courses</title>
    <%@include file="head.html" %>
</head>
<body>

<%@include file="menu.jsp" %>

<tr>
    <th><fmt:message key="course.headers.name"/></th>
    <th><fmt:message key="course.headers.review"/></th>
    <th><fmt:message key="course.headers.display.review"/></th>
    <th><fmt:message key="course.headers.avgrating"/></th>

</tr>
<c:forEach items="${courses}" var="course">
    <tr scope="row">
        <td>${course.name}</td>
        <td>
            <form action="/showreview" method="post">
                <input class="btn btn-danger" type="submit" value="Show">
                <input type="hidden" name="id" value="${course.id}">
            </form>
        </td>
        <td>
            <form action="/addcourse" method="post">
                <input class="btn btn-warning" type="submit" value="Add">
                <input type="hidden" name="id" value="${course.id}">
            </form>
        </td>
        <td>
                ${average.get(course)}
        </td>
    </tr>
</c:forEach>

</body>
</html>
