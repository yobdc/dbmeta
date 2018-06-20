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
                        <th class="col-xs-1">列中文名</th>
                        <th class="col-xs-3">表名</th>
                        <th class="col-xs-1">表中文名</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list items.list as item>
                    <tr>
                        <td>${item.column_name}</td>
                        <td>${item.column_remark}</td>
                        <td><a href="${ctx}/table/${item.table_id}">${item.table_name}</a></td>
                        <td>${item.table_remark}</td>
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