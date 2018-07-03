<#include "/views/common/header.ftl">

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

    <!-- Main content -->
    <section class="content">
        <form id="user-edit-form" action="${ctx}/admin/user/doResetPassword" method="post">
            <div class="row">
                <div class="col-xs-6">
                    <div class="form-group">
                        <label>用户名</label>
                        <input type="hidden" class="form-control" id="id" name="user.id"
                           <#if user??>value="${user.id!}"</#if> >
                        <div class="form-control readonly">${user.username!}</div>
                    </div>
                    <div class="form-group">
                        <label>中文名称</label>
                        <div class="form-control readonly">${user.nickname!}</div>
                    </div>
                    <div class="row">
                        <div class="col-xs-8">
                            <div class="form-group">
                                <label for="password">密码</label>
                                <input type="password" class="form-control" id="password" name="user.password">
                                <span id="password-msg" class="error-msg"></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-8">
                            <div class="form-group">
                                <label for="password2">确认密码</label>
                                <input type="password" class="form-control" id="password2">
                                <span id="password2-msg" class="error-msg"></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">保存</button>
        </form>
        <!-- ./col -->

    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<#include "/views/common/footer.ftl">