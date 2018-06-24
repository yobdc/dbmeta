package com.yobdc.model;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Model;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lex on 2017/11/22.
 */
public class Table extends Model<Table> {
    public static final Table dao = new Table().dao();
    @Getter
    private List<Column> columns = null;

    public Table findWithId(Long id) {
        Table result = dao.findById(id);
        if (result != null) {
            result.columns = Column.dao.find("select * from db_column where table_id = ?", id);
        }
        return result;
    }

    public List<Column> getColsWithRemark() {
        if (this.columns == null || this.columns.isEmpty()) {
            return null;
        }
        List<Column> cols = new ArrayList<>();
        for (Column col : this.columns) {
            if (!StrKit.isBlank(col.get("comment"))) {
                cols.add(col);
            }
        }
        return cols;
    }
}