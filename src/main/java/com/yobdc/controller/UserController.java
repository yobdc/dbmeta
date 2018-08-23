package com.yobdc.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.kit.LogKit;
import com.jfinal.kit.PropKit;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lex on 2017/11/23.
 */
public class UserController extends Controller {
    public final static String CONTROLLER_KEY = "/user";

    @ActionKey("/login")
    public void login() {
        renderFreeMarker("/views/login.ftl");
    }

    @ActionKey("/dologin")
    @Before(POST.class)
    public void doLogin() {
        String username = getPara("username");
        String password = getPara("password");
        try {
            String backPassword = null;
            try {
                String salt = PropKit.get("dbmeta");
                byte[] bytesOfMessage = (password + salt).getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] thedigest = md.digest(bytesOfMessage);
                BigInteger bigInt = new BigInteger(1, thedigest);
                backPassword = bigInt.toString(16);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            SecurityUtils.getSubject().login(new UsernamePasswordToken(
                    username
                    , backPassword
                    , false
            ));
            redirect("/");
        } catch (AuthenticationException e) {
            //虽然在realm中有具体的错误信息，但是安全起见，统一返回登录失败
            LogKit.error(e.getMessage(), e);
            redirect("/login");
        } catch (Exception ex) {
            redirect("/login");
        }

    }


    @ActionKey("/dologout")
    @Before(GET.class)
    public void doLogout() {
        SecurityUtils.getSubject().logout();
        redirect("/");
    }
}
