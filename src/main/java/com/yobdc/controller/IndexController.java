package com.yobdc.controller;

import com.jfinal.core.Controller;

/**
 * Created by lex on 2017/11/22.
 */
public class IndexController extends Controller {
    public void index() {
        renderFreeMarker("/views/index.ftl");
    }
}
