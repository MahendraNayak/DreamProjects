package com.litrum.webproject.service;

import com.litrum.webproject.dao.DAOFactory;
import com.litrum.webproject.form.RegisterForm;
import com.litrum.webproject.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Pc on 21/03/2017.
 */
@Service("userService")
public class UserManager implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserManager.class);
    @Autowired
    private DAOFactory daoFactory;

    public DAOFactory getDaoFactory() {
        return daoFactory;
    }

    @Transactional
    public void createEndUser(RegisterForm registerForm) throws Exception {
        if (null != registerForm) {

            //get service offered and set to comapany object.
            ServiceOffered serviceOffered = daoFactory.getServiceOfferedDAO().findServiceOfferedByName(registerForm.getServiceOffered());
            if (null == serviceOffered) {
                logger.error("service offered by company not found with name:[{}]", registerForm.getServiceOffered());
                throw new Exception("End user role not found");
            }

            // get company type and set to comany details object
            CompanyType companyType = daoFactory.getCompanyTypeDAO().findByCompanyType(registerForm.getCompanyType());
            if (null == companyType) {
                logger.error("Company type not found with type:[{}]", registerForm.getCompanyType());
                throw new Exception("Company tye not found");
            }

            //get end user role and set to comapany details object.
            EndUserRole endUserRole = daoFactory.getEndUserRoleDAO().findByRoleName(registerForm.getEndUserRole());
            if (null == endUserRole) {
                logger.error("End user role not found with roleName:[{}]", registerForm.getEndUserRole());
                throw new Exception("End user role not found");
            }

            //get the company city for the current user.
            CompanyCity companyCity = daoFactory.getCompanyCItyDAO().findByCityName(registerForm.getCompanyCity());
            if (null == companyCity) {
                logger.error("End user role not found with roleName:[{}]", registerForm.getEndUserRole());
                throw new Exception("Company city not found not found");
            }
            //here we are creating end user registration records.
            EndUserRegistration endUserRegister = new EndUserRegistration();
            endUserRegister.setFirstName(registerForm.getFirstName());
            endUserRegister.setLastName(registerForm.getLastName());
            endUserRegister.setUserName(registerForm.getUserName());
            endUserRegister.setPassword(registerForm.getPassword());
            endUserRegister.setMobileNumber(registerForm.getMobileNumber());
            endUserRegister.setEmailId(registerForm.getEmailId());
            endUserRegister.setCompanyCity(companyCity);
            endUserRegister.setCompanyName(registerForm.getCompanyName());
            // persist the end user registration record into database.
            daoFactory.getEndUserRegistrationDAO().makePersistent(endUserRegister);
            logger.debug("End user details created successfully.");

        } else {
            logger.debug("Empty register form value passed, hence can't create end user.");
        }
    }
}
