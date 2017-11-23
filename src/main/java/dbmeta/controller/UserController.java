package dbmeta.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by lex on 2017/11/23.
 */
public class UserController extends Controller {

    @ActionKey("/login")
    public String login() {
        return "/views/login.ftl";
    }

    @ActionKey("/dologin")
    @Before(POST.class)
    public String doLogin() {
        String username = getAttr("username");
        String password = getAttr("password");

        SecurityUtils.getSubject().login(new UsernamePasswordToken(
                username
                , password
                , true
        ));

        return("/views/index.ftl");
    }
}
