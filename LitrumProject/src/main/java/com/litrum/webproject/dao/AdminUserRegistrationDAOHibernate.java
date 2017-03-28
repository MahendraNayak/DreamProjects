package com.litrum.webproject.dao;

import com.litrum.webproject.model.AdminUserRegistration;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Pc on 26/03/2017.
 */
public class AdminUserRegistrationDAOHibernate extends GenericDAOHibernate<AdminUserRegistration, Long>
        implements AdminUserRegistrationDAO {

    @Override
    public AdminUserRegistration findByUserName(String username) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("userName", username));
        return (AdminUserRegistration) criteria.uniqueResult();
    }
}
