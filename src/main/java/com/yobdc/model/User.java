package com.yobdc.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created by lex on 2017/11/22.
 */
public class User extends Model<User> {
    public static final User dao = new User().dao();

    public User findByUsername(String username) {
        return dao.findFirst("select * from sys_user");
    }

    public String getUsername() {
        return get("username");
    }

    public String getPassword() {
        return get("password");
    }

    public String getNickname() {
        return get("nickname");
    }
}
