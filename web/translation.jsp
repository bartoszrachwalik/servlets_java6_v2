<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@include file="language_header.jsp"%>
<%--<a href="translation.jsp?langx=pl_PL">PL</a>--%>
<%--<a href="translation.jsp?langx=en_US">EN</a>--%>

<%--<fmt:setLocale value="${param.langx}" />--%>
<%--<fmt:setBundle basename="labels" />--%>

<fmt:message key="greetings" />



</body>
</html>
