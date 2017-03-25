package com.litrum.webproject.service;

import com.litrum.webproject.form.RegisterForm;
import com.litrum.webproject.model.CompanyType;
import com.litrum.webproject.model.EndUserRole;
import com.litrum.webproject.model.ServiceOffered;

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

}
