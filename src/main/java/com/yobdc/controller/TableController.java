package com.yobdc.controller;

import com.yobdc.model.Column;
import com.yobdc.model.Table;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

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
        if (StringUtils.isEmpty(keyword)) {
            return;
        }
        init();
        List<Column> items = Column.dao.searchColumnWithTable(keyword);

        renderFreeMarker("/views/pages/table/search.ftl");
    }
}
