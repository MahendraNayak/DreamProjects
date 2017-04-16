package com.litrum.webproject.dao;

import com.litrum.webproject.model.AdminUserRegistration;

import java.util.List;

/**
 * Created by Pc on 26/03/2017.
 */
public interface AdminUserRegistrationDAO extends GenericeDAO<AdminUserRegistration, Long> {

    AdminUserRegistration findByUserName(String username);

    List<AdminUserRegistration> findByMainCategoryId(Long mainCategoryId);
}
