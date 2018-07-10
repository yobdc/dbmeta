<#include "/views/common/header.ftl">

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

    <!-- Main content -->
    <section class="content">
        <form id="user-edit-form" action="${ctx}/admin/user/doSave" method="post">
            <div class="row">
                <div class="col-xs-6">
                    <div class="form-group">
                        <label for="username">用户名</label>
                        <input type="hidden" class="form-control" id="id" name="user.id"
                               <#if user??>value="${user.id!}"</#if> >
                        <input type="text" class="form-control" id="username" name="user.username"
                               <#if user??>value="${user.username!}"</#if> required>
                    </div>
                    <div class="form-group">
                        <label for="nickname">中文名称</label>
                        <input type="text" class="form-control" id="nickname" name="user.nickname"
                               <#if user??>value="${user.nickname!}"</#if> >
                    </div>
                    <div class="form-group">
                        <label for="role_id">角色</label>
                        <select class="form-control" id="role_id" name="user.role_id">
                            <option value="">请选择</option>
                                <#list roles as role>
                                    <option value="${role.id}" <#if user?? && user.role_id??><#if role.id==user.role_id>selected</#if></#if> >${role.nickname}</option>
                                </#list>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="disabled">是否失效</label>
                        <input type="checkbox" class="form-check-input" id="disabled" name="user.disabled"
                               <#if user?? && !user.disabled??>checked="true"</#if>>
                    </div>
                        <#if !user??>
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