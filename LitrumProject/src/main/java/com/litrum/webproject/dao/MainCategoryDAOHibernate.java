package com.litrum.webproject.dao;

import com.litrum.webproject.model.MainCategory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Pc on 25/03/2017.
 */
public class MainCategoryDAOHibernate extends GenericDAOHibernate<MainCategory, Long>
        implements MainCategoryDAO {

    @Override
    public List<MainCategory> getAllMainCategoryList() {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.addOrder(Order.asc("categoryName"));
        return criteria.list();
    }

    @Override
    public MainCategory findByCategoryName(String mainCategoryName) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("categoryName", mainCategoryName));
        return (MainCategory) criteria.uniqueResult();
    }

    @Override
    public boolean isExistMainCategoryByName(String name) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("categoryName", name));
        return criteria.uniqueResult() != null;
    }
}
