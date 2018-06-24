package com.yobdc.controller.admin;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.plugin.activerecord.Page;
import com.yobdc.controller.BaseController;
import com.yobdc.model.Database;

public class DatabaseAdminController extends BaseController {
    public void index() {
        String keyword = getPara("keyword");
        int pageNumber = tryGetParaToInt("page", 1);
        pageNumber = pageNumber < 1 ? 1 : pageNumber;
        int pageSize = tryGetParaToInt("size", 1);
        pageSize = pageSize < 20 ? 20 : pageSize;

        Page<Database> databases = Database.dao.pageBy(pageNumber, pageSize, keyword);
        setAttr("dbs", databases);
        renderFreeMarker("/views/pages/admin/database/list.ftl");
    }

    @Before(GET.class)
    public void edit() {
        Long databaseId = getParaToLong(0);
        Database db = Database.dao.findById(databaseId);
        setAttr("db", db);
        renderFreeMarker("/views/pages/admin/database/edit.ftl");
    }
}