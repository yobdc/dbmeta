<#include "/views/common/header.ftl">

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

    <!-- Main content -->
    <section class="content">
            <form action="${ctx}/admin/column/doSave" method="post">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label for="name">列名</label>
                            <input type="hidden" class="form-control" id="id" name="col.id" <#if col??>value="${col.id!}"</#if>>
                            <input type="text" class="form-control" id="name" name="col.name" <#if col??>value="${col.name!}"</#if> required>
                        </div>
                        <div class="form-group">
                            <label for="nickname">中文名称</label>
                            <input type="text" class="form-control" id="nickname" name="col.nickname" <#if col??>value="${col.nickname!}"</#if>>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-8">
                        <div class="form-group">
                            <label for="comment">备注</label>
                            <textarea class="form-control" id="comment" name="col.comment" rows="3"><#if col??>${col.comment!}</#if></textarea>
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