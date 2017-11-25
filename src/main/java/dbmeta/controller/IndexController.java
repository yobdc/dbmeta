package dbmeta.controller;

import com.jfinal.core.Controller;
import dbmeta.model.User;

import java.util.List;

/**
 * Created by lex on 2017/11/22.
 */
public class IndexController extends Controller {
    public void index() {
        renderFreeMarker("/views/index.ftl");
    }
}
