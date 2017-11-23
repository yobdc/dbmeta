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
    public void login() {
        renderFreeMarker("/views/login.ftl");
    }

    @ActionKey("/dologin")
    @Before(POST.class)
    public void doLogin() {
        String username = getAttr("username");
        String password = getAttr("password");

        SecurityUtils.getSubject().login(new UsernamePasswordToken(
                username
                , password
                , true
        ));

        renderFreeMarker("/views/index.ftl");
    }
}
