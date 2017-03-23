package com.litrum.webproject.controller;

import com.litrum.webproject.form.RegisterForm;
import com.litrum.webproject.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        uiModel.addAttribute("form", registerForm);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("registerForm") RegisterForm registerForm, BindingResult bindingResult, Model uiModel) {
        logger.info("registering end user!");
        if (StringUtils.isEmpty(registerForm.getUserName())) {
            bindingResult.rejectValue("userName", messageSource.getMessage("err.enter.username", null, null),
                    "please enter userName");
        }
        if (StringUtils.isEmpty(registerForm.getPassword())) {
            bindingResult.rejectValue("passWord", messageSource.getMessage("err.enter.password", null, null),
                    "please enter passWord");
        }
        if (bindingResult.hasErrors()) {
            logger.error("invalid value passed from form.");
            return "register";
        }
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model uiModel){
        RegisterForm registerForm = new RegisterForm();
        uiModel.addAttribute("form", registerForm);
        return "login";
    }
}
