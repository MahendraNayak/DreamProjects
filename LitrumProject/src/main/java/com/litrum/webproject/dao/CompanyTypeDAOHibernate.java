package com.litrum.webproject.dao;

import com.litrum.webproject.model.CompanyType;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Pc on 24/03/2017.
 */
public class CompanyTypeDAOHibernate extends GenericDAOHibernate<CompanyType, Long>
        implements CompanyTypeDAO {

    @Override
    public CompanyType findByCompanyType(String type) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("type", type));
        return (CompanyType) criteria.uniqueResult();
    }
}
