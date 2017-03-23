package com.litrum.webproject.dao;

import com.litrum.webproject.model.EndUserRole;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Pc on 24/03/2017.
 */
public class EndUserRoleDAOHibernate extends GenericDAOHibernate<EndUserRole, Long>
        implements EndUserRoleDAO {

    @Override
    public EndUserRole findByRoleName(String roleName) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("roleName", roleName));
        return (EndUserRole) criteria.uniqueResult();
    }
}
