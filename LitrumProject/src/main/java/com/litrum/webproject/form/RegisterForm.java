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
    private String companyCity;
    private String serviceOffered;
    private String companyType;
    private String endUserRole;


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

    public String getCompanyCity() {
        return companyCity;
    }

    public void setCompanyCity(String companyCity) {
        this.companyCity = companyCity;
    }

    public String getServiceOffered() {
        return serviceOffered;
    }

    public void setServiceOffered(String serviceOffered) {
        this.serviceOffered = serviceOffered;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getEndUserRole() {
        return endUserRole;
    }

    public void setEndUserRole(String endUserRole) {
        this.endUserRole = endUserRole;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("userName", userName)
                .append("password", password)
                .append("mobileNumber", mobileNumber)
                .append("emailId", emailId)
                .append("companyCity", companyCity)
                .append("serviceOffered", serviceOffered)
                .append("companyType", companyType)
                .append("endUserRole", endUserRole)
                .toString();
    }
}
