package dbmeta.realm;

import dbmeta.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by lex on 2017/11/23.
 */
public class JdbcRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = User.dao.findByUsername(token.getUsername());
        if (user != null && user.getPassword().equals(token.getPassword())) {
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user", user);
            new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), user.getNickname());
        }
        return null;
    }
}
