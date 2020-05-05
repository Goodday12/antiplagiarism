<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/index">Antiplagiarism</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/load-file">Load your code</a></li>
            <li><a href="/code-checker">Check your code</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <%--                <%--%>
            <%--                    if (!(authentication instanceof AnonymousAuthenticationToken)) {--%>
            <%--                        String currentUserName = authentication.getName();--%>
            <%--                        out.print("<li><a>You are currently logged in as " + currentUserName + "</li></a>" +--%>
            <%--                                "<li><a href=\"/logout\"><span class=\"glyphicon glyphicon-log-in\"></span> Logout</a></li>");--%>
            <%--                    }--%>
            <%--                    else {--%>
            <%--                        out.print("<li><a href=\"/registration\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li>\n" +--%>
            <%--                                "            <li><a href=\"/login\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>");--%>
            <%--                    }--%>
            <%--                %>--%>
            <li><a style="cursor: pointer" data-toggle="modal" data-target="#modalRegistration"><span
                    class="glyphicon glyphicon-user\"></span> Sign Up</a></li>
            <li><a style="cursor: pointer" data-toggle="modal" data-target="#modalLogin"><span
                    class="glyphicon glyphicon-log-in"></span> Login</a></li>
            ");
        </ul>
    </div>
</nav>
<jsp:include page="modalLogin.jsp"/>
<jsp:include page="modalRegistration.jsp"/>