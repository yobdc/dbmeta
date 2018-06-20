package com.yobdc.controller;

import com.jfinal.plugin.activerecord.Page;
import com.yobdc.model.Column;
import com.yobdc.model.Table;
import com.yobdc.util.db.MetaUtil;
import org.apache.commons.lang3.StringUtils;


public class TableController extends BaseController {
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

        if (StringUtils.isEmpty(keyword)) {
            return;
        }
        init();
        Page<Column> items = Column.dao.searchColumnWithTable(pageNumber, pageSize, keyword);
        setAttr("items", items);
        setAttr("searchKeyword", keyword);
        MetaUtil.load();

        renderFreeMarker("/views/pages/table/search.ftl");
    }
}
