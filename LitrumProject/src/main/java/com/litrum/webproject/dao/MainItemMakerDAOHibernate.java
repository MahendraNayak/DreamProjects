package com.litrum.webproject.dao;

import com.litrum.webproject.form.ItemsForm;
import com.litrum.webproject.model.MainItemMaker;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Pc on 13/04/2017.
 */
public class MainItemMakerDAOHibernate extends GenericDAOHibernate<MainItemMaker, Long>
        implements MainItemMakerDAO {

    @Override
    public List<MainItemMaker> findByMainItemAndCity(ItemsForm form) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("rateCity", "rateCity");
        criteria.createAlias("mainItem", "mainItem");
        criteria.add(Restrictions.eq("rateCity.id", form.getCityId()));
        criteria.add(Restrictions.eq("mainItem.id", form.getMainItemId()));
        criteria.addOrder(Order.asc("makerName"));
        return criteria.list();
    }

    @Override
    public boolean isExistByMainItemIdAndRateCityAndMakerName(ItemsForm form) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("rateCity", "rateCity");
        criteria.createAlias("mainItem", "mainItem");
        criteria.add(Restrictions.eq("rateCity.id", form.getCityId()));
        criteria.add(Restrictions.eq("mainItem.id", form.getMainItemId()));
        criteria.add(Restrictions.eq("makerName", form.getMakerName()).ignoreCase());
        return null != criteria.uniqueResult();
    }

    @Override
    public MainItemMaker findByMainItemAndRateCityAndMakerName(ItemsForm form) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("rateCity", "rateCity");
        criteria.createAlias("mainItem", "mainItem");
        criteria.add(Restrictions.eq("rateCity.id", form.getCityId()));
        criteria.add(Restrictions.eq("mainItem.id", form.getMainItemId()));
        criteria.add(Restrictions.eq("makerName", form.getMakerName()).ignoreCase());
        return (MainItemMaker) criteria.uniqueResult();
    }

    @Override
    public List<MainItemMaker> findMakerListByMainItemId(ItemsForm form) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("mainItem", "mainItem");
        criteria.add(Restrictions.eq("mainItem.id",form.getMainItemId()));
        criteria.addOrder(Order.asc("makerName"));
        return (List<MainItemMaker>) criteria.list();
    }
}
