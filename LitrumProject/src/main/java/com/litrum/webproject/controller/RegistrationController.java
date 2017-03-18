package com.litrum.webproject.controller;

import com.litrum.webproject.form.RegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Pc on 18/03/2017.
 */
@Controller
public class RegistrationController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model uiModel){
        RegisterForm registerForm = new RegisterForm();
        uiModel.addAttribute("form", registerForm);
        return "register";
    }
}
