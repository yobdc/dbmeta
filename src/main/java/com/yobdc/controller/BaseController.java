package com.yobdc.controller;

import com.jfinal.core.Controller;
import com.yobdc.model.Database;

public class BaseController extends Controller {
    protected void init() {
        setAttr("databases", Database.dao.listAllWIthTables());
    }
}
