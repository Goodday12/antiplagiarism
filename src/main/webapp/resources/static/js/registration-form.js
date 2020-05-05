function validate() {
    console.log($("#login").val());
    if ($("#username").val() === "" ||
        $("#password").val() === "" ||
        $("#password_confirmation").val() === "" ||
        $("#login").val() === "" ||
        $("#email").val() === ""
    ) {
        $("#modalW").append("<div class=\"alert alert-warning alert-dismissible\" >\n" +
            "<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
            "<strong>Attention!</strong> Fill in all required fields" +
            "<div>");
        return false;
    }
    if ($("#password").val() !== $("#password_confirmation").val()) {
        $("#modalW").append("<div class=\"alert alert-warning alert-dismissible\" >\n" +
            "<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
            "<strong>Attention!</strong> Passwords should match" +
            "<div>");
        return false;
    }
    if (!/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}/g.test($("#email").val())) {
        $("#modalW").append("<div class=\"alert alert-warning alert-dismissible\" >\n" +
            "<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
            "<strong>Attention!</strong> Check out your mail" +
            "<div>");
        return false;
    }
    //TODO append when 200
    $("#modalW").append("<div class=\"alert success-warning alert-dismissible\" >\n" +
        "<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
        "<strong>Attention!</strong> Successfully" +
        "<div>");
    return true;
}

$("#saveBtn").click(function () {
    console.log(validate());
});
