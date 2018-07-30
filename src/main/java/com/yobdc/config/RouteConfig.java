package com.yobdc.config;

import com.jfinal.config.Routes;
import com.yobdc.controller.IndexController;
import com.yobdc.controller.TableController;
import com.yobdc.controller.UserController;
import com.yobdc.controller.admin.ColumnAdminController;
import com.yobdc.controller.admin.DatabaseAdminController;
import com.yobdc.controller.admin.TableAdminController;
import com.yobdc.controller.admin.UserAdminController;

/**
 * Created by lex on 2017/11/23.
 */
public class RouteConfig extends Routes {
    @Override
    public void config() {
        setBaseViewPath("views");
        add(IndexController.CONTROLLER_KEY, IndexController.class);
        add(UserController.CONTROLLER_KEY, UserController.class);
        add(TableController.CONTROLLER_KEY, TableController.class);

        /**
         * 管理员页面
         */
        add(UserAdminController.CONTROLLER_KEY, UserAdminController.class);
        add(DatabaseAdminController.CONTROLLER_KEY, DatabaseAdminController.class);
        add(TableAdminController.CONTROLLER_KEY, TableAdminController.class);
        add(ColumnAdminController.CONTROLLER_KEY, ColumnAdminController.class);
    }
}
