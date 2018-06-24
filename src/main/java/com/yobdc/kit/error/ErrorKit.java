package com.yobdc.kit.error;

import com.jfinal.config.Constants;

public class ErrorKit {

    public static void configErrorViews(Constants me) {
        me.setErrorView(400, "/views/pages/error/400.ftl");
        me.setErrorView(401, "/views/pages/error/401.ftl");
        me.setErrorView(404, "/views/pages/error/404.ftl");
        me.setErrorView(500, "/views/pages/error/500.ftl");
    }
}
