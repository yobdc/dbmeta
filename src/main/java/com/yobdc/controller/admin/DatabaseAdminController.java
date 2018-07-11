package com.yobdc.controller.admin;

import com.jfinal.aop.Before;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;
import com.yobdc.controller.BaseController;
import com.yobdc.controller.response.RestResponse;
import com.yobdc.model.Database;
import org.apache.shiro.authz.annotation.RequiresPermissions;

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
    public void edit() {
        Long databaseId = getParaToLong(0);
        Database db = Database.dao.findById(databaseId);
        setAttr("db", db);
        renderFreeMarker("/views/pages/admin/database/edit.ftl");
    }

    @Before(POST.class)
    public void doSave() {
        Database model = getModel(Database.class, "db");
        if (StrKit.isBlank(model.get("id"))) {
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
        renderJson(RestResponse.success());
    }
}