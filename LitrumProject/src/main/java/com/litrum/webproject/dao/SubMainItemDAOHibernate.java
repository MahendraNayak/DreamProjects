package com.litrum.webproject.dao;

import com.litrum.webproject.model.SubMainItem;
import org.hibernate.Criteria;
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
        return (SubMainItem) criteria.list();
    }

    @Override
    public List<SubMainItem> findByMainItemId(Long mainItemId) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("mainItem", "mainItem");
        criteria.add(Restrictions.eq("mainItem.id", mainItemId));
        return criteria.list();
    }
}
