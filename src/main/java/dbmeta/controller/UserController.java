package dbmeta.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
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
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(
                    username
                    , password
                    , true
            ));
            renderFreeMarker("/views/index.ftl");
        } catch (AuthenticationException e) {
            //虽然在realm中有具体的错误信息，但是安全起见，统一返回登录失败
            renderFreeMarker("/views/login.ftl");
        } catch (Exception ex) {
            renderFreeMarker("/views/login.ftl");
        }

    }
}
