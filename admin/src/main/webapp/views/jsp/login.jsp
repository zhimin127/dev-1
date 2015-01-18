<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <!-- Title and other stuffs -->
  <title>后台登陆页面</title> 
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="author" content="">
  <!-- Style sheets -->
  <link href="static/style/bootstrap.css" rel="stylesheet">
  <link rel="stylesheet" href="static/style/font-awesome.css">
<link href="static/style/style.css" rel="stylesheet">
<!-- <link href="style/bootstrap-responsive.css" rel="stylesheet"> -->

<!-- HTML5 Support for IE -->
<!--[if lt IE 9]>
  <script src="static/js/html5shim.js"></script>
  <![endif]-->

  <!-- Favicon -->
  <link rel="shortcut icon" href="static/img/favicon/favicon.png">
  <style>
  .login-alert{display: none;}
  </style>
</head>

<body>

<!-- Form area -->
<div class="admin-form">
  <div class="container">

    <div class="row">
      <div class="col-md-12">
        <!-- Widget starts -->
            <div class="widget worange">
              <!-- Widget head -->
              <div class="widget-head">
                <i class="icon-lock"></i> Login 
              </div>

              <div class="widget-content">
                <div class="padd">
                  <!-- Login form -->
                  <form class="form-horizontal" method="post" action="login_check">
            <div class="inputwrapper login-alert">
                <div class="alert alert-error">Invalid username or password</div>
            </div>
                    <!-- Email -->
                    <div class="form-group">
                      <label class="control-label col-lg-3" for="inputEmail">Email</label>
                      <div class="col-lg-9">
                        <input type="text" class="form-control" id="inputEmail" placeholder="Email" name="username">
                      </div>
                    </div>
                    <!-- Password -->
                    <div class="form-group">
                      <label class="control-label col-lg-3" for="inputPassword">Password</label>
                      <div class="col-lg-9">
                        <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password">
                      </div>
                    </div>
                    <!-- Remember me checkbox and sign in button -->
                    <div class="form-group">
					<div class="col-lg-9 col-lg-offset-3">
                      <div class="checkbox">
                        <label>
                          <input type="checkbox"> Remember me
                        </label>
						</div>
					</div>
					</div>
                        <div class="col-lg-9 col-lg-offset-2">
							<button type="submit" class="btn btn-danger">Sign in</button>
							<button type="reset" class="btn btn-default">Reset</button>
						</div>
                    <br />
                  </form>
				  
				</div>
                </div>
              
                <div class="widget-foot">
                  Not Registred? <a href="#">Register here</a>
                </div>
            </div>  
      </div>
    </div>
  </div> 
</div>
	
<!-- JS -->
<script src="static/js/jquery.js"></script>
<script src="static/js/bootstrap.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function(){
        jQuery('.form-horizontal').submit(function(){
            var u = jQuery('#inputEmail').val();
            var p = jQuery('#inputPassword').val();
            if(u == '' || p == '') {
                jQuery('.login-alert').fadeIn();
                return false;
            }
        });
        if('${msg==null?0:1}' == '1'){
        	jQuery('.login-alert').fadeIn();
        }
    });
</script>
</body>
</html>