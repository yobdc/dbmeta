package com.yobdc.controller;


/**
 * Created by lex on 2017/11/22.
 */
public class IndexController extends BaseController {
    public final static String CONTROLLER_KEY = "/";

    public void index() {
        init();
        renderFreeMarker("/views/index.ftl");
    }
}
