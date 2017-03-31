package com.litrum.webproject.controller;

import com.litrum.webproject.form.CategoriesForm;
import com.litrum.webproject.model.*;
import com.litrum.webproject.service.UserService;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pc on 25/03/2017.
 */
@Controller
public class AdminController {

    private static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/adminPannelHome", method = RequestMethod.GET)
    public String adminDashboard(Model uiModel) {
        return "adminPannelHome";
    }

    @RequestMapping(value = "/adminPannelMainCat", method = RequestMethod.GET)
    public String mainCategory(Model uiModel) {
        List<MainCategory> mainCategoryList = userService.getAllMainCategoryList();
        uiModel.addAttribute("mainCategoryList",mainCategoryList);
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

    @RequestMapping(value = "/create/mainCategory")
    public
    @ResponseBody
    List<MainCategory> createAndListMainCategory(@ModelAttribute("categories") CategoriesForm categoriesForm) {
        logger.debug("Inside create main category method.");
        try {
            userService.createMainCategory(categoriesForm);
            logger.debug("Main Category created successfully.");
            List<MainCategory> mainCategoryList = userService.getAllMainCategoryList();
            return mainCategoryList;
        } catch (Exception e) {
            logger.error("Exception while create/list main category{}", e.getMessage());
        }
        return null;
    }

    @RequestMapping(value = "/create/subMainCategory")
    public void createSubMainCategory(@ModelAttribute("categories") CategoriesForm categoriesForm) {
        logger.debug("Inside Create sub main category method");
        try {
            userService.createSubMainCategory(categoriesForm);
            logger.debug("Sub Main Category created successfully");
        } catch (Exception e) {
            logger.error("Exception while creating sub main category{}", e.getMessage());
        }
    }

    @RequestMapping(value = "/create/subSubMainCategory")
    public void createSubSubMainCategory(@ModelAttribute("categories") CategoriesForm categoriesForm) {
        logger.debug("Inside Create sub main category method");
        try {
            userService.createSubSubMainCategory(categoriesForm);
            logger.debug("Sub Sub Main Category created successfully");
        } catch (Exception e) {
            logger.error("Exception while creating sub sub main category{}", e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/subMainCategory/list")
    public String listSubMainCategory(@ModelAttribute("categories") CategoriesForm categoriesForm) {
        logger.debug("Inside get list of sub main category based on main category method.");
        List<JSONObject> list = new ArrayList<>();
        JSONObject respObject = new JSONObject();
        try {
            List<SubMainCategory> subMainCategoryList = userService.findByMainCategoryId(categoriesForm);
            for (SubMainCategory subCat : subMainCategoryList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("subMainCategoryId", subCat.getId());
                jsonObject.put("name", subCat.getSubMainCategoryName());
                list.add(jsonObject);
            }
            return list.toString();
        } catch (Exception e) {
            logger.error("exception while getting list of sub main category{}", e);
        }
        return null;
    }

    @RequestMapping(value = "/subSubMainCategory/list")
    public
    @ResponseBody
    List<SubSubMainCategory> listSubSubMainCategory(@ModelAttribute("categories") CategoriesForm categoriesForm) {
        logger.debug("inside get sub sub main category list");
        try {
            List<SubSubMainCategory> subSubMainCategoryList = userService.findBySubMainCategoryId(categoriesForm);
            return subSubMainCategoryList;
        } catch (Exception e) {
            logger.error("Exception while getting list of sub sub main category");
        }
        return null;
    }

    @RequestMapping(value = "/serviceOffered", method = RequestMethod.GET)
    public
    @ResponseBody
    List<ServiceOffered> serviceOfferedList() {
        logger.info("Inside service offered method");
        List<ServiceOffered> serviceOfferedList = userService.getAllServiceOffered();
        return serviceOfferedList;
    }

    @RequestMapping(value = "/companyType/{id}")
    public
    @ResponseBody
    List<CompanyType> companyTypeList(@PathVariable("id") Long serviceOfferedId) {
        logger.info("Inside company type method");
        List<CompanyType> companyTypeList = userService.findByServiceOfferedId(serviceOfferedId);
        return companyTypeList;
    }

    @RequestMapping(value = "/endUserRole/{id}")
    public
    @ResponseBody
    List<EndUserRole> endUserRoleList(@PathVariable("id") Long companyTypeId) {
        logger.info("Inside endUser role method");
        List<EndUserRole> endUserRoleList = userService.findByCompanyTypeId(companyTypeId);
        return endUserRoleList;
    }



}