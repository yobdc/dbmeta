package com.yobdc.controller;

import com.yobdc.model.Table;
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
        if (StringUtils.isEmpty(keyword)) {
            return;
        }
        init();
        renderFreeMarker("/views/pages/table/view.ftl");
    }
}
