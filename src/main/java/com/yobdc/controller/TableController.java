package com.yobdc.controller;

import com.jfinal.core.Controller;
import com.yobdc.model.Table;

public class TableController extends Controller {
    public void index() {
        Long tableId = getParaToLong(0);
        setAttr("table", Table.dao.findWithId(tableId));
        renderFreeMarker("/views/index.ftl");
    }
}
