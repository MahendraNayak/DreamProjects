package com.litrum.webproject.dao;

import com.litrum.webproject.model.AdminUserRole;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Pc on 25/03/2017.
 */
public class AdminUserRoleDAOHibernate extends GenericDAOHibernate<AdminUserRole, Long>
        implements AdminUserRoleDAO {

    @Override
    public AdminUserRole findAdminUserRoleByName(String userRoleName) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("roleName", userRoleName));
        return (AdminUserRole) criteria.uniqueResult();
    }

    @Override
    public boolean isExistAdminUserRoleByName(String userRoleName) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("roleName", userRoleName));
        return criteria.uniqueResult() != null;
    }
}
