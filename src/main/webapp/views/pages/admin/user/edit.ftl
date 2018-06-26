<#include "/views/common/header.ftl">

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

    <!-- Main content -->
    <section class="content">
            <form action="${ctx}/admin/user/doSave" method="post">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label for="name">数据库名</label>
                            <input type="hidden" class="form-control" id="id" name="user.id" <#if db??>value="${user.id!}"</#if>>
                            <input type="text" class="form-control" id="name" name="user.name" <#if db??>value="${user.name!}"</#if> required>
                        </div>
                        <div class="form-group">
                            <label for="nickname">中文名称</label>
                            <input type="text" class="form-control" id="nickname" name="user.nickname" <#if db??>value="${user.nickname!}"</#if>>
                        </div>
                        <div class="form-group">
                            <label for="jdbcUrl">数据库连接</label>
                            <input type="text" class="form-control" id="jdbcUrl" name="user.jdbc_url" <#if db??>value="${user.jdbc_url!}"</#if>>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-8">
                        <div class="form-group">
                            <label for="comment">备注</label>
                            <textarea class="form-control" id="comment" name="user.comment" rows="3"><#if db??>${user.comment!}</#if></textarea>
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