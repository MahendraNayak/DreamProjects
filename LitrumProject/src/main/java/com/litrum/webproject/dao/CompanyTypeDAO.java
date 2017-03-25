package com.litrum.webproject.dao;

import com.litrum.webproject.model.CompanyType;

import java.util.List;

/**
 * Created by Pc on 24/03/2017.
 */
public interface CompanyTypeDAO extends GenericeDAO<CompanyType, Long> {

    CompanyType findByCompanyType(String type);

    List<CompanyType> fidByServiceOfferedId(Long serviceOffereId);
}
