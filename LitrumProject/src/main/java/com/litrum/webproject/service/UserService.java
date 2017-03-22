package com.litrum.webproject.service;

import com.litrum.webproject.form.RegisterForm;

/**
 * Created by Pc on 21/03/2017.
 */
public interface UserService {

    /**
     * this API is added for creating end user registration records.
     */
    void endUserRegister(RegisterForm registerForm);
}
