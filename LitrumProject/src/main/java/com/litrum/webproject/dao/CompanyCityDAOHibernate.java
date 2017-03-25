package com.litrum.webproject.dao;

import com.litrum.webproject.model.CompanyCity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Pc on 25/03/2017.
 */
public class CompanyCityDAOHibernate extends GenericDAOHibernate<CompanyCity, Long>
        implements CompanyCItyDAO {

    @Override
    public CompanyCity findByCityName(String companyCity) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("cityName", companyCity));
        return (CompanyCity) criteria.uniqueResult();
    }
}
