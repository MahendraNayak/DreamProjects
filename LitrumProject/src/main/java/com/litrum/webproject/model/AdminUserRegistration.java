package com.litrum.webproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by Pc on 26/03/2017.
 */
@Entity
@Table(name = "admin_user_registration")
public class AdminUserRegistration extends PersistentObject {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String mobile;
    private String emailId;
    private String userLoginRole;
    private MainCategory mainCategory;
    private AdminUserRole adminUserRole;

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

    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "email_id")
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Column(name = "user_login_role", nullable = false)
    public String getUserLoginRole() {
        return userLoginRole;
    }

    public void setUserLoginRole(String userLoginRole) {
        this.userLoginRole = userLoginRole;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = MainCategory.class)
    @JoinColumn(name = "main_category_id", nullable = false)
    public MainCategory getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(MainCategory mainCategory) {
        this.mainCategory = mainCategory;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = AdminUserRole.class)
    @JoinColumn(name = "admin_user_role_id", nullable = false)
    public AdminUserRole getAdminUserRole() {
        return adminUserRole;
    }

    public void setAdminUserRole(AdminUserRole adminUserRole) {
        this.adminUserRole = adminUserRole;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("mobile", mobile)
                .append("emailId", emailId)
                .append("userLoginRole", userLoginRole)
                .append("mainCategory", mainCategory)
                .append("adminUserRole", adminUserRole)
                .toString();
    }
}
