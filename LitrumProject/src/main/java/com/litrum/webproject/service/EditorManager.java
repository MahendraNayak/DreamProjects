package com.litrum.webproject.service;

import com.litrum.webproject.dao.DAOFactory;
import com.litrum.webproject.form.ItemsForm;
import com.litrum.webproject.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Pc on 12/04/2017.
 */
@Service("editorService")
public class EditorManager implements EditorService {

    private static final Logger logger = LoggerFactory.getLogger(UserManager.class);
    @Autowired
    private DAOFactory daoFactory;

    public DAOFactory getDaoFactory() {
        return daoFactory;
    }


    @Override
    @Transactional
    public String getLoggedInUser() {
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetails != null) {
            return userDetails.getUsername();
        }
        return null;
    }

    @Override
    @Transactional
    public MainCategory findMainCatgoryByLoggedInUser() {
        String loginUserName = getLoggedInUser();
        AdminUserRegistration user = daoFactory.getAdminUserRegistrationDAO().findByUserName(loginUserName);
        MainCategory mainCategory = user.getMainCategory();
        return mainCategory;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void createMainItem(ItemsForm form) throws Exception {
        if (null != form && form.getSubSubMainCategoryId() > 0) {
            SubSubMainCategory subSubMainCategory = daoFactory.getSubSubMainCategoryDAO().findById(form.getSubSubMainCategoryId(), false);
            if (null != subSubMainCategory) {
                MainItem mainItem = daoFactory.getMainItemDAO().findByShortDescription(form.getShortDescription());
                if (null == mainItem) {
                    mainItem = new MainItem();
                    mainItem.setShortDescription(form.getShortDescription());
                    mainItem.setLongDescription(form.getLongDescription());
                    mainItem.setImageName(form.getImageFileName());
                    mainItem.setTechSpecificationName(form.getPdfFileName());

                    LoadUnit loadUnit = daoFactory.getLoadUnitDAO().findById(form.getLoadUnitId(), false);
                    if (null == loadUnit) {
                        throw new Exception("load Unit not found with id, hence cant create main item");
                    }
                    mainItem.setLoadUnit(loadUnit);
                    mainItem.setSubSubMainCategory(subSubMainCategory);
                    daoFactory.getMainItemDAO().makePersistent(mainItem);
                    logger.debug("Main Item created successfully.");
                } else {
                    throw new Exception("MainItem with short description is already exist hence can't create new.");
                }
            } else {
                throw new Exception("SubSubMainCategory Not found while creating main item, hence can't mproceed.");
            }
        } else {
            throw new Exception("Empty item form hence cant proceed for main item creatinon.");
        }
    }
}
