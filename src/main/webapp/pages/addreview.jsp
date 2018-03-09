<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add review</title>
</head>
<body>

<form action="addreview" method="post">
    Course rating: <input type="text" name="rating" value="${review.rating}">
    Description: <input type="text" name="description" value="${review.description}">
    <input type="hidden" name="id" value="${course.id}">
</form>

</body>
</html>
