package com.yobdc.model;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lex on 2017/11/23.
 */
public class Database extends Model<Database> {
    public static final Database dao = new Database().dao();
    @Getter
    private List<Table> tables = null;

    public Page<Database> pageBy(int pageNumber, int pageSize, String keyword) {
        String keywordLike = "%" + keyword + "%";
        String sqlExceptSelect = "from sys_database";
        if (StringUtils.isNotEmpty(keyword)) {
            sqlExceptSelect += " where name like ? or remark like ?";
            return Database.dao.paginate(pageNumber, pageSize,
                    "select * ",
                    sqlExceptSelect,
                    keywordLike, keywordLike);
        } else{
            return Database.dao.paginate(pageNumber, pageSize,
                    "select * ",
                    sqlExceptSelect);
        }
    }

    public List<Database> listAllWIthTables() {
        List<Database> result = dao.find("select * from db_database");
        if (result != null) {
            List<Table> tables = Table.dao.find("select * from db_table");
            if (tables != null) {
                Map<Long, Database> map = new HashMap<>();
                for (Database db : result) {
                    map.put(db.getLong("id"), db);
                }
                for (Table table : tables) {
                    Long dbId = table.getLong("database_id");
                    Database db = map.get(dbId);
                    if (db != null) {
                        if (db.tables == null) {
                            db.tables = new ArrayList<>();
                        }
                        db.tables.add(table);
                    }
                }
            }
        }
        return result;
    }
}