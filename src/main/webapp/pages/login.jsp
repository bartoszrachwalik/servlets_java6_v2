<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.html" %>
</head>
<body>

<%@include file="menu.jsp" %>

<form action="/userlogin" method="post">
    E-mail: <input type="text" name="email" required><br>
    Hasło:<input type="password" name="password" required><br>
    <input type="submit" value="Login">
</form>

</body>
</html>
