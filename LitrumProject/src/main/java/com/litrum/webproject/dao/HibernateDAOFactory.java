package com.litrum.webproject.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Pc on 21/03/2017.
 */
public class HibernateDAOFactory extends DAOFactory {

    private static final Logger logger = LoggerFactory.getLogger(HibernateDAOFactory.class);

    //TODO need to enable this annotation after data source configuration.
   //@Autowired
    private SessionFactory sessionFactory;

    private GenericDAOHibernate instantiateDAO(Class daoClass) {
        try {
            logger.trace("Instantiating DAO: {}", daoClass);
            GenericDAOHibernate daoInstance = (GenericDAOHibernate) daoClass.newInstance();
            daoInstance.setSession(getSessionFactory().getCurrentSession()); // set session factory
            return daoInstance;
        } catch (InstantiationException ex) {
            logger.error("Can not instantiate DAO: " + daoClass, ex);
            return null;
        } catch (IllegalAccessException e) {
            logger.error("Can not instantiate DAO: " + daoClass, e);
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
}
