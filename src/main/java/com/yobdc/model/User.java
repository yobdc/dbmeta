package com.yobdc.model;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

/**
 * Created by lex on 2017/11/22.
 */
public class User extends Model<User> {
    public static final User dao = new User().dao();

    public Page<User> pageBy(int pageNumber, int pageSize, String keyword) {
        String keywordLike = "%" + keyword + "%";
        String sqlExceptSelect = "from sys_user";
        if (!StrKit.isBlank(keyword)) {
            sqlExceptSelect += " where username like ? or nickname like ?";
            return User.dao.paginate(pageNumber, pageSize,
                    "select * ",
                    sqlExceptSelect,
                    keywordLike, keywordLike);
        } else {
            return User.dao.paginate(pageNumber, pageSize,
                    "select * ",
                    sqlExceptSelect);
        }
    }

    public User findByUsername(String username) {
        return dao.findFirst("select * from sys_user where username =  ?", username);
    }

    public String getUsername() {
        return get("username");
    }

    public void setPassword(String password) {
        set("password", password);
    }

    public String getPassword() {
        return get("password");
    }

    public String getNickname() {
        return get("nickname");
    }
}
