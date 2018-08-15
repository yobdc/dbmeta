<#include "/views/common/header.ftl">

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content">
        <!-- Small boxes (Stat box) -->
        <div class="row">
            <div class="col-xs-12">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th class="col-xs-1">列名</th>
                        <th class="col-xs-1">中文名称</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list cols.list as item>
                    <tr>
                        <td id="columnItemName${item.id}">${item.name!}</td>
                        <td>${item.nickname!}</td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
                <#assign pageData=cols>
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