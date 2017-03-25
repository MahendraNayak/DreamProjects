package com.litrum.webproject.dao;

import com.litrum.webproject.model.MainCategory;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by Pc on 25/03/2017.
 */
public class MainCategoryDAOHibernate extends GenericDAOHibernate<MainCategory, Long>
        implements MainCategoryDAO {

    @Override
    public List<MainCategory> getAllMainCategoryList() {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        return criteria.list();
    }
}
