<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>DbMeta</title>
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
    <link rel="stylesheet" href="${ctx}/libs/dbmeta/app.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->
        <a href="/" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>D</b>M</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>Db</b>Meta</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>

            <form class="search-panel" action="/table/search">
                <input type="text" class="form-control" placeholder="输入关键字" name="keyword">
                <div class="input-group-append">
                    <button class="btn" type="submit">搜索</button>
                </div>
            </form>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#">
                            <img src="${ctx}/libs/adminlte-2.4.2/dist/img/user2-160x160.jpg" class="user-image"
                                 alt="User Image">
                            <span class="hidden-xs">Alexander Pierce</span>
                        </a>
                    </li>
                    <!-- Tasks: style can be found in dropdown.less -->
                    <li class="dropdown tasks-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-gears"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li><!-- Task item -->
                                        <a href="/dologout">登出</a>
                                    </li>
                                    <!-- end task item -->
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu" data-widget="tree">
                <li>
                    <a href="${ctx}/admin/user">
                        <i class="fa fa-book"></i> <span>用户管理</span>
                    </a>
                </li>
                <#if databases??>
                    <#list databases as item>
                        <#if (item.tables)?? && item.tables?size!=0>
                <li class="treeview <#if table?? && table.database_id==item.id>menu-open</#if>">
                    <a href="#">
                        <i class="fa fa-pie-chart"></i>
                        <span>${item.name}</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu" <#if table?? && table.database_id==item.id>style="display: block;"</#if>>
                    <#list item.tables as tb>
                        <li>
                            <a <#if table?? && tb.id==table.id>class="active" </#if> href="${ctx}/table/${tb.id}">
                                <i class="fa fa-circle-o"></i> ${tb.name}
                            </a>
                        </li>
                    </#list>
                    </ul>
                </li>
                        <#else >
                <li>
                    <a href="${ctx}/table/${item.id}">
                        <i class="fa fa-book"></i> <span>${item.name}</span>
                    </a>
                </li>
                        </#if>
                    </#list>
                </#if>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>
