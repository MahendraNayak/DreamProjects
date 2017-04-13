package com.litrum.webproject.dao;

import com.litrum.webproject.model.AdminUserRegistration;

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

    public abstract MainCategoryDAO getMainCategoryDAO();

    public abstract SubMainCategoryDAO getSubMainCategoryDAO();

    public abstract SubSubMainCategoryDAO getSubSubMainCategoryDAO();

    public abstract AdminUserRegistrationDAO getAdminUserRegistrationDAO();

    public abstract MainItemDAO getMainItemDAO();

    public abstract LoadUnitDAO getLoadUnitDAO();

    public abstract RateCityDAO getRateCityDAO();

    public abstract MainItemContractorDAO getMainItemContractorDAO();

    public abstract MainItemMakerDAO getMainItemMakerDAO();

    public abstract SubMainItemDAO getSubMainItemDAO();

    public abstract SubMainItemContractorDAO getSubMainItemContractorDAO();

    public abstract SubMainItemMakerDAO getSubMainItemMakerDAO();

}
