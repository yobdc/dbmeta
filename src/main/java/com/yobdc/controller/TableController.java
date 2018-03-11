package com.yobdc.controller;

import com.yobdc.model.Table;

public class TableController extends BaseController {
    public void index() {
        init();
        Long tableId = getParaToLong(0);
        setAttr("table", Table.dao.findWithId(tableId));
        renderFreeMarker("/views/pages/table/view.ftl");
    }
}
