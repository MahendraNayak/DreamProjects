package com.litrum.webproject.form;

import com.litrum.webproject.model.CompanyType;
import com.litrum.webproject.model.EndUserRegistration;
import com.litrum.webproject.model.EndUserRole;
import com.litrum.webproject.model.ServiceOffered;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Pc on 18/03/2017.
 */
public class RegisterForm {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String mobileNumber;
    private String emailId;
    private String companyName;
    private Long companyCity;
    private Long serviceOffered;
    private Long companyType;
    private Long endUserRole;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getCompanyCity() {
        return companyCity;
    }

    public void setCompanyCity(Long companyCity) {
        this.companyCity = companyCity;
    }

    public Long getServiceOffered() {
        return serviceOffered;
    }

    public void setServiceOffered(Long serviceOffered) {
        this.serviceOffered = serviceOffered;
    }

    public Long getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Long companyType) {
        this.companyType = companyType;
    }

    public Long getEndUserRole() {
        return endUserRole;
    }

    public void setEndUserRole(Long endUserRole) {
        this.endUserRole = endUserRole;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
                .append("companyType", companyType)
                .append("endUserRole", endUserRole)
                .toString();
    }
}
