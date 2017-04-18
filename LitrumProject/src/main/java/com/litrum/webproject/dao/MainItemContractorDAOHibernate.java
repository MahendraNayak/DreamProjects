package com.litrum.webproject.dao;

import com.litrum.webproject.form.ItemsForm;
import com.litrum.webproject.model.MainItemContractor;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Pc on 13/04/2017.
 */
public class MainItemContractorDAOHibernate extends GenericDAOHibernate<MainItemContractor, Long>
        implements MainItemContractorDAO {

    @Override
    public List<MainItemContractor> findByMainItemAndCity(ItemsForm form) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("mainItem", "mainItem");
        criteria.createAlias("rateCity", "rateCity");
        criteria.add(Restrictions.eq("mainItem.id", form.getMainItemId()));
        criteria.add(Restrictions.eq("rateCity.id", form.getCityId()));
        return criteria.list();
    }
}
