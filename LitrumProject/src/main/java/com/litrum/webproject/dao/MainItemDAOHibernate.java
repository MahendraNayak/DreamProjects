package com.litrum.webproject.dao;

import com.litrum.webproject.model.MainItem;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Pc on 13/04/2017.
 */
public class MainItemDAOHibernate extends GenericDAOHibernate<MainItem, Long>
        implements MainItemDAO {

    @Override
    public MainItem findByShortDescription(String shortDescription) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("shortDescription", shortDescription));
        return (MainItem) criteria.uniqueResult();
    }

    @Override
    public List<MainItem> findBySubSubMainCategoryId(Long subSubMainCategoryId) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("subSubMainCategory", "subSubMainCategory");
        criteria.add(Restrictions.eq("subSubMainCategory.id", subSubMainCategoryId));
        return criteria.list();
    }

    @Override
    public List<MainItem> findBySubSubMainCatIds(List<Long> subSubMainCatIds, String status) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("subSubMainCategory", "subSubMainCategory");
        criteria.add(Restrictions.in("subSubMainCategory.id", subSubMainCatIds));
        if (null != status) {
            criteria.add(Restrictions.eq("mainItemStatus", status));
        }
        return criteria.list();
    }

    @Override
    public long countMainItemBySubSubMainCatId(long subSubMainCategoryId, String status) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("subSubMainCategory", "subSubMainCategory");
        criteria.add(Restrictions.eq("subSubMainCategory.id", subSubMainCategoryId));
        if (null != status) {
            criteria.add(Restrictions.eq("mainItemStatus", status));
        }
        criteria.setProjection(Projections.rowCount());
        return (long) criteria.uniqueResult();
    }

    @Override
    public boolean isMainItemExistByShortDescripton(String shortDescription) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("shortDescription", shortDescription));
        return null != criteria.uniqueResult();
    }
}
