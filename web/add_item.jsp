<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Dodaj produkt:
<form action="add_item.jsp">
    <input type="text" name="item">
    <input type="submit" value="Wyślij">
</form>

<%
    List<String> items = (List<String>) session.getAttribute("items");
    if(items == null){
        items = new ArrayList<>();
        session.setAttribute("items", items);
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
