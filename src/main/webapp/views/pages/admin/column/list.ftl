<#include "/views/common/header.ftl">

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content">
        <!-- Small boxes (Stat box) -->
        <div class="row">
            <div class="col-xs-12">
                <a class="btn btn-primary" href="${ctx}/admin/database/create">新增</a>
            </div>
            <div class="col-xs-12">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th class="col-xs-1">操作</th>
                        <th class="col-xs-1">列名</th>
                        <th class="col-xs-1">中文名称</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list cols as item>
                    <tr>
                        <td>
                            <a href="${ctx}/admin/column/edit/${item.id}">编辑</a>
                            <a href="javascript:void(0)" onclick="delTableModal(${item.id})">删除</a>
                        </td>
                        <td id="dbItemName${item.id}">${item.name!}</td>
                        <td>${item.nickname!}</td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
                <!-- Modal -->
                <div class="modal fade" id="delDbModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">删除数据源</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                确认删除表<a id="dbItemName" dbid="" prefix="${ctx}" href="#"><a>？
                            </div>
                            <div class="modal-footer">
                                <button id="confirmDel" type="button" class="btn btn-danger">确定</button>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ./col -->
        </div>
        <!-- /.row -->

    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<#include "/views/common/footer.ftl">