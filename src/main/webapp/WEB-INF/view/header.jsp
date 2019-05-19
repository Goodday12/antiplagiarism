<%@ page import="org.springframework.security.authentication.AnonymousAuthenticationToken" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Antiplagiarism</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">Page 1</a></li>
            <li><a href="#">Page 2</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
                <%
                    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                    System.out.println(authentication);
                    if (!(authentication instanceof AnonymousAuthenticationToken)) {
                        String currentUserName = authentication.getName();
                        out.print("<li><a>You are currently logged in as " + currentUserName + "</li></a>" +
                                "<li><a href=\"/logout\"><span class=\"glyphicon glyphicon-log-in\"></span> Logout</a></li>");
                    }
                    else {
                        out.print("<li><a href=\"/registration\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li>\n" +
                                "            <li><a href=\"/login\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>");
                    }
                %>
        </ul>
    </div>
</nav>
