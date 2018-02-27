<%@ page import="org.sda.util.Constans" %><%--
  Created by IntelliJ IDEA.
  User: krzysztof.gonia
  Date: 2/27/2018
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    String newselect = request.getParameter("language");
    Cookie newCookie = new Cookie(Constans.COOKIE_NAME, newselect);
    newCookie.setMaxAge(60*60*24*365);
    response.addCookie(newCookie);
%>

${param.language}
<body>

</body>
</html>
