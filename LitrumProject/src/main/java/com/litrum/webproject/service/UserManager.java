package com.litrum.webproject.service;

import com.litrum.webproject.dao.DAOFactory;
import com.litrum.webproject.form.RegisterForm;
import com.litrum.webproject.model.CompanyDetails;
import com.litrum.webproject.model.EndUserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Pc on 21/03/2017.
 */
@Service("userService")
public class UserManager implements UserService {

    @Autowired
    private DAOFactory daoFactory;

    public DAOFactory getDaoFactory() {
        return daoFactory;
    }

    @Transactional(readOnly = true)
    public void endUserRegister(RegisterForm registerForm) {
        if (null != registerForm) {
            //here we are creating end user registration records.
            EndUserRegistration endUserRegister = new EndUserRegistration();
            endUserRegister.setFirstName(registerForm.getFirstName());
            endUserRegister.setLastName(registerForm.getLastName());
            endUserRegister.setUserName(registerForm.getUserName());
            endUserRegister.setPassword(registerForm.getPassword());
            endUserRegister.setMobileNumber(registerForm.getMobileNumber());
            endUserRegister.setEmailId(registerForm.getEmailId());
            // persist the end user registration record into database.
            //daoFactory.getEndUserRegistrationDAO().makePersistent(endUserRegister);
            //TODO need to create company details also.
        }
    }
}
