<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.GrantedAuthority" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="java.util.Collection" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page isELIgnored="false" %>
<jsp:include page="header.jsp"/>

<div class="container">

    <form action="<%
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        boolean isTeacher = false;
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_TEACHER")) {
                out.print("/teacher-check");
                isTeacher = true;
                break;
            }
            else {
                out.print("/check");
            }
        }
    %>" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="exampleFormControlFile1">Example file input</label>
            <input name="file" type="file" class="form-control-file" id="exampleFormControlFile1">
            <input type="submit">
        </div>
    </form>
    <div class="row">

        <c:if test="${plag != null}">
            <p>Your code scored ${plag}</p>
        </c:if>
    </div>
    <%
        if (isTeacher) {
            out.println("<div id=\"codeComp\" class=\"row\">\n" +

                    "</div>");
        }
    %>
</div>
<c:if test="${obj != null}">


    <%
        if (isTeacher) {
            out.print("<script src=\"/resources/static/js/checkerCode.js\">" +
                    "var = ${obj}</script>");
        }
    %>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/js-beautify/1.10.0/beautify.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/js-beautify/1.10.0/beautify-css.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/js-beautify/1.10.0/beautify-html.js"></script>
    <script>
        let somth = ${obj};
        // console.log(somth);
        f(somth);
        // hljs.initHighlighting.called = false;
        // hljs.initHighlighting();
    </script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/styles/androidstudio.css">
    <script src="${pageContext.request.contextPath}/resources/static/js/highlight.pack.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</c:if>
<jsp:include page="footer.jsp"/>
</body>
</html>
