package com.litrum.webproject.form;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Pc on 29/03/2017.
 */
public class AdminUserRegistrationForm {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String mobile;
    private String emailId;
    private Long mainCategoryId;
    private Long adminUserRoleId;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getMainCategoryId() {
        return mainCategoryId;
    }

    public void setMainCategoryId(Long mainCategoryId) {
        this.mainCategoryId = mainCategoryId;
    }

    public Long getAdminUserRoleId() {
        return adminUserRoleId;
    }

    public void setAdminUserRoleId(Long adminUserRoleId) {
        this.adminUserRoleId = adminUserRoleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("userName", userName)
                .append("password", password)
                .append("mobile", mobile)
                .append("emailId", emailId)
                .append("mainCategoryId", mainCategoryId)
                .append("adminUserRoleId", adminUserRoleId)
                .toString();
    }
}
