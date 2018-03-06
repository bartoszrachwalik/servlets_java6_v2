<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/adduser">
    Imie: <input type="text" name="firstName" placeholder="Imie" required>
    <input type="text" name="lastName" required>
    <input type="email" name="email">
    <input type="submit" value="Submit">
</form>

</body>
</html>
