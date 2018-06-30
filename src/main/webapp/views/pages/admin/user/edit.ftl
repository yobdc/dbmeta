<#include "/views/common/header.ftl">

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

    <!-- Main content -->
    <section class="content">
            <form action="${ctx}/admin/user/doSave" method="post">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label for="username">用户名</label>
                            <input type="hidden" class="form-control" id="id" name="user.id" value="${user.id!}">
                            <input type="text" class="form-control" id="username" name="user.username" value="${user.username!}" required>
                        </div>
                        <div class="form-group">
                            <label for="nickname">中文名称</label>
                            <input type="text" class="form-control" id="nickname" name="user.nickname" value="${user.nickname!}">
                        </div>
                        <div class="form-group">
                            <label for="role_id">角色</label>
                            <select class="form-control" id="role_id" name="user.role_id">
                                <#list roles as role>
                                    <option value="${role.id}" <#if role.id==user.role_id>selected</#if>>${role.nickname}</option>
                                </#list>
                            </select>
                        </div>
                        <#if !user.id??>
                        <div class="form-group">
                            <label for="password">密码</label>
                            <input type="password" class="form-control" id="password" name="user.password" value="${user.password!}">
                        </div>
                        <div class="form-group">
                            <label for="password2">确认密码</label>
                            <input type="password" class="form-control" id="password2" name="user.password2">
                        </div>
                        </#if>
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