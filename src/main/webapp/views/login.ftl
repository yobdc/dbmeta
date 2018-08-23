
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>dbmeta</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="${ctx}/libs/bootstrap-3.3.7/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${ctx}/libs/font-awesome-4.7.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${ctx}/libs/ionicons-2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${ctx}/libs/adminlte-2.4.2/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="${ctx}/libs/adminlte-2.4.2/dist/css/skins/_all-skins.min.css">
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="../../index2.html"><b>db</b>meta</a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <form action="${ctx}/dologin" method="post">
            <div class="form-group has-feedback">
                <input id="loginUser" type="text" class="form-control" name="username" placeholder="用户名">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input id="loginPwd" type="hidden" name="password">
                <input id="loginPwdInput" type="password" class="form-control" name="password2" placeholder="密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="${ctx}/libs/jquery-3.2.1/jquery-3.2.1.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${ctx}/libs/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="${ctx}/libs/md5/md5.js"></script>
<script src="${ctx}/libs/dbmeta/app.js"></script>
</body>
</html>
