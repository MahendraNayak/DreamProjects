package com.litrum.webproject.dao;

import com.litrum.webproject.form.SubMainItemsForm;
import com.litrum.webproject.model.SubMainItemContractor;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Pc on 13/04/2017.
 */
public class SubMainItemContractorDAOHibernate extends GenericDAOHibernate<SubMainItemContractor, Long>
        implements SubMainItemContractorDAO {

    @Override
    public List<SubMainItemContractor> findBySubMainItem(SubMainItemsForm form) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("subMainItem", "subMainItem");
        criteria.add(Restrictions.eq("subMainItem.id", form.getSubMainIemId()));
        criteria.addOrder(Order.asc("subMainItemContractorName"));
        return criteria.list();
    }

    @Override
    public boolean isExistBySubMainItemAndContractorName(SubMainItemsForm form) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.createAlias("subMainItem", "subMainItem");
        criteria.add(Restrictions.eq("subMainItem.id", form.getSubMainIemId()));
        criteria.add(Restrictions.eq("subMainItemContractorName", form.getSubMainItemContractorName()).ignoreCase());
        return null != criteria.uniqueResult();
    }
}
