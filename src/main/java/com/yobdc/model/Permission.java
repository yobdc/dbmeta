package com.yobdc.model;

import com.jfinal.plugin.activerecord.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permission extends Model<Permission> {
    public static final Permission dao = new Permission().dao();

    public Set<String> findPermsByUsername(String username) {
        List<Permission> perms = Permission.dao.find("select sys_permission.code from sys_permission" +
                " left join sys_role_permission on sys_permission.id = sys_role_permission.permission_id" +
                " left join sys_user on sys_role_permission.role_id = sys_user.role_id \n" +
                " where sys_user.username = ?", username);

        Set<String> permSet = new HashSet<>();
        if (perms != null && !perms.isEmpty()) {
            for (Permission perm : perms) {
                String str = perm.getStr("code");
                if (str != null) {
                    permSet.add(str);
                }
            }
        }

        return permSet;
    }
}
