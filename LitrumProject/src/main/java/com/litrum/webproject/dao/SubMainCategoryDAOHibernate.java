package com.litrum.webproject.dao;

import com.litrum.webproject.model.MainCategory;
import com.litrum.webproject.model.SubMainCategory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Pc on 25/03/2017.
 */
public class SubMainCategoryDAOHibernate extends GenericDAOHibernate<SubMainCategory, Long>
        implements SubMainCategoryDAO {

    @Override
    public List<SubMainCategory> findByMainCategory(MainCategory mainCategory) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("mainCategory", mainCategory));
        criteria.addOrder(Order.asc("subMainCategoryName"));
        return criteria.list();
    }

    @Override
    public SubMainCategory findBySubCategoryName(String subMainCategoryName) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("subMainCategoryName", subMainCategoryName));
        return (SubMainCategory) criteria.uniqueResult();
    }

    @Override
    public boolean isExistSubMainCatByName(String subMainCategoryName) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("subMainCategoryName", subMainCategoryName));
        return criteria.uniqueResult() != null;
    }
}
