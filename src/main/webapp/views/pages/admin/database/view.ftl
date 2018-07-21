<#include "/views/common/header.ftl">

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

    <!-- Main content -->
    <section class="content">
        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item active">
                <a class="nav-link active" id="basic-tab" data-toggle="tab" href="#basic" role="tab" aria-controls="basic" aria-selected="true" >基本信息</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="table-tab" data-toggle="tab" href="#table" role="tab" aria-controls="table" aria-selected="false">表信息</a>
            </li>
        </ul>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade active in" id="basic" role="tabpanel" aria-labelledby="basic-tab">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label for="name">数据库名</label>
                            <input type="hidden" class="form-control" id="id" name="db.id" <#if db??>value="${db.id!}"</#if>>
                            <div class="form-control readonly">${db.name!}</div>
                        </div>
                        <div class="form-group">
                            <label for="nickname">中文名称</label>
                            <div class="form-control readonly">${db.nickname!}</div>
                        </div>
                        <div class="form-group">
                            <label for="jdbcUrl">数据库连接</label>
                            <div class="input-group">
                                <div class="form-control readonly">${db.jdbc_url!}</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-8">
                        <div class="form-group">
                            <label for="comment">备注</label>
                            <textarea class="form-control readonly" rows="3">${db.comment!}</textarea>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="table" role="tabpanel" aria-labelledby="table-tab">
                <div class="row">123</div>
            </div>
        </div>
    </section>
    <!-- /.content -->
</div>

<!-- /.content-wrapper -->

<#include "/views/common/footer.ftl">