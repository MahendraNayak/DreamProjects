package com.litrum.webproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by Pc on 21/03/2017.
 */
@Entity
@Table(name = "company_details")
public class CompanyDetails extends PersistentObject {

    private String companyCity;
    private EndUserRegistration engUser;
    private ServiceOffered serviceOffered;
    private CompanyType companyType;
    private EndUserRole endUserRole;

    @Column(name = "company_city")
    public String getCompanyCity() {
        return companyCity;
    }

    public void setCompanyCity(String companyCity) {
        this.companyCity = companyCity;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = EndUserRegistration.class)
    @JoinColumn(name = "end_user_id")
    public EndUserRegistration getEngUser() {
        return engUser;
    }

    public void setEngUser(EndUserRegistration engUser) {
        this.engUser = engUser;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ServiceOffered.class)
    @JoinColumn(name = "service_offered_id")
    public ServiceOffered getServiceOffered() {
        return serviceOffered;
    }

    public void setServiceOffered(ServiceOffered serviceOffered) {
        this.serviceOffered = serviceOffered;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = CompanyType.class)
    @JoinColumn(name = "company_type_id")
    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = EndUserRole.class)
    @JoinColumn(name = "end_user_role_id")
    public EndUserRole getEndUserRole() {
        return endUserRole;
    }

    public void setEndUserRole(EndUserRole endUserRole) {
        this.endUserRole = endUserRole;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("companyCity", companyCity)
                .append("engUser", engUser)
                .append("serviceOffered", serviceOffered)
                .append("companyType", companyType)
                .append("endUserRole", endUserRole)
                .toString();
    }
}
