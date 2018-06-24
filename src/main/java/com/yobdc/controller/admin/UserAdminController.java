package com.yobdc.controller.admin;

import com.jfinal.plugin.activerecord.Page;
import com.yobdc.controller.BaseController;
import com.yobdc.model.User;

public class UserAdminController extends BaseController {
    public final static String CONTROLLER_KEY = "/admin/user";

    public void index() {
        String keyword = getPara("keyword");
        int pageNumber = tryGetParaToInt("page", 1);
        pageNumber = pageNumber < 1 ? 1 : pageNumber;
        int pageSize = tryGetParaToInt("size", 1);
        pageSize = pageSize < 20 ? 20 : pageSize;

        Page<User> users = User.dao.pageBy(pageNumber, pageSize, keyword);
        setAttr("users", users);
        renderFreeMarker("/views/pages/admin/user/list.ftl");
    }
}
