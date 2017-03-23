package com.litrum.webproject.dao;

import com.litrum.webproject.model.CompanyType;

/**
 * Created by Pc on 24/03/2017.
 */
public interface CompanyTypeDAO extends GenericeDAO<CompanyType, Long> {

    CompanyType findByCompanyType(String type);
}
