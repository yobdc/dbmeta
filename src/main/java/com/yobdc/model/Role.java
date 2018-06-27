package com.yobdc.model;

import com.jfinal.plugin.activerecord.Model;

import java.util.*;
import java.util.stream.Collectors;

public class Role extends Model<Role> {
    public static final Role dao = new Role().dao();

    public Set<String> findRolesByUsername(String username) {
        List<Role> roles = Role.dao.find("select sys_role.name from sys_role " +
                " left join sys_user on sys_role.id = sys_user.role_id" +
                " where sys_user.username = ?", username);

        Set<String> roleSet = new HashSet<>();
        if (roles != null && !roles.isEmpty()) {
            for (Role role : roles) {
                String str = role.getStr("name");
                if (str != null) {
                    roleSet.add(str);
                }
            }
        }

        return roleSet;
    }

    public List<Role> listAllRoles() {
        return Role.dao.find("select * from sys_role");
    }

    public Map<Long, String> getRolesMap() {
        List<Role> roles = listAllRoles();
        Map<Long, String> rolesMap = new HashMap<>();
        if (roles != null) {
            rolesMap = roles.stream().collect(Collectors.toMap(Role::getId, Role::getNickame));
        }
        return rolesMap;
    }

    public Long getId() {
        return get("id");
    }

    public String getNickame() {
        return get("nickname");
    }
}
