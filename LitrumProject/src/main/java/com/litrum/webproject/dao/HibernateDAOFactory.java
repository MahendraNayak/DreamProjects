package com.litrum.webproject.dao;

import com.litrum.webproject.model.AdminUserRegistration;
import com.litrum.webproject.model.CompanyType;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Pc on 21/03/2017.
 */
public class HibernateDAOFactory extends DAOFactory {

    private static final Logger logger = LoggerFactory.getLogger(HibernateDAOFactory.class);

    @Autowired
    private SessionFactory sessionFactory;

    private GenericDAOHibernate instantiateDAO(Class daoClass) {
        try {
            logger.trace("Instantiating DAO: {}", daoClass);
            GenericDAOHibernate daoInstance = (GenericDAOHibernate) daoClass.newInstance();
            daoInstance.setSession(getSessionFactory().getCurrentSession()); // set session factory
            return daoInstance;
        } catch (InstantiationException | IllegalAccessException ex) {
            logger.error("Can not instantiate DAO: " + daoClass, ex);
            return null;
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @SuppressWarnings("unused")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //create instance of dao class and also provides session.
    public EndUserRegistrationDAO getEndUserRegistrationDAO() {
        return (EndUserRegistrationDAO) instantiateDAO(EndUserRegistrationDAOHibernate.class);
    }

    @Override
    public CompanyTypeDAO getCompanyTypeDAO() {
        return (CompanyTypeDAO) instantiateDAO(CompanyTypeDAOHibernate.class);
    }

    @Override
    public EndUserRoleDAO getEndUserRoleDAO() {
        return (EndUserRoleDAO) instantiateDAO(EndUserRoleDAOHibernate.class);
    }

    @Override
    public ServiceOfferedDAO getServiceOfferedDAO() {
        return (ServiceOfferedDAO) instantiateDAO(ServiceOfferedDAOHibernate.class);
    }

    @Override
    public CompanyCItyDAO getCompanyCItyDAO() {
        return (CompanyCItyDAO) instantiateDAO(CompanyCityDAOHibernate.class);
    }

    @Override
    public AdminUserRoleDAO getAdminUserRoleDAO() {
        return (AdminUserRoleDAO) instantiateDAO(AdminUserRoleDAOHibernate.class);
    }

    @Override
    public MainCategoryDAO getMainCategoryDAO() {
        return (MainCategoryDAO) instantiateDAO(MainCategoryDAOHibernate.class);
    }

    @Override
    public SubMainCategoryDAO getSubMainCategoryDAO() {
        return (SubMainCategoryDAO) instantiateDAO(SubMainCategoryDAOHibernate.class);
    }

    @Override
    public SubSubMainCategoryDAO getSubSubMainCategoryDAO() {
        return (SubSubMainCategoryDAO) instantiateDAO(SubSubMainCategoryDAOHibernate.class);
    }

    @Override
    public AdminUserRegistrationDAO getAdminUserRegistrationDAO() {
        return (AdminUserRegistrationDAO) instantiateDAO(AdminUserRegistrationDAOHibernate.class);
    }

    @Override
    public MainItemDAO getMainItemDAO() {
        return (MainItemDAO) instantiateDAO(MainItemDAOHibernate.class);
    }

    @Override
    public LoadUnitDAO getLoadUnitDAO() {
        return (LoadUnitDAO) instantiateDAO(LoadUnitDAOHibernate.class);
    }

    @Override
    public RateCityDAO getRateCityDAO() {
        return (RateCityDAO) instantiateDAO(RateCityDAOHibernate.class);
    }

    @Override
    public MainItemContractorDAO getMainItemContractorDAO() {
        return (MainItemContractorDAO) instantiateDAO(MainItemContractorDAOHibernate.class);
    }

    @Override
    public MainItemMakerDAO getMainItemMakerDAO() {
        return (MainItemMakerDAO) instantiateDAO(MainItemMakerDAOHibernate.class);
    }

    @Override
    public SubMainItemDAO getSubMainItemDAO() {
        return (SubMainItemDAO) instantiateDAO(SubMainItemDAOHibernate.class);
    }

    @Override
    public SubMainItemContractorDAO getSubMainItemContractorDAO() {
        return (SubMainItemContractorDAO) instantiateDAO(SubMainItemContractorDAOHibernate.class);
    }

    @Override
    public SubMainItemMakerDAO getSubMainItemMakerDAO() {
        return (SubMainItemMakerDAO) instantiateDAO(SubMainItemMakerDAOHibernate.class);
    }
}
