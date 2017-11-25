package com.yobdc.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created by lex on 2017/11/22.
 */
public class Table extends Model<Table> {
    public static final Table dao = new Table().dao();
}