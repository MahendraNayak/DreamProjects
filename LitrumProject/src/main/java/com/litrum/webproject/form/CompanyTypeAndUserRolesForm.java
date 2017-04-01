package com.litrum.webproject.form;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Pc on 28/03/2017.
 */
public class CompanyTypeAndUserRolesForm {

    private Long serviceOfferedId;
    private String companyTypeName;
    private Long companyTypeId;
    private String userRoleName;
    private Long userRoleId;

    public Long getServiceOfferedId() {
        return serviceOfferedId;
    }

    public void setServiceOfferedId(Long serviceOfferedId) {
        this.serviceOfferedId = serviceOfferedId;
    }

    public String getCompanyTypeName() {
        return companyTypeName;
    }

    public void setCompanyTypeName(String companyTypeName) {
        this.companyTypeName = companyTypeName;
    }

    public Long getCompanyTypeId() {
        return companyTypeId;
    }

    public void setCompanyTypeId(Long companyTypeId) {
        this.companyTypeId = companyTypeId;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("serviceOfferedId", serviceOfferedId)
                .append("companyTypeName", companyTypeName)
                .append("companyTypeId", companyTypeId)
                .append("userRoleName", userRoleName)
                .append("userRoleId", userRoleId)
                .toString();
    }
}
