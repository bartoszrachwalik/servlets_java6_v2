<fmt:requestEncoding value = "UTF-8" />

<c:set var="language" value="${not empty param.lang ? param.lang : language }" scope="session" />
<fmt:setLocale value="${language}"/>

<fmt:setBundle basename="labels" />

<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><fmt:message key="menu.users"/></a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/users"><fmt:message key="menu.display"/></a>
                    <a class="dropdown-item" href="/pages/registration.jsp"><fmt:message key="menu.register"/></a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><fmt:message key="menu.courses"/></a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/courses"><fmt:message key="menu.display"/></a>
                    <a class="dropdown-item" href="/pages/addcourse.jsp"><fmt:message key="menu.add"/></a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><fmt:message key="menu.language"/></a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="${requestScope['javax.servlet.forward.request_uri']}${"?lang=pl_PL"}">PL </a>
                    <a class="dropdown-item" href="${requestScope['javax.servlet.forward.request_uri']}${"?lang=en_US"}">EN </a>
                </div>
            </li>
        </ul>
    </div>
</nav>



