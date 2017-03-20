package com.litrum.webproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Pc on 21/03/2017.
 */
@Entity
@Table(name = "enduser_role")
public class EndUserRole extends PersistentObject {

    private String roleName;

    @Column(name = "role_name", nullable = false, unique = true)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("roleName", roleName)
                .toString();
    }
}
