package com.litrum.webproject.dao;

import com.litrum.webproject.model.SubMainCategory;
import com.litrum.webproject.model.SubSubMainCategory;
import org.hibernate.Criteria;
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
        return criteria.list();
    }
}
