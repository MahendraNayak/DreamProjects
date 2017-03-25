package com.litrum.webproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by Pc on 21/03/2017.
 */
@Entity
@Table(name = "enduser_role")
public class EndUserRole extends PersistentObject {

    private String roleName;
    private CompanyType companyType;

    @Column(name = "role_name", nullable = false)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = CompanyType.class)
    @JoinColumn(name = "company_type_id", nullable = false)
    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("roleName", roleName)
                .append("companyType", companyType)
                .toString();
    }
}
