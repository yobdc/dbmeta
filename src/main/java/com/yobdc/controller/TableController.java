package com.yobdc.controller;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;
import com.yobdc.model.Column;
import com.yobdc.model.Table;


public class TableController extends BaseController {
    public final static String CONTROLLER_KEY = "/table";

    public void index() {
        init();
        Long tableId = getParaToLong(0);
        Table table = Table.dao.findWithId(tableId);
        setAttr("table", table);
        setAttr("remarkCols", table.getColsWithRemark());
        renderFreeMarker("/views/pages/table/view.ftl");
    }

    public void search() {
        String keyword = getPara("keyword");
        int pageNumber = tryGetParaToInt("page", 1);
        pageNumber = pageNumber < 1 ? 1 : pageNumber;
        int pageSize = tryGetParaToInt("size", 1);
        pageSize = pageSize < 20 ? 20 : pageSize;

        if (!StrKit.isBlank(keyword)) {
            return;
        }
        init();
        Page<Column> items = Column.dao.searchColumnWithTable(pageNumber, pageSize, keyword);
        setAttr("items", items);
        setAttr("searchKeyword", keyword);

        renderFreeMarker("/views/pages/table/search.ftl");
    }

    public void list() {
        int pageNumber = tryGetParaToInt("page", 1);
        pageNumber = pageNumber < 1 ? 1 : pageNumber;
        int pageSize = tryGetParaToInt("size", 1);
        pageSize = pageSize < 20 ? 20 : pageSize;
        Long databaseId = getParaToLong(0);
        Page<Table> tables = Table.dao.pageByDatabaseId(pageNumber, pageSize, databaseId);
        setAttr("tables", tables);
        renderFreeMarker("/views/pages/table/list.ftl");
    }
}
