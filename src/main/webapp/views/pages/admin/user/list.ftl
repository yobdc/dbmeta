<#include "/views/common/header.ftl">

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content">
        <!-- Small boxes (Stat box) -->
        <div class="row">
            <div class="col-xs-12">
                <button class="btn btn-primary">新增</button>
            </div>
            <div class="col-xs-12">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th class="col-xs-1">用户名</th>
                        <th class="col-xs-1">昵称</th>
                        <th class="col-xs-1">角色</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list users.list as item>
                    <tr>
                        <td>${item.username!}</td>
                        <td>${item.nickname!}</td>
                        <td>${item.roleId!}</td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
            <!-- ./col -->
        </div>
        <!-- /.row -->

    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<#include "/views/common/footer.ftl">