<!DOCTYPE html>
<html lang="zh">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>${title!'Full stack road-registration'}</title>

  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Full-Stack</div>
      <div class="card-body">
        <form id="id_user_register_form">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="id_username">Username</label>
                <input class="form-control" id="id_username" type="text" aria-describedby="nameHelp" placeholder="Enter Username" name="username">
              </div>
              <div class="col-md-6">
                <label for="id_nickname">Nickname</label>
                <input class="form-control" id="id_nickname" type="text" aria-describedby="nameHelp" placeholder="Enter Nickname" name="nickname">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="id_password">password</label>
                <input class="form-control" id="id_password" type="password" placeholder="Password" name="password">
              </div>
              <div class="col-md-6">
                <label for="id_confirm_password">Confirm Password</label>
                <input class="form-control" id="id_confirm_password" type="password" placeholder="Confirm password" name="confirmpassword">
              </div>
            </div>
          </div>
          <a id="id_user_register_submit" class="btn btn-primary btn-block" href="javascript:void(0);">REGISTER Now</a>
        </form>
        <div class="container text-center mt-3">
          <div class="row text-right">
            <a class="d-block small col-sm" href="userlogin">You have an account?Log in now</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <#-- Custom js -->
  <script src="js/f_register.js"></script>
</body>

</html>
