<#include "/views/common/header.ftl">

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

    <!-- Main content -->
    <section class="content">
            <form action="${ctx}/admin/database/doSave" method="post">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label for="name">数据库名</label>
                            <input type="hidden" class="form-control" id="id" name="db.id" <#if db??>value="${db.id!}"</#if>>
                            <input type="text" class="form-control" id="name" name="db.name" <#if db??>value="${db.name!}"</#if> required>
                        </div>
                        <div class="form-group">
                            <label for="nickname">中文名称</label>
                            <input type="text" class="form-control" id="nickname" name="db.nickname" <#if db??>value="${db.nickname!}"</#if>>
                        </div>
                        <div class="form-group">
                            <label for="jdbcUrl">数据库连接</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="jdbcUrl" name="db.jdbc_url" <#if db??>value="${db.jdbc_url!}"</#if>>
                                <div class="input-group-btn">
                                    <button class="btn btn-primary">测试</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-8">
                        <div class="form-group">
                            <label for="comment">备注</label>
                            <textarea class="form-control" id="comment" name="db.comment" rows="3"><#if db??>${db.comment!}</#if></textarea>
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
<div class='lmask'></div>

<#include "/views/common/footer.ftl">