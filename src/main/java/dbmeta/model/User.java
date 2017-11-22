package dbmeta.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created by lex on 2017/11/22.
 */
public class User extends Model<User> {
    public static final User dao = new User().dao();
}
