<#include "/views/common/header.ftl">

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content">
        <!-- Small boxes (Stat box) -->
        <div class="row">
            <div class="col-xs-12">
                <a class="btn btn-primary" href="${ctx}/admin/user/create">新增</a>
            </div>
            <div class="col-xs-12">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th class="col-xs-1">操作</th>
                        <th class="col-xs-1">用户名</th>
                        <th class="col-xs-1">昵称</th>
                        <th class="col-xs-1">角色</th>
                        <th class="col-xs-1">是否有效</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list users.list as item>
                    <tr>
                        <td>
                            <a href="${ctx}/admin/user/edit/${item.id}">编辑</a>
                            <a href="${ctx}/admin/user/reset/${item.id}">重置密码</a>
                        </td>
                        <td>${item.username!}</td>
                        <td>${item.nickname!}</td>
                        <td><#if item.role_id??>${rolesMap.get(item.role_id)}</#if></td>
                        <td><#if item.disabled?? && item.disabled>否<#else>是</#if></td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
                <#assign pageData=users>
                <#include "/views/common/page.ftl">
            </div>
            <!-- ./col -->
        </div>
        <!-- /.row -->

    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<#include "/views/common/footer.ftl">