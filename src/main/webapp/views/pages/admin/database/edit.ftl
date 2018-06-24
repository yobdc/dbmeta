<#include "/views/common/header.ftl">

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

    <!-- Main content -->
    <section class="content">
            <form action="${ctx}/admin/database/doEdit" method="post">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label for="name">数据库名</label>
                            <input type="hidden" class="form-control" id="db.id" name="db.id" value="${db.id!}">
                            <input type="text" class="form-control" id="name" name="db.name" value="${db.name!}" required>
                        </div>
                        <div class="form-group">
                            <label for="nickname">中文名称</label>
                            <input type="text" class="form-control" id="nickname" name="db.nickname" value="${db.nickname!}">
                        </div>
                        <div class="form-group">
                            <label for="jdbcUrl">数据库连接</label>
                            <input type="text" class="form-control" id="jdbcUrl" name="db.jdbc_url" value="${db.jdbc_url!}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-8">
                        <div class="form-group">
                            <label for="comment">备注</label>
                            <textarea class="form-control" id="comment" name="db.comment" rows="3">${db.comment!}</textarea>
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