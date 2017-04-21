package com.litrum.webproject.dao;

import com.litrum.webproject.form.SubMainItemsForm;
import com.litrum.webproject.model.SubMainItemMaker;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Pc on 13/04/2017.
 */
public class SubMainItemMakerDAOHibernate extends GenericDAOHibernate<SubMainItemMaker, Long>
        implements SubMainItemMakerDAO {

    @Override
    public List<SubMainItemMaker> findBySubMainItem(SubMainItemsForm form) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("subMainItem", "subMainItem");
        criteria.add(Restrictions.eq("subMainItem.id", form.getSubMainIemId()));
        return criteria.list();
    }

    @Override
    public boolean isExistBySubMainItemAndMakerName(SubMainItemsForm form) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("subMainItem", "subMainItem");
        criteria.add(Restrictions.eq("subMainItem.id", form.getSubMainIemId()));
        criteria.add(Restrictions.eq("subMainItemMakerName", form.getSubMainItemMakerName()));
        return null != criteria.uniqueResult();
    }
}
