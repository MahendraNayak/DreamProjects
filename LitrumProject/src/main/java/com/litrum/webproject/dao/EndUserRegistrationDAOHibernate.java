package com.litrum.webproject.dao;

import com.litrum.webproject.model.EndUserRegistration;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Pc on 21/03/2017.
 */
public class EndUserRegistrationDAOHibernate extends GenericDAOHibernate<EndUserRegistration, Long>
 implements EndUserRegistrationDAO{


    private static final Logger logger = LoggerFactory.getLogger(EndUserRegistrationDAOHibernate.class);

    @Override
    public EndUserRegistration findByUserName(String username) {
        logger.debug("Username:{}", username);
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("userName", username));
        return (EndUserRegistration) criteria.uniqueResult();
    }
}
