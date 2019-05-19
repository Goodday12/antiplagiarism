<%@ page import="org.springframework.security.authentication.AnonymousAuthenticationToken" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="com.development5053.antiplagiarism.model.entity.security.Authority" %>
<%@ page import="java.io.IOException" %>
<%@ page import="org.springframework.security.core.GrantedAuthority" %>
<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    System.out.println(authentication);
%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Antiplagiarism</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/index">Home</a></li>
            <li><a href="/code-checker">Check your code</a></li>
            <%
                    if (!(authentication instanceof AnonymousAuthenticationToken)) {
                        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                        for (GrantedAuthority authority : authorities) {
                            if (authority.getAuthority().equals("ROLE_TEACHER")) {
                                out.print("<li><a href=\"/statistic\">Lolkek</a></li>");
                                break;
                            }
                        }
                    }
            %>
        </ul>
        <ul class="nav navbar-nav navbar-right">
                <%
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
