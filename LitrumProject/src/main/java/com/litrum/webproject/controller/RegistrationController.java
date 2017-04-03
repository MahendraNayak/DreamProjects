package com.litrum.webproject.controller;

import com.litrum.webproject.form.RegisterForm;
import com.litrum.webproject.model.CompanyType;
import com.litrum.webproject.model.EndUserRole;
import com.litrum.webproject.model.ServiceOffered;
import com.litrum.webproject.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Pc on 18/03/2017.
 */
@Controller
public class RegistrationController {

    private static Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model uiModel){
        RegisterForm registerForm = new RegisterForm();
        uiModel.addAttribute("companyCityList", userService.getAllCompanyCity());
        uiModel.addAttribute("serviceOfferedList", userService.getAllServiceOffered());
        uiModel.addAttribute("form", registerForm);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("registerForm") RegisterForm registerForm, BindingResult bindingResult, Model uiModel) {
        logger.info("registering end user!");
        try {
            userService.createEndUser(registerForm);
            uiModel.addAttribute("successMessage", "End User register successfully.");
        } catch (Exception e) {
            logger.error("Exception while creating end user:{}", e);
            uiModel.addAttribute("errorMessage", e.getMessage());
            return "register";
        }
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model uiModel) {
        logger.warn("Inside login page");
        uiModel.addAttribute("name", "mahendra");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        logger.warn("Inside login page");
        return "login";
    }
}
