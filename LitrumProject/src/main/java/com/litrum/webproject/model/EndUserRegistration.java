package com.litrum.webproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by Pc on 19/03/2017.
 */
@Entity
@Table(name = "registration")
public class EndUserRegistration extends PersistentObject {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String mobileNumber;
    private String emailId;
    private String companyName;
    private CompanyCity companyCity;
    private ServiceOffered serviceOffered;
    private CompanyType companyType;
    private EndUserRole endUserRole;
    private String userLoginRole;

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "user_name", nullable = false, unique = true)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "mobile_No")
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Column(name = "email_Id")
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = CompanyCity.class)
    @JoinColumn(name = "company_city_id", nullable = false)
    public CompanyCity getCompanyCity() {
        return companyCity;
    }

    public void setCompanyCity(CompanyCity companyCity) {
        this.companyCity = companyCity;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ServiceOffered.class)
    @JoinColumn(name = "service_offered_id", nullable = false)
    public ServiceOffered getServiceOffered() {
        return serviceOffered;
    }

    public void setServiceOffered(ServiceOffered serviceOffered) {
        this.serviceOffered = serviceOffered;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = CompanyType.class)
    @JoinColumn(name = "company_type_id", nullable = false)
    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = EndUserRole.class)
    @JoinColumn(name = "end_user_id", nullable = false)
    public EndUserRole getEndUserRole() {
        return endUserRole;
    }

    public void setEndUserRole(EndUserRole endUserRole) {
        this.endUserRole = endUserRole;
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
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("mobileNumber", mobileNumber)
                .append("emailId", emailId)
                .append("companyName", companyName)
                .append("companyCity", companyCity)
                .append("serviceOffered", serviceOffered)
                .append("companyType", companyCity)
                .append("endUserRole", endUserRole)
                .toString();
    }

}
