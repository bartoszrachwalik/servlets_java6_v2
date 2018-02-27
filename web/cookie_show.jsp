<%@ page import="org.sda.util.Constans" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
Cookie[] tabcookie = request.getCookies();
if(tabcookie != null) {
    for (Cookie cookie : tabcookie) {
        if (cookie.getName().equals(Constans.COOKIE_NAME))
            out.println(cookie.getValue());
    }
}
%>

${cookie.language.value}

</body>
</html>
