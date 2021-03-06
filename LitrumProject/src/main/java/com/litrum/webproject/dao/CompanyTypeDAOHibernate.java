package com.litrum.webproject.dao;

import com.litrum.webproject.model.CompanyType;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

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

    @Override
    public List<CompanyType> fidByServiceOfferedId(Long serviceOffereId) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("serviceOffered", "serviceOffered");
        criteria.add(Restrictions.eq("serviceOffered.id", serviceOffereId));
        criteria.addOrder(Order.asc("type"));
        return criteria.list();
    }

    @Override
    public boolean isExistCompanyTypeByName(String companyTypeName) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("type", companyTypeName));
        return criteria.uniqueResult() != null;
    }
}