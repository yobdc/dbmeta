<#include "/views/common/header.ftl">

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

    <!-- Main content -->
    <section class="content">
            <form>
                <div class="row">
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label for="name">数据库名</label>
                            <input type="text" class="form-control" id="name">
                        </div>
                        <div class="form-group">
                            <label for="nickname">中文名称</label>
                            <input type="password" class="form-control" id="nickname">
                        </div>
                        <div class="form-group">
                            <label for="jdbc_url">数据库连接</label>
                            <input type="text" class="form-control" id="jdbc_url">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-8">
                        <div class="form-group">
                            <label for="comment">备注</label>
                            <textarea class="form-control" id="comment" rows="3"></textarea>
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