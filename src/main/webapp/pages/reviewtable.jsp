<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<tr>
    <th>Review</th>
    <th>Rating</th>
</tr>

<c:forEach items="${reviews}" var="review">
    <tr scope="row">
        <td>${review.description}</td>
        <td>${review.rating}</td>
</c:forEach>

</body>
</html>