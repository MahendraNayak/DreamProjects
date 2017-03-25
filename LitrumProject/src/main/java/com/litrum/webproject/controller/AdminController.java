package com.litrum.webproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.nio.cs.ext.MacDingbat;

/**
 * Created by Pc on 25/03/2017.
 */
@Controller
public class AdminController {

    private static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping(value = "/adminPannelHome", method = RequestMethod.GET)
    public String adminDashboard(Model uiModel) {
        return "adminPannelHome";
    }

    @RequestMapping(value = "/adminPannelMainCat", method = RequestMethod.GET)
    public String mainCategory(Model uiModel) {
        return "adminPannelMainCat";
    }

    @RequestMapping(value = "/adminPannelSubMainCat", method = RequestMethod.GET)
    public String subMainCategory(Model uiModel) {
        return "adminPannelSubMainCat";
    }

    @RequestMapping(value = "/adminPannelSubSubMainCat", method = RequestMethod.GET)
    public String subSubMainCategory(Model uiMdel) {
        return "adminPannelSubSubMainCat";
    }

    @RequestMapping(value = "/adminPannelAddUserAndRole", method = RequestMethod.GET)
    public String addUserAndRole(Model uiModel) {
        return "adminPannelAddUserAndRole";
    }

    @RequestMapping(value = "/adminPannelAuth", method = RequestMethod.GET)
    public String authentication(Model uiModel) {
        return "adminPannelAuth";
    }

    @RequestMapping(value = "/adminPannelComType", method = RequestMethod.GET)
    public String addCompanyType() {
        return "adminPannelComType";
    }


}
