package com.litrum.webproject.dao;

import com.litrum.webproject.model.AdminUserRegistration;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

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

    @Override
    public List<AdminUserRegistration> findByMainCategoryId(Long mainCategoryId) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("mainCategory", "mainCategory");
        criteria.add(Restrictions.eq("mainCategory.id", mainCategoryId));
        return criteria.list();
    }
}
