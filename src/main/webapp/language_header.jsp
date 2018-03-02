<a href="${requestScope['javax.servlet.forward.request_uri']}${"?lang=pl_PL"}">PL </a>
<br>
<a href="${requestScope['javax.servlet.forward.request_uri']}${"?lang=en_US"}">EN </a>
<br>

<fmt:setLocale value="${param.lang}" />

<fmt:setBundle basename="labels" />