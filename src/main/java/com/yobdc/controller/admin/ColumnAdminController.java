package com.yobdc.controller.admin;

import com.jfinal.aop.Before;
import com.jfinal.ext.interceptor.POST;
import com.yobdc.controller.BaseController;
import com.yobdc.controller.response.RestResponse;
import com.yobdc.model.Column;

import java.util.List;

public class ColumnAdminController extends BaseController {
    public final static String CONTROLLER_KEY = "/admin/column";

    public void index() {
        Long tableId = getParaToLong(0);
        List<Column> cols = Column.dao.findByTableId(tableId);
        setAttr("cols", cols);
        setAttr("tableId", tableId);
        renderFreeMarker("/views/pages/admin/column/list.ftl");
    }

    public void edit() {
        Long colId = getParaToLong(0);
        Column col = Column.dao.findById(colId);
        setAttr("col", col);
        renderFreeMarker("/views/pages/admin/column/edit.ftl");
    }

    @Before(POST.class)
    public void remove() {
        Long colId = getParaToLong(0);
        try {
            Column.dao.deleteById(colId);
            renderJson(RestResponse.success());
        } catch (Exception ex) {
            renderJson(RestResponse.fail().msg(ex.getMessage()));
        }
    }
}
