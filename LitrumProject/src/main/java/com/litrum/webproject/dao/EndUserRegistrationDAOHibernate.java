package com.litrum.webproject.dao;

import com.litrum.webproject.model.EndUserRegistration;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Pc on 21/03/2017.
 */
public class EndUserRegistrationDAOHibernate extends GenericDAOHibernate<EndUserRegistration, Long>
 implements EndUserRegistrationDAO{


    @Override
    public EndUserRegistration findByUserName(String username) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("userName", username));
        return (EndUserRegistration) criteria.uniqueResult();
    }
}
