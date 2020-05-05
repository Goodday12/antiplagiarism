<jsp:include page="header.jsp"/>

<div class="container">
    <form action="/sendFile" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="exampleFormControlFile1">Load your file here</label>
            <input name="file" type="file" class="form-control-file" id="exampleFormControlFile1">
            <input type="submit">
        </div>
    </form>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
