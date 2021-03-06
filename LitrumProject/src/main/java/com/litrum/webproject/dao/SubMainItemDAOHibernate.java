package com.litrum.webproject.dao;

import com.litrum.webproject.form.SubMainItemsForm;
import com.litrum.webproject.model.SubMainItem;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Pc on 13/04/2017.
 */
public class SubMainItemDAOHibernate extends GenericDAOHibernate<SubMainItem, Long>
        implements SubMainItemDAO {

    @Override
    public SubMainItem findSubMainItemByShortDescription(String shortDecription) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("shortDescription", shortDecription));
        return (SubMainItem) criteria.uniqueResult();
    }

    @Override
    public List<SubMainItem> findByMainItemId(Long mainItemId) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("mainItem", "mainItem");
        criteria.add(Restrictions.eq("mainItem.id", mainItemId));
        criteria.addOrder(Order.asc("shortDescription"));
        return criteria.list();
    }

    @Override
    public boolean isShortDescriptionExistForSubMainItem(SubMainItemsForm subMainItemsForm) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("mainItem", "mainItem");
        criteria.add(Restrictions.eq("mainItem.id", subMainItemsForm.getMainItemId()));
        criteria.add(Restrictions.eq("shortDescription", subMainItemsForm.getShortDecription()).ignoreCase());
        return null != criteria.uniqueResult();
    }

    @Override
    public List<SubMainItem> findByMainItemIds(List<Long> mainItemIds) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("mainItem", "mainItem");
        criteria.add(Restrictions.in("mainItem.id", mainItemIds));
        criteria.addOrder(Order.asc("shortDescription"));
        return criteria.list();
    }
}
