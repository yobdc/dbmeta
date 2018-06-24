package com.yobdc.kit.db;

import java.util.List;

public interface MetaKit {
    List<String> showTables(String jdbcUrl);

    void showColumns(String jdbcUrl, String tableName);
}
