package com.yobdc.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created by lex on 2017/11/23.
 */
public class Database extends Model<Database> {
    public static final Database dao = new Database().dao();
}