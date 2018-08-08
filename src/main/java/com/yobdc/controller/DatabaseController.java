package com.yobdc.controller;

import com.yobdc.model.Database;

public class DatabaseController extends BaseController {
    public final static String CONTROLLER_KEY = "/database";

    public void index() {
        setAttr("dbs", Database.dao.listAll());
        renderFreeMarker("/views/pages/database/list.ftl");
    }
}
