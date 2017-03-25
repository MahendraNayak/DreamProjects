package com.litrum.webproject.dao;

import com.litrum.webproject.model.CompanyDetails;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Pc on 24/03/2017.
 */
public class CompanyDetailsDAOHibernate extends GenericDAOHibernate<CompanyDetails, Long>
        implements CompanyDetailsDAO {

    @Override
    public CompanyDetails findByEndUserId(Long endUserId) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("engUser", "user");
        criteria.add(Restrictions.eq("user.id", endUserId));
        return (CompanyDetails) criteria.list();
    }
}
