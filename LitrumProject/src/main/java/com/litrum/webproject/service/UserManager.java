package com.litrum.webproject.service;

import com.litrum.webproject.Utils.LitrumProjectConstants;
import com.litrum.webproject.dao.DAOFactory;
import com.litrum.webproject.form.AdminUserRegistrationForm;
import com.litrum.webproject.form.CategoriesForm;
import com.litrum.webproject.form.CompanyTypeAndUserRolesForm;
import com.litrum.webproject.form.RegisterForm;
import com.litrum.webproject.model.*;
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
            ServiceOffered serviceOffered = daoFactory.getServiceOfferedDAO().findById(registerForm.getServiceOffered(), false);
            if (null == serviceOffered) {
                logger.error("service offered by company not found with name:[{}]", registerForm.getServiceOffered());
                throw new Exception("End user role not found");
            }

            // get company type and set to comany details object
            CompanyType companyType = daoFactory.getCompanyTypeDAO().findById(registerForm.getCompanyType(), false);
            if (null == companyType) {
                logger.error("Company type not found with type:[{}]", registerForm.getCompanyType());
                throw new Exception("Company tye not found");
            }

            //get end user role and set to comapany details object.
            EndUserRole endUserRole = daoFactory.getEndUserRoleDAO().findById(registerForm.getEndUserRole(), false);
            if (null == endUserRole) {
                logger.error("End user role not found with roleName:[{}]", registerForm.getEndUserRole());
                throw new Exception("End user role not found");
            }

            //get the company city for the current user.
            CompanyCity companyCity = daoFactory.getCompanyCItyDAO().findById(registerForm.getCompanyCity(), false);
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
            if (null != categoriesForm.getMainCategoryId() && categoriesForm.getMainCategoryId() > 0) {
                MainCategory mainCategory = daoFactory.getMainCategoryDAO().getById(categoriesForm.getMainCategoryId(), false);
                if (null != mainCategory && !daoFactory.getMainCategoryDAO().isExistMainCategoryByName(categoriesForm.getMainCategoryName())) {
                    mainCategory.setCategoryName(categoriesForm.getMainCategoryName());
                    logger.debug("main category updated successfully.");
                } else {
                    throw new Exception("invalid main category id passed, hence we cant't update the record.");
                }
            } else {
                MainCategory mainCategory = daoFactory.getMainCategoryDAO().findByCategoryName(categoriesForm.getMainCategoryName());
                if (null == mainCategory) {
                    mainCategory = new MainCategory();
                    mainCategory.setCategoryName(categoriesForm.getMainCategoryName());
                    daoFactory.getMainCategoryDAO().makePersistent(mainCategory);
                    logger.debug("main category creted successfully.");
                } else {
                    throw new Exception("main category already exist with this name.");
                }
            }
        } else {
            throw new Exception("categories form does not contains any information, hence we can't create main category.");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void createSubMainCategory(CategoriesForm categoriesForm) throws Exception {
        if (null != categoriesForm && null != categoriesForm.getMainCategoryId()) {
            if (categoriesForm.getSubMainCategoryId() <= 0) {
                SubMainCategory subMainCategory = daoFactory.getSubMainCategoryDAO().findBySubCategoryName(categoriesForm.getSubMainCategoryName());
                if (null == subMainCategory) {
                    subMainCategory = new SubMainCategory();
                    subMainCategory.setSubMainCategoryName(categoriesForm.getSubMainCategoryName());

                    MainCategory mainCategory = daoFactory.getMainCategoryDAO().getById(categoriesForm.getMainCategoryId(), false);
                    if (mainCategory == null) {
                        logger.error("No category found with id:[{}]", categoriesForm.getMainCategoryId());
                        throw new Exception("No category found while creating sub main category");
                    }
                    subMainCategory.setMainCategory(mainCategory);
                    daoFactory.getSubMainCategoryDAO().makePersistent(subMainCategory);
                    logger.debug("Sub Main category created successfully.");
                } else {
                    throw new Exception("Sub main category already exist with name.");
                }
            } else {
                SubMainCategory subMainCategory = daoFactory.getSubMainCategoryDAO().getById(categoriesForm.getSubMainCategoryId(), false);
                if (null != subMainCategory && !daoFactory.getSubMainCategoryDAO().isExistSubMainCatByName(categoriesForm.getSubMainCategoryName())) {
                    subMainCategory.setSubMainCategoryName(categoriesForm.getSubMainCategoryName());
                } else {
                    throw new Exception("invalid sub main category id, hence we can't update sub main category.");
                }
            }
        } else {
            throw new Exception("categories form does not contains any information, hence we can't create sub main category.");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void createSubSubMainCategory(CategoriesForm categoriesForm) throws Exception {
        if (null != categoriesForm && categoriesForm.getSubMainCategoryId() >=0) {
            if (categoriesForm.getSubSubMainCategoryId() <= 0) {
                SubSubMainCategory subSubMainCategory = daoFactory.getSubSubMainCategoryDAO().findSubSubManinCategoryByName(categoriesForm);
                if (null == subSubMainCategory) {
                    subSubMainCategory = new SubSubMainCategory();
                    subSubMainCategory.setSubSubMainCategoryName(categoriesForm.getSubSubMainCategoryName());

                    SubMainCategory subMainCategory = daoFactory.getSubMainCategoryDAO().getById(categoriesForm.getSubMainCategoryId(), false);
                    if (subMainCategory == null) {
                        logger.error("No sub Main category found with id:[{}]", categoriesForm.getSubMainCategoryId());
                        throw new Exception("No sub main category found while creating sub sub main category");
                    }
                    subSubMainCategory.setSubMainCategory(subMainCategory);
                    daoFactory.getSubSubMainCategoryDAO().makePersistent(subSubMainCategory);
                    logger.debug("Sub Sub Main category created successfully.");
                } else {
                    throw new Exception("sub sub main category already exist with this name.");
                }
            } else {
                SubSubMainCategory subSubMainCategory = daoFactory.getSubSubMainCategoryDAO().getById(categoriesForm.getSubSubMainCategoryId(), false);
                if (null != subSubMainCategory && !daoFactory.getSubSubMainCategoryDAO().isExistSubSubMainCatByNameAndSubMainItemId(categoriesForm)) {
                    subSubMainCategory.setSubSubMainCategoryName(categoriesForm.getSubSubMainCategoryName());
                } else {
                    throw new Exception("invalid id passed for sub sub main category, hence we can't update sub sub main category.");
                }
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
        MainCategory mainCategory = daoFactory.getMainCategoryDAO().getById(categoriesForm.getMainCategoryId(), false);
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
        SubMainCategory subMainCategory = daoFactory.getSubMainCategoryDAO().getById(categoriesForm.getSubMainCategoryId(), false);
        if (null == subMainCategory) {
            logger.error("No Sub Main category found with id:[{}] while getting sub sub main category");
            throw new Exception("No Sub main category found with id:[" + categoriesForm.getSubMainCategoryId() + "] " +
                    "while getting sub sub main category list.");
        }
        return daoFactory.getSubSubMainCategoryDAO().findBySubMainCategory(subMainCategory);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void createCompanyType(CompanyTypeAndUserRolesForm form) throws Exception {
        if (null == form) {
            logger.error("form does not contains any information, hence can't proceed.");
            throw new Exception("Empty form passed.");
        }
        if (null != form.getCompanyTypeId() && form.getCompanyTypeId() <= 0) {
            ServiceOffered serviceOffered = daoFactory.getServiceOfferedDAO().getById(form.getServiceOfferedId(), false);
            if (null != serviceOffered) {
                CompanyType companyType = daoFactory.getCompanyTypeDAO().findByCompanyType(form.getCompanyTypeName());
                if (null == companyType) {
                    companyType = new CompanyType();
                    companyType.setType(form.getCompanyTypeName());
                    companyType.setServiceOffered(serviceOffered);
                    daoFactory.getCompanyTypeDAO().makePersistent(companyType);
                    logger.info("company type created successfully.");
                } else {
                    throw new Exception("company type with this name is already cretaed, hence can't crete new.");
                }
            } else {
                logger.error("No service offered found with id[{}]", form.getServiceOfferedId());
                throw new Exception("No service offered found while creating company type.");
            }
        } else {
            CompanyType companyType = daoFactory.getCompanyTypeDAO().getById(form.getCompanyTypeId(), false);
            if (null != companyType && !daoFactory.getCompanyTypeDAO().isExistCompanyTypeByName(form.getCompanyTypeName())) {
                companyType.setType(form.getCompanyTypeName());
                logger.info("company type updated successfully.");
            } else {
                throw new Exception("invalid company type id passed, hence we can't update the company type");
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void createEndUserRole(CompanyTypeAndUserRolesForm form) throws Exception {
        if (null != form && form.getCompanyTypeId() >= 0) {
            if (form.getUserRoleId() <= 0) {
                EndUserRole endUserRole = daoFactory.getEndUserRoleDAO().findByRoleNameAndCompanyType(form.getUserRoleName(), form.getCompanyTypeId());
                if (null == endUserRole) {
                    endUserRole = new EndUserRole();
                    endUserRole.setRoleName(form.getUserRoleName());

                    CompanyType companyType = daoFactory.getCompanyTypeDAO().findById(form.getCompanyTypeId(), false);
                    if (companyType == null) {
                        logger.error("No company type found with id:[{}]", form.getCompanyTypeId());
                        throw new Exception("No company type found while creating end user role");
                    }
                    endUserRole.setCompanyType(companyType);
                    daoFactory.getEndUserRoleDAO().makePersistent(endUserRole);
                    logger.debug("end user role created successfully.");
                } else {
                    throw new Exception("end user role already exist with this name.");
                }
            } else {
                EndUserRole endUserRole = daoFactory.getEndUserRoleDAO().findById(form.getUserRoleId(), false);
                if (null != endUserRole && !daoFactory.getEndUserRoleDAO().isExistEndUserRoleByName(form.getUserRoleName())) {
                    endUserRole.setRoleName(form.getUserRoleName());
                } else {
                    throw new Exception("invalid id passed for user roleId, hence we can't update end user role.");
                }
            }
        } else {
            throw new Exception("categories form does not contains any information, hence we can't create sub sub main category.");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void createAdminUser(AdminUserRegistrationForm adminUserRegistrationForm) throws Exception {
        if (null == adminUserRegistrationForm) {
            logger.error("form does not contains any information, hence can't proceed.");
            throw new Exception("empty form passed, hence can't proceed.");
        }

        MainCategory mainCategory = daoFactory.getMainCategoryDAO().getById(adminUserRegistrationForm.getMainCategoryId(), false);
        if (null == mainCategory) {
            logger.error("No main category found with id:[{}]", adminUserRegistrationForm.getMainCategoryId());
            throw new Exception("Unable to get main category,hence cant proceed.");
        }

        AdminUserRole adminUserRole = daoFactory.getAdminUserRoleDAO().getById(adminUserRegistrationForm.getAdminUserRoleId(), false);
        if (null == adminUserRole) {
            logger.error("No admin user found with id:[{}]", adminUserRegistrationForm.getAdminUserRoleId());
            throw new Exception("Unable to get admin role, hence cant proceed.");
        }

        AdminUserRegistration adminUserRegistration = new AdminUserRegistration();
        adminUserRegistration.setFirstName(adminUserRegistrationForm.getFirstName());
        adminUserRegistration.setLastName(adminUserRegistrationForm.getLastName());
        adminUserRegistration.setUserName(adminUserRegistrationForm.getUserName());
        adminUserRegistration.setPassword(adminUserRegistrationForm.getPassword());
        adminUserRegistration.setMobile(adminUserRegistrationForm.getMobile());
        adminUserRegistration.setEmailId(adminUserRegistrationForm.getEmailId());
        adminUserRegistration.setMainCategory(mainCategory);
        adminUserRegistration.setAdminUserRole(adminUserRole);
        //TODO discuss if it is required or not.
        //because in this case we know this user and its role are fix so
        // we can get the role and redirect it according to role.
        adminUserRegistration.setUserLoginRole(adminUserRole.getRoleName());
        daoFactory.getAdminUserRegistrationDAO().makePersistent(adminUserRegistration);
        logger.debug("admin user register successfully.");
    }

    @Override
    @Transactional(readOnly = true)
    public long getAllEndUserCounts() {
        return daoFactory.getEndUserRegistrationDAO().countAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<AdminUserRole> getAllAdminUserRole() {
        return daoFactory.getAdminUserRoleDAO().findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void createAdminUserRole(CompanyTypeAndUserRolesForm companyTypeAndUserRolesForm) throws Exception {
        if (null != companyTypeAndUserRolesForm) {
            if (null != companyTypeAndUserRolesForm.getUserRoleId() && companyTypeAndUserRolesForm.getUserRoleId() > 0) {
                AdminUserRole adminUserRole = daoFactory.getAdminUserRoleDAO().getById(companyTypeAndUserRolesForm.getUserRoleId(), false);
                if (null != adminUserRole && !daoFactory.getAdminUserRoleDAO().isExistAdminUserRoleByName(companyTypeAndUserRolesForm.getUserRoleName())) {
                    adminUserRole.setRoleName(companyTypeAndUserRolesForm.getUserRoleName());
                    logger.info("admin role updated successfully.");
                } else {
                    throw new Exception("invalid admin user role id passed, hence can't update it.");
                }
            } else {
                AdminUserRole adminUserRole = daoFactory.getAdminUserRoleDAO().findAdminUserRoleByName(companyTypeAndUserRolesForm.getUserRoleName());
                if (null == adminUserRole) {
                    adminUserRole = new AdminUserRole();
                    adminUserRole.setRoleName(companyTypeAndUserRolesForm.getUserRoleName());
                    daoFactory.getAdminUserRoleDAO().makePersistent(adminUserRole);
                    logger.info("admin user role created succesfully.");
                } else {
                    throw new Exception("Admin user role is already exist with name hence can't create new.");
                }
            }
        } else {
            throw new Exception("Form does not contains any information, hence we can't create admin user role");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyCity> getAllCompanyCity() {
        return daoFactory.getCompanyCItyDAO().findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<EndUserRegistration> getAllEndUsers() {
        return daoFactory.getEndUserRegistrationDAO().findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<LoadUnit> getAllLoadUnit() {
        return daoFactory.getLoadUnitDAO().findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubSubMainCategory> findSubSubMainCategoryBySubMainCatIds(List<Long> subMainCatIds) {
        return daoFactory.getSubSubMainCategoryDAO().findBySubMainCatIds(subMainCatIds);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyType> getAllCompanyType() {
        return daoFactory.getCompanyTypeDAO().findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public long countEndUserRoleByCompanyTypeId(Long companyTypeId) {
        return daoFactory.getEndUserRoleDAO().countByCompanyTypeId(companyTypeId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AdminUserRegistration> getAllAdminPannelRegisterUsers() {
        return daoFactory.getAdminUserRegistrationDAO().findAll();
    }
}
