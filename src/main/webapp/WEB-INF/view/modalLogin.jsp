<div class="modal fade" id="modalLogin" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Logination form</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row justify-content-center">
                    <div class="col-2 col-md-4 "></div>
                    <div class="col-8 col-md-4 align-self-center">
                        <div class="card">
                            <header class="card-header">
                                <h4 class="card-title mt-2">Log in</h4>
                            </header>
                            <article class="card-body">
                                <form action="/login" method="post">
                                    <div class="form-group">
                                        <label>Username</label>
                                        <input name="usernameLogin" type="text" class="form-control"
                                               placeholder="Type your login here" autocomplete="off"
                                               id="name">
                                    </div> <!-- form-group end.// -->
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input name="passwordLogin" class="form-control" type="password"
                                               placeholder="Type your password here" autocomplete="off"
                                               id="passwordLogin">
                                    </div> <!-- form-group end.// -->
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary btn-block" id="login"> Log in
                                        </button>
                                    </div> <!-- form-group// -->
                                </form>
                            </article> <!-- card-body end .// -->
                        </div> <!-- card.// -->
                    </div> <!-- col.//-->
                    <div class="col-2 col-md-4 "></div>

                </div> <!-- row.//-->
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script>

    $(document).ready(function () {

        $("#login").click(function (event) {

            event.preventDefault();


            console.log(name + " + " + password);

            $.ajax({
                type: "POST",
                url: "login",
                success: function (response) {

                    console.log(response);

                    if (response.status == 'FAIL') {
                        // showFormError(response.errorMessageList);
                    } else {
                        //everything is O.K. user logged in successfully.
                        $('#modalLogin').modal('hide');
                        window.location.reload();
                    }
                },
                error: function (ex) {
                    console.log(ex);
                }
            });


        });

    })

</script>
