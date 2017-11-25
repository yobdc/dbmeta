package dbmeta.config;

import com.jfinal.config.Routes;
import dbmeta.controller.IndexController;
import dbmeta.controller.UserController;

/**
 * Created by lex on 2017/11/23.
 */
public class RouteConfig extends Routes {
    @Override
    public void config() {
        setBaseViewPath("views");
        add("/", IndexController.class);
        add("/user", UserController.class);
    }
}
