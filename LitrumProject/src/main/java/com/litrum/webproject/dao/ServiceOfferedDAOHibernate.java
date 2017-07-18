package com.litrum.webproject.dao;

import com.litrum.webproject.model.ServiceOffered;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Pc on 24/03/2017.
 */
public class ServiceOfferedDAOHibernate extends GenericDAOHibernate<ServiceOffered, Long>
        implements ServiceOfferedDAO {

    @Override
    public ServiceOffered findServiceOfferedByName(String name) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("name", name));
        return (ServiceOffered) criteria.uniqueResult();
    }
}
