package com.litrum.webproject.dao;

import com.litrum.webproject.form.CategoriesForm;
import com.litrum.webproject.model.SubMainCategory;
import com.litrum.webproject.model.SubSubMainCategory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Pc on 25/03/2017.
 */
public class SubSubMainCategoryDAOHibernate extends GenericDAOHibernate<SubSubMainCategory, Long>
        implements SubSubMainCategoryDAO {

    @Override
    public List<SubSubMainCategory> findBySubMainCategory(SubMainCategory subMainCategory) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("subMainCategory", subMainCategory));
        criteria.addOrder(Order.asc("subSubMainCategoryName"));
        return criteria.list();
    }

    @Override
    public SubSubMainCategory findSubSubManinCategoryByName(CategoriesForm categoriesForm) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("subMainCategory", "subMainCategory");
        criteria.add(Restrictions.eq("subMainCategory.id", categoriesForm.getSubMainCategoryId()));
        criteria.add(Restrictions.eq("subSubMainCategoryName", categoriesForm.getSubSubMainCategoryName()));
        return (SubSubMainCategory) criteria.uniqueResult();
    }

    @Override
    public boolean isExistSubSubMainCatByNameAndSubMainItemId(CategoriesForm categoriesForm) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("subMainCategory", "subMainCategory");
        criteria.add(Restrictions.eq("subMainCategory.id", categoriesForm.getSubMainCategoryId()));
        criteria.add(Restrictions.eq("subSubMainCategoryName", categoriesForm.getSubSubMainCategoryName()));
        return criteria.uniqueResult() != null;
    }

    @Override
    public List<SubSubMainCategory> findBySubMainCatIds(List<Long> subMainCatIds) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("subMainCategory", "subMainCategory");
        criteria.add(Restrictions.in("subMainCategory.id", subMainCatIds));
        criteria.addOrder(Order.asc("subSubMainCategoryName"));
        return criteria.list();
    }
}
