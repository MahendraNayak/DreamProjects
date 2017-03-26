package com.litrum.webproject.service;

import com.litrum.webproject.Utils.LitrumProjectConstants;
import com.litrum.webproject.dao.DAOFactory;
import com.litrum.webproject.form.CategoriesForm;
import com.litrum.webproject.form.RegisterForm;
import com.litrum.webproject.model.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
            endUserRegister.setServiceOffered(serviceOffered);
            endUserRegister.setCompanyType(companyType);
            endUserRegister.setEndUserRole(endUserRole);
            endUserRegister.setUserLoginRole(LitrumProjectConstants.ROLE_END_USER);
            // persist the end user registration record into database.
            daoFactory.getEndUserRegistrationDAO().makePersistent(endUserRegister);
            logger.debug("End user details created successfully.");

        } else {
            logger.debug("Empty register form value passed, hence can't create end user.");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ServiceOffered> getAllServiceOffered() {
        return daoFactory.getServiceOfferedDAO().findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyType> findByServiceOfferedId(Long serviceOffereId) {
        if (null == serviceOffereId) {
            logger.error("Invalid param passed serviceOfferefId:[{}]", serviceOffereId);
            throw new IllegalArgumentException("invlid param passed");
        }
        return daoFactory.getCompanyTypeDAO().fidByServiceOfferedId(serviceOffereId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EndUserRole> findByCompanyTypeId(Long companyTypeId) {
        if (null == companyTypeId) {
            logger.error("Invalid param passed companyTypeId:[{}]", companyTypeId);
            throw new IllegalArgumentException("invlid param passed");
        }
        return daoFactory.getEndUserRoleDAO().findByCompanyTypeId(companyTypeId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void createMainCategory(CategoriesForm categoriesForm) throws Exception {
        if (null != categoriesForm) {
            MainCategory mainCategory = new MainCategory();
            mainCategory.setCategoryName(categoriesForm.getMainCategoryName());
            daoFactory.getMainCategoryDAO().makePersistent(mainCategory);
            logger.debug("main category creted successfully.");
        } else {
            throw new Exception("categories form does not contains any information, hence we can't create main category.");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void createSubMainCategory(CategoriesForm categoriesForm) throws Exception {
        if (null != categoriesForm) {
            if (null != categoriesForm.getMainCategoryId()) {
                SubMainCategory subMainCategory = new SubMainCategory();
                subMainCategory.setSubMainCategoryName(categoriesForm.getSubMainCategoryName());

                MainCategory mainCategory = daoFactory.getMainCategoryDAO().findById(categoriesForm.getSubMainCategoryId(), false);
                if (mainCategory == null) {
                    logger.error("No category found with id:[{}]", categoriesForm.getMainCategoryId());
                    throw new Exception("No category found while creating sub main category");
                }
                subMainCategory.setMainCategory(mainCategory);
                daoFactory.getSubMainCategoryDAO().makePersistent(subMainCategory);
                logger.debug("Sub Main category created successfully.");
            } else {
                throw new Exception("categories form does not contains Main category Id, hence we can't create sub main category.");
            }
        } else {
            throw new Exception("categories form does not contains any information, hence we can't create sub main category.");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void createSubSubMainCategory(CategoriesForm categoriesForm) throws Exception {
        if (null != categoriesForm) {
            if (null != categoriesForm.getSubMainCategoryId()) {
                SubSubMainCategory subSubMainCategory = new SubSubMainCategory();
                subSubMainCategory.setSubSubMainCategoryName(categoriesForm.getSubSubMainCategoryName());

                SubMainCategory subMainCategory = daoFactory.getSubMainCategoryDAO().findById(categoriesForm.getSubMainCategoryId(), false);
                if (subMainCategory == null) {
                    logger.error("No sub Main category found with id:[{}]", categoriesForm.getSubMainCategoryId());
                    throw new Exception("No sub main category found while creating sub sub main category");
                }
                subSubMainCategory.setSubMainCategory(subMainCategory);
                daoFactory.getSubSubMainCategoryDAO().makePersistent(subSubMainCategory);
                logger.debug("Sub Sub Main category created successfully.");
            } else {
                throw new Exception("categories form does not contains Sub Main category Id, hence we can't create sub sub main category.");
            }
        } else {
            throw new Exception("categories form does not contains any information, hence we can't create sub sub main category.");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<MainCategory> getAllMainCategoryList() {
        return daoFactory.getMainCategoryDAO().findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubMainCategory> findByMainCategoryId(CategoriesForm categoriesForm) throws Exception {
        if (null == categoriesForm.getMainCategoryId()) {
            logger.error("Invalid param passed mainCAtegoryId:[{}]", categoriesForm.getMainCategoryId());
            throw new Exception("Main category Id is null while getting sub main category list.");
        }
        MainCategory mainCategory = daoFactory.getMainCategoryDAO().findById(categoriesForm.getMainCategoryId(), false);
        if (null == mainCategory) {
            logger.error("No main category found with id:[{}] while getting sub main category");
            throw new Exception("No Main category found with id:[" + categoriesForm.getMainCategoryId() + "] " +
                    "while getting sub main category list.");
        }
        return daoFactory.getSubMainCategoryDAO().findByMainCategory(mainCategory);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubSubMainCategory> findBySubMainCategoryId(CategoriesForm categoriesForm) throws Exception {
        if (null == categoriesForm.getSubMainCategoryId()) {
            logger.error("Invalid param passed Sub Main CategoryId:[{}]", categoriesForm.getSubMainCategoryId());
            throw new Exception("Sub Main category Id is null while getting sub sub main category list.");
        }
        SubMainCategory subMainCategory = daoFactory.getSubMainCategoryDAO().findById(categoriesForm.getSubMainCategoryId(), false);
        if (null == subMainCategory) {
            logger.error("No Sub Main category found with id:[{}] while getting sub sub main category");
            throw new Exception("No Sub main category found with id:[" + categoriesForm.getSubMainCategoryId() + "] " +
                    "while getting sub sub main category list.");
        }
        return daoFactory.getSubSubMainCategoryDAO().findBySubMainCategory(subMainCategory);
    }
}
