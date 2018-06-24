package com.yobdc.realm;

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
        if (user != null && user.getPassword().equals(String.valueOf(token.getPassword()))) {
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user", user);
            session.setAttribute("perms", Permission.dao.findPermsByUsername(token.getUsername()));
            session.setAttribute("roles", Role.dao.findRolesByUsername(token.getUsername()));
            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), user.getNickname());
        }
        return null;
    }
}
