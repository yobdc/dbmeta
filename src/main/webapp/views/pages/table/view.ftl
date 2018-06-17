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
                        <th class="col-xs-1">序号</th>
                        <th class="col-xs-1">列名</th>
                        <th class="col-xs-3">中文名称</th>
                        <th class="col-xs-1">类型</th>
                        <th class="col-xs-1">能否为空</th>
                        <th class="col-xs-1">备注</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list table.columns as col>
                    <tr>
                        <td>${col?index+1}</td>
                        <td>${col.name}</td>
                        <td>${col.remark}</td>
                        <td>${col.type}</td>
                        <td>${col.nullable?then("可空","不可空")}</td>
                        <td>
                            <#if col.comment?has_content>
                            <#--<a href="${request.requestURL}">注</a>-->
                            </#if>
                        </td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
                <div class="pull-right">最后修改时间: ${table.update_time}</div>
            </div>
            <div class="col-xs-12">
                <table class="table">
                    <tr>
                        <td>备注说明</td>
                    </tr>
                    <#if remarkCols??>
                        <#list remarkCols as col>
                                        <tr id="${col.name}">
                                            <td><a href="">[注${col?index+1}]</a>&nbsp;&nbsp;&nbsp;&nbsp;${col.comment}</td>
                                        </tr>
                        </#list>
                    </#if>
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