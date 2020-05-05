<div class="modal fade" id="modalRegistration" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Registration form</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="panel-body" id="modalW">
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="first_name" id="first_name"
                                       class="form-control input-sm" placeholder="First Name"
                                       autocomplete="off">
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="last_name" id="last_name" class="form-control input-sm"
                                       placeholder="Last Name" autocomplete="off">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <input type="email" name="email" id="email" class="form-control input-sm"
                               placeholder="Email Address" autocomplete="off">
                    </div>

                    <div class="form-group">
                        <input type="text" name="login" id="usernameRegistration" class="form-control input-sm"
                               placeholder="Login" autocomplete="off">
                    </div>


                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="password" name="password" id="password"
                                       class="form-control input-sm" placeholder="Password">
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="password" name="password_confirmation" id="password_confirmation"
                                       class="form-control input-sm" placeholder="Confirm Password">
                            </div>
                        </div>
                    </div>

                    <div class="form-group" align="center">
                        <label>
                            <select class="form-control">
                                <option SELECTED value="Student">Student</option>
                                <option value="Teacher">Teacher</option>
                            </select>
                        </label>
                    </div>

                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="saveBtn">Save</button>
            </div>
        </div>
    </div>
</div>