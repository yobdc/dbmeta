package com.yobdc.model;

import com.jfinal.plugin.activerecord.Model;
import lombok.Getter;

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
}