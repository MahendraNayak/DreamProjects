package com.litrum.webproject.service;

import com.litrum.webproject.dao.DAOFactory;
import com.litrum.webproject.model.AdminUserRegistration;
import com.litrum.webproject.model.MainCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
