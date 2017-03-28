package com.litrum.webproject.service;

import com.litrum.webproject.form.AdminUserRegistrationForm;
import com.litrum.webproject.form.CategoriesForm;
import com.litrum.webproject.form.CompanyTypeAndUserRolesForm;
import com.litrum.webproject.form.RegisterForm;
import com.litrum.webproject.model.*;

import java.util.List;

/**
 * Created by Pc on 21/03/2017.
 */
public interface UserService {

    /**
     * this API is added for creating end user registration records.
     */
    void createEndUser(RegisterForm registerForm) throws Exception;

    List<ServiceOffered> getAllServiceOffered();

    List<CompanyType> findByServiceOfferedId(Long serviceOffereId);

    List<EndUserRole> findByCompanyTypeId(Long companyTypeId);

    void createMainCategory(CategoriesForm categoriesForm) throws Exception;

    void createSubMainCategory(CategoriesForm categoriesForm) throws Exception;

    void createSubSubMainCategory(CategoriesForm categoriesForm) throws Exception;

    List<MainCategory> getAllMainCategoryList();

    List<SubMainCategory> findByMainCategoryId(CategoriesForm categoriesForm) throws Exception;

    List<SubSubMainCategory> findBySubMainCategoryId(CategoriesForm categoriesForm) throws Exception;

    void createCompanyType(CompanyTypeAndUserRolesForm form) throws Exception;

    void createEndUserRole(CompanyTypeAndUserRolesForm form) throws Exception;

    void createAdminUser(AdminUserRegistrationForm adminUserRegistrationForm) throws Exception;
}
