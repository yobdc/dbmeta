package com.yobdc.util.db;

import java.util.List;

public interface MetaUtil {
    List<String> showTables(String jdbcUrl);

    void showColumns(String jdbcUrl, String tableName);
}
