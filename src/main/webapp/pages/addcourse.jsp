<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Add course</title>
    <%@include file="head.html" %>
</head>
<body>

<%@include file="menu.jsp" %>

<form action="/addcourse" method="post">
    <fmt:message key="course.headers.name"/>: <input type="text" name="name" value="${course.name}">
</form>

</body>
</html>