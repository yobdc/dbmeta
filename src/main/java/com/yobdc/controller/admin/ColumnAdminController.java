package com.yobdc.controller.admin;

import com.yobdc.controller.BaseController;
import com.yobdc.model.Column;

import java.util.List;

public class ColumnAdminController extends BaseController {
    public final static String CONTROLLER_KEY = "/admin/column";

    public void index() {
        Long tableId = getParaToLong(0);
        List<Column> cols = Column.dao.findByTableId(tableId);
        setAttr("cols", cols);
        renderFreeMarker("/views/pages/admin/column/list.ftl");
    }

    public void edit() {
        Long colId = getParaToLong(0);
        Column col = Column.dao.findById(colId);
        setAttr("col", col);
        renderFreeMarker("/views/pages/admin/column/edit.ftl");
    }
}
