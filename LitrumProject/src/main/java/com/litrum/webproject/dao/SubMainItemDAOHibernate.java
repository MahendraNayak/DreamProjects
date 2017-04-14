package com.litrum.webproject.dao;

import com.litrum.webproject.model.SubMainItem;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

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
}
