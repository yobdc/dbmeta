package com.yobdc.controller;

import com.jfinal.plugin.activerecord.Page;
import com.yobdc.model.Column;

public class ColumnController extends BaseController {
    public final static String CONTROLLER_KEY = "/column";

    public void list() {
        int pageNumber = tryGetParaToInt("page", 1);
        pageNumber = pageNumber < 1 ? 1 : pageNumber;
        int pageSize = tryGetParaToInt("size", 1);
        pageSize = pageSize < 20 ? 20 : pageSize;
        Long databaseId = getParaToLong(0);
        Page<Column> columns = Column.dao.pageByTableId(pageNumber, pageSize, databaseId);
        setAttr("cols", columns);
        renderFreeMarker("/views/pages/column/list.ftl");
    }
}
