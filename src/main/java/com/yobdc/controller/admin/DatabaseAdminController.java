package com.yobdc.controller.admin;

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
        setAttr("databases", databases);
        renderFreeMarker("/views/pages/admin/user/list.ftl");
    }
}