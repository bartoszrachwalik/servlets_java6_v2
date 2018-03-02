<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="language_header.jsp"%>
<%--<a href="add_item.jsp?langx=pl_PL">PL</a>--%>
<%--<a href="add_item.jsp?langx=en_US">EN</a>--%>

<%--<fmt:setLocale value="${param.langx}" />--%>
<%--<fmt:setBundle basename="labels" />--%>

<fmt:message key="add.product" />:
<form action="add_item.jsp">
    <input type="text" name="item">
    <input type="submit" value="Wyślij">
</form>

<%
    List<String> items = (List<String>) session.getAttribute("items");
    if(items == null){
        items = new ArrayList<>();
        session.setAttribute("items", items);
//        pageContext.setAttribute("items", items);
//        application.setAttribute("items", items);
    }

    String item = request.getParameter("item");
    if(item != null && !item.equals("")) {
        items.add(item);
    }

    out.println("<ul>");
    for(String s : items){
        out.println("<li>" + s + "</li>");
    }
    out.println("</ul>");
%>

</body>
</html>
