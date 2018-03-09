<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<tr>
    <th>Course name</th>
    <th>Add review</th>
    <th>Show review</th>
    <th>Show average</th>

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
