package com.litrum.webproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Pc on 25/03/2017.
 */
@Entity
@Table(name = "admin_user_role")
public class AdminUserRole extends PersistentObject {

    private String roleName;
    private String userLoginRole;

    @Column(name = "role_name", nullable = false, unique = true)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Column(name = "user_login_role", nullable = false)
    public String getUserLoginRole() {
        return userLoginRole;
    }

    public void setUserLoginRole(String userLoginRole) {
        this.userLoginRole = userLoginRole;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("roleName", roleName)
                .append("userLoginRole", userLoginRole)
                .toString();
    }
}
