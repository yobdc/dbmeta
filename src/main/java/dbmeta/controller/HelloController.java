package dbmeta.controller;

import com.jfinal.core.Controller;
import dbmeta.model.User;

import java.util.List;

/**
 * Created by lex on 2017/11/22.
 */
public class HelloController extends Controller {
    public void index() {
        renderText("Hello JFinal World.");
    }

    public void hello() {
        List<User> users = User.dao.find("select * from user");
        renderFreeMarker("/views/index.ftl");
    }
}
