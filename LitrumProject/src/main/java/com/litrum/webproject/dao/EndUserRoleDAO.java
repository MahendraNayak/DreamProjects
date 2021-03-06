package com.litrum.webproject.dao;

import com.litrum.webproject.model.EndUserRole;

import java.util.List;

/**
 * Created by Pc on 24/03/2017.
 */
public interface EndUserRoleDAO extends GenericeDAO<EndUserRole, Long> {

    EndUserRole findByRoleNameAndCompanyType(String roleName, Long companyTypeId);

    List<EndUserRole> findByCompanyTypeId(Long companyTypeId);

    boolean isExistEndUserRoleByName(String userRoleName);

    long countByCompanyTypeId(Long companyTypeId);
}
