package com.yobdc.controller.admin;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.kit.PropKit;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;
import com.yobdc.controller.BaseController;
import com.yobdc.model.Role;
import com.yobdc.model.User;

public class UserAdminController extends BaseController {
    public final static String CONTROLLER_KEY = "/admin/user";

    public void index() {
        init();
        String keyword = getPara("keyword");
        int pageNumber = tryGetParaToInt("page", 1);
        pageNumber = pageNumber < 1 ? 1 : pageNumber;
        int pageSize = tryGetParaToInt("size", 1);

        int defaultPageSize = PropKit.getInt("pageSize");
        pageSize = pageSize < defaultPageSize ? defaultPageSize : pageSize;

        Page<User> users = User.dao.pageBy(pageNumber, pageSize, keyword);
        setAttr("users", users);
        setAttr("rolesMap", Role.dao.getRolesMap());
        renderFreeMarker("/views/pages/admin/user/list.ftl");
    }

    @Before(GET.class)
    public void edit() {
        Long userId = getParaToLong(0);
        User user = User.dao.findById(userId);
        setAttr("user", user);
        setAttr("roles", Role.dao.listAllRoles());
        renderFreeMarker("/views/pages/admin/user/edit.ftl");
    }

    @Before(POST.class)
    public void doSave() {
        User model = getModel(User.class);
        if (model.get("id") == null) {
            model.save();
        } else {
            model.update();
        }
        redirect(UserAdminController.CONTROLLER_KEY);
    }

    public void create() {
        setAttr("roles", Role.dao.listAllRoles());
        renderFreeMarker("/views/pages/admin/user/edit.ftl");
    }

    @ActionKey("admin/user/reset")
    public void resetPassword(){
        Long userId = getParaToLong(0);
        User user = User.dao.findById(userId);
        setAttr("user", user);
        renderFreeMarker("/views/pages/admin/user/resetPassword.ftl");
    }
}
