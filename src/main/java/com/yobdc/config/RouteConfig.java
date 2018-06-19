package com.yobdc.config;

import com.jfinal.config.Routes;
import com.yobdc.controller.IndexController;
import com.yobdc.controller.TableController;
import com.yobdc.controller.UserController;
import com.yobdc.controller.admin.UserAdminController;

/**
 * Created by lex on 2017/11/23.
 */
public class RouteConfig extends Routes {
    @Override
    public void config() {
        setBaseViewPath("views");
        add("/", IndexController.class);
        add("/user", UserController.class);
        add("/table", TableController.class);

        /**
         * 管理员页面
         */
        add("/admin/user", UserAdminController.class);
    }
}
