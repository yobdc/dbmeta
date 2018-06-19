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
                        <th class="col-xs-1">序号</th>
                        <th class="col-xs-1">列名</th>
                        <th class="col-xs-3">中文名称</th>
                        <th class="col-xs-1">类型</th>
                        <th class="col-xs-1">能否为空</th>
                        <th class="col-xs-1">备注</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list users.list as item>
                    <tr>
                        <td>${item?index+1}</td>
                        <td>${item.name}</td>
                        <td>${item.remark}</td>
                        <td>${item.type}</td>
                        <td>${item.nullable?then("可空","不可空")}</td>
                        <td>
                            <#if col.comment?has_content>
                            <#--<a href="${request.requestURL}">注</a>-->
                            </#if>
                        </td>
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