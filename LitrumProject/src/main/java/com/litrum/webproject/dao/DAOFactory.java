package com.litrum.webproject.dao;

/**
 * Created by Pc on 21/03/2017.
 */
public abstract class DAOFactory {

    @SuppressWarnings("rawtypes")
    public static DAOFactory instance(Class factory) {
        try {
            //logger.debug("Creating concrete DAO factory: {}", factory);
            return (DAOFactory) factory.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            // logger.error("Can not instantiate factory: {} ", factory, e);
            return null;
        }
    }


    // Add your DAO interfaces here
    public abstract EndUserRegistrationDAO getEndUserRegistrationDAO();

    public abstract CompanyTypeDAO getCompanyTypeDAO();

    public abstract EndUserRoleDAO getEndUserRoleDAO();

    public abstract ServiceOfferedDAO getServiceOfferedDAO();

    public abstract CompanyCItyDAO getCompanyCItyDAO();

    public abstract AdminUserRoleDAO getAdminUserRoleDAO();

}
