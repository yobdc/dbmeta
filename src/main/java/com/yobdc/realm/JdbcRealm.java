package com.yobdc.realm;

import com.jfinal.kit.PropKit;
import com.yobdc.model.Permission;
import com.yobdc.model.Role;
import com.yobdc.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

/**
 * Created by lex on 2017/11/23.
 */
public class JdbcRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Session session = SecurityUtils.getSubject().getSession();
        info.addStringPermissions((Set<String>) session.getAttribute("perms"));
        info.addStringPermissions((Set<String>) session.getAttribute("roles"));
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = User.dao.findByUsername(token.getUsername());
        String frontPassword = String.valueOf(token.getPassword());
        String backPassword = null;
        try {
            String salt = PropKit.get("dbmeta");
            byte[] bytesOfMessage = (frontPassword + salt).getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            BigInteger bigInt = new BigInteger(1, thedigest);
            backPassword = bigInt.toString(16);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (user != null && user.getPassword().equals(backPassword)) {
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user", user);
            session.setAttribute("perms", Permission.dao.findPermsByUsername(token.getUsername()));
            session.setAttribute("roles", Role.dao.findRolesByUsername(token.getUsername()));
            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), user.getNickname());
        }
        return null;
    }
}
