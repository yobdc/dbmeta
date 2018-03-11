package com.yobdc.controller;

import com.yobdc.model.Table;

public class TableController extends BaseController {
    public void index() {
        init();
        Long tableId = getParaToLong(0);
        Table table = Table.dao.findWithId(tableId);
        setAttr("table", table);
        setAttr("remarkCols", table.getColsWithRemark());
        renderFreeMarker("/views/pages/table/view.ftl");
    }
}
