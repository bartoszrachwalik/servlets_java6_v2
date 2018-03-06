<fmt:requestEncoding value = "UTF-8" />

<c:set var="language" value="${not empty param.lang ? param.lang : language }" scope="session" />
<fmt:setLocale value="${language}"/>

<fmt:setBundle basename="labels" />

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/users"><fmt:message key="menu.users"/> <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="/pages/registration.jsp">Rejestracja <span class="sr-only">(current)</span></a>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Languages</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="${requestScope['javax.servlet.forward.request_uri']}${"?lang=pl_PL"}">PL </a>
                    <a class="dropdown-item" href="${requestScope['javax.servlet.forward.request_uri']}${"?lang=en_US"}">EN </a>
                    <a class="dropdown-item" href="#">Example</a>
                </div>
            </li>
        </ul>
    </div>
</nav>



