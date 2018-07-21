package com.yobdc.controller.admin;

import com.jfinal.aop.Before;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.kit.LogKit;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;
import com.yobdc.controller.BaseController;
import com.yobdc.controller.response.RestResponse;
import com.yobdc.kit.db.MetaKit;
import com.yobdc.model.Database;
import com.yobdc.model.Table;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import java.sql.SQLException;

@RequiresPermissions({"database.view"})
public class DatabaseAdminController extends BaseController {
    public final static String CONTROLLER_KEY = "/admin/database";

    public void index() {
        init();
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
    public void view() {
        Long databaseId = getParaToLong(0);
        Database db = Database.dao.findById(databaseId);
        setAttr("db", db);
        renderFreeMarker("/views/pages/admin/database/view.ftl");
    }

    @Before(GET.class)
    public void edit() {
        Long databaseId = getParaToLong(0);
        Database db = Database.dao.findById(databaseId);
        setAttr("db", db);
        renderFreeMarker("/views/pages/admin/database/edit.ftl");
    }

    @Before(POST.class)
    public void doSave() {
        Database model = getModel(Database.class, "db");
        if (model.get("id") == null) {
            model.save();
        } else {
            model.update();
        }
        redirect(DatabaseAdminController.CONTROLLER_KEY);
    }

    @Before(GET.class)
    public void create() {
        renderFreeMarker("/views/pages/admin/database/edit.ftl");
    }

    @Before(POST.class)
    public void testJdbc() {
        String jdbcUrl = getPara("url");
        try {
            MetaKit.testConnection(jdbcUrl);
            renderJson(RestResponse.success());
        } catch (SQLException e) {
            renderJson(RestResponse.fail().msg(e.getMessage()));
        }
    }

    @Before(POST.class)
    public void remove() {
        Long databaseId = getParaToLong(0);
        try {
            if (Table.dao.hasTables(databaseId)) {
                renderJson(RestResponse.fail().msg("数据源存在关联表"));
            } else {
                Database.dao.deleteById(databaseId);
                renderJson(RestResponse.success());
            }
        } catch (Exception ex) {
            renderJson(RestResponse.fail().msg(ex.getMessage()));
        }
    }
}