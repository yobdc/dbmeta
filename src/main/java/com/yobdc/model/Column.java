package com.yobdc.model;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;


/**
 * Created by lex on 2017/11/22.
 */
public class Column extends Model<Column> {
    public static final Column dao = new Column().dao();


    public Page<Column> searchColumnWithTable(int pageNumber, int pageSize, String keyword) {
        String keywordLike = "%" + keyword + "%";
        return Column.dao.paginate(pageNumber, pageSize, "select \n" +
                        "db_column.id column_id\n" +
                        ",db_column.name column_name\n" +
                        ",db_column.nickname column_nickname\n" +
                        ",db_column.table_id table_id\n" +
                        ",db_table.name table_name\n" +
                        ",db_table.nickname table_nickname\n",
                "from db_column\n" +
                        "left join db_table on db_column.table_id = db_table.id\n" +
                        "where db_table.name like ?\n" +
                        "or db_table.nickname like ?\n" +
                        "or db_column.name like ?\n" +
                        "or db_column.nickname like ?", keywordLike, keywordLike, keywordLike, keywordLike);
    }

    public List<Column> findByTableId(Long tableId) {
        return Column.dao.find("select * from db_column where table_id = ?", tableId);
    }

    public boolean hasColumns(Long tableId) {
        Column col = Column.dao.findFirst("select * from db_column where table_id = ?", tableId);
        return col != null;
    }

    public Page<Column> pageByTableId(int pageNumber, int pageSize, Long tableId){
        String sqlExceptSelect = "from db_column where table_id = ?";
        return Column.dao.paginate(pageNumber, pageSize,
                "select * ",
                sqlExceptSelect, tableId);
    }
}
