<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="test.txt" %>
</head>
<body>
<div class="container">
    <div class="alert alert-success" role="alert">...</div>
    <div class="alert alert-info" role="alert">...</div>
    <div class="alert alert-warning" role="alert">...</div>
    <div class="alert alert-danger" role="alert">...</div>
</div>

<%! String toUpperCase(String s) {
    return s.toUpperCase();
}
%>

<%-- TODO Hello World i aktualna godzina--%>
<h1><%=toUpperCase("Hallo World")%>
</h1>
<br>
<%= LocalDateTime.now()%>
<br>
<%--TODO Deklaracje--%>
Aktualna data to: <% out.print(LocalDate.now()); %>
<br/>
25 razy 4 to:
<% out.print(25 * 4);%>
<br/>
Czy 50 jest mniejsze od 21?
<% out.println(50 < 21);%>
<br/>

<%--TODO zmienne zdefiniowane--%>
Przeglądarka użytkonika: <%= request.getHeader("User-Agent") %>
<br/>
Język zapytania: <%= request.getLocale() %>
<br/>
Lista wszystkich nagłówków zapytania:
<% Enumeration<String> e = request.getHeaderNames();
    out.println("<ul>");
    while (e.hasMoreElements()) {
        String header = e.nextElement();
        out.println("<li>");
        out.println(header);
        out.println(":");
        out.println(request.getHeader(header));
        out.println("</li>");

    }
    out.println("</ul>");
%>

<ul>
    <li>one</li>
    <li>two</li>
</ul>

<%@include file="footer.jsp" %>
</body>
</html>
