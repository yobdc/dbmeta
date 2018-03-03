package com.yobdc.controller;

import com.jfinal.core.Controller;
import com.yobdc.model.Database;

/**
 * Created by lex on 2017/11/22.
 */
public class IndexController extends Controller {
    public void index() {
        setAttr("databases", Database.dao.listAllWIthTables());
        renderFreeMarker("/views/index.ftl");
    }
}
