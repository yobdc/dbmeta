package dbmeta.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created by lex on 2017/11/22.
 */
public class Column extends Model<Column> {
    public static final Column dao = new Column().dao();
}
