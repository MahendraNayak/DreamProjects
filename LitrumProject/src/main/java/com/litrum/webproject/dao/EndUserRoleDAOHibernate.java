package com.litrum.webproject.dao;

import com.litrum.webproject.model.EndUserRole;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Pc on 24/03/2017.
 */
public class EndUserRoleDAOHibernate extends GenericDAOHibernate<EndUserRole, Long>
        implements EndUserRoleDAO {

    @Override
    public EndUserRole findByRoleNameAndCompanyType(String roleName, Long companyTypeId) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("companyType", "companyType");
        criteria.add(Restrictions.eq("companyType.id", companyTypeId));
        criteria.add(Restrictions.eq("roleName", roleName));
        return (EndUserRole) criteria.uniqueResult();
    }

    @Override
    public List<EndUserRole> findByCompanyTypeId(Long companyTypeId) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("companyType", "companyType");
        criteria.add(Restrictions.eq("companyType.id", companyTypeId));
        return criteria.list();
    }

    @Override
    public boolean isExistEndUserRoleByName(String userRoleName) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("roleName", userRoleName));
        return criteria.uniqueResult() != null;
    }

    @Override
    public long countByCompanyTypeId(Long companyTypeId) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("companyType", "companyType");
        criteria.add(Restrictions.eq("companyType.id", companyTypeId));
        criteria.setProjection(Projections.rowCount());
        return (long) criteria.uniqueResult();
    }
}
