<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add course</title>
</head>
<body>
<form action="/addcourse" method="post">
    Course name: <input type="text" name="name" value="${course.name}">
</form>

</body>
</html>
