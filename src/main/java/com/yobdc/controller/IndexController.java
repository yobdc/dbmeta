package com.yobdc.controller;


import com.jfinal.kit.LogKit;

/**
 * Created by lex on 2017/11/22.
 */
public class IndexController extends BaseController {
    public final static String CONTROLLER_KEY = "/";

    public void index() {
        LogKit.debug("welcome to index page");
        init();
        renderFreeMarker("/views/index.ftl");
    }
}
