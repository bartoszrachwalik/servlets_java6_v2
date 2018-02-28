<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="org.sda.dto.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
1. Stworzyć listę studentów (w skryplecie)
2. Dodać ją do pageContex (albo do sesji/application)
3. Wyświetlić studentów w tabelce używająć tagu forEach
3.1 wersja w javie (skryplet)

<%
    List<Student> students = new ArrayList<>();
    students.add(new Student("Jan Kowalski", "jk@gmail.com", true));
    students.add(new Student("Lenny Linux", "ll@gmail.com", true));
    students.add(new Student("Scala Johansson", "sj@gmail.com", false));

    application.setAttribute("students", students);
%>

<table>
    <tr>
        <th>Imie i Nazwisko</th>
        <th>Email</th>
        <th>Obecność</th>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${fn:toUpperCase(student.getName())}</td>
            <td>${student.email}</td>
            <td>
                <c:if test="${student.present}">
                    Obecny
                </c:if>
                <c:if test="${not student.present}">
                    Nieobecny
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
