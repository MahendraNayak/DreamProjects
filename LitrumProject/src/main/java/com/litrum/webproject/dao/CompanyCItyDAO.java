package com.litrum.webproject.dao;

import com.litrum.webproject.model.CompanyCity;

/**
 * Created by Pc on 25/03/2017.
 */
public interface CompanyCItyDAO extends GenericeDAO<CompanyCity, Long> {

    CompanyCity findByCityName(String companyCity);
}
