package com.litrum.webproject.controller;

import com.litrum.webproject.form.AdminUserRegistrationForm;
import com.litrum.webproject.form.CategoriesForm;
import com.litrum.webproject.form.CompanyTypeAndUserRolesForm;
import com.litrum.webproject.model.*;
import com.litrum.webproject.service.UserService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        uiModel.addAttribute("AllEndUsersCount", userService.getAllEndUserCounts());
        List<EndUserRegistration> endUserList = userService.getAllEndUsers();
        uiModel.addAttribute("AllEndUserList", endUserList);
        logger.debug(" adminPannelHome : GET ");
        return "adminPannelHome";
    }

    
    @RequestMapping(value = "/adminPannelMainCat", method = RequestMethod.GET)
    public String mainCategory(Model uiModel) {
        logger.debug(" adminPannelMainCat : GET ");
        List<MainCategory> mainCategoryList = userService.getAllMainCategoryList();
        uiModel.addAttribute("mainCategoryList",mainCategoryList);
        return "adminPannelMainCat";
    }

    @RequestMapping(value = "/adminPannelMainCat", method = RequestMethod.POST)
    public String createmainCategory(@ModelAttribute("categories") CategoriesForm categoriesForm, Model uiModel) {
        try{
            logger.debug(" adminPannelMainCat : POST ");
            userService.createMainCategory(categoriesForm);
            logger.debug("Main Category created successfully.");
        }catch(Exception e){
            logger.debug("Exception while createMainCategory :: "+e.getMessage());
        }

        return "redirect:adminPannelMainCat";
    }

    @RequestMapping(value = "/adminPannelSubMainCat", method = RequestMethod.GET)
    public String subMainCategory(Model uiModel) {
        List<MainCategory> mainCategoryList = userService.getAllMainCategoryList();
        uiModel.addAttribute("mainCategoryList",mainCategoryList);
        return "adminPannelSubMainCat";
    }

    @RequestMapping(value = "/adminPannelSubMainCat", method = RequestMethod.POST)
    public String createSubMainCategory(Model uiModel,@ModelAttribute("categories") CategoriesForm categoriesForm) {
        try{
            logger.debug(" adminPannelSubMainCat : POST ");
            userService.createSubMainCategory(categoriesForm);
            logger.debug("Sub Main Category created successfully.");
        }catch(Exception e){
            logger.debug("Exception while createSubMainCategory :: "+e.getMessage());
        }

        return "redirect:adminPannelSubMainCat";
    }


    @RequestMapping(value = "/adminPannelSubSubMainCat", method = RequestMethod.GET)
    public String subSubMainCategory(Model uiModel) {
        List<MainCategory> mainCategoryList = userService.getAllMainCategoryList();
        uiModel.addAttribute("mainCategoryList",mainCategoryList);
        return "adminPannelSubSubMainCat";
    }

    @RequestMapping(value = "/adminPannelSubSubMainCat", method = RequestMethod.POST)
    public String createSubSubMainCategory(Model uiModel,@ModelAttribute("categories") CategoriesForm categoriesForm) {
        try{
            logger.debug(" adminPannelSubSubMainCat : POST ");
            userService.createSubSubMainCategory(categoriesForm);
            logger.debug("Sub Sub Main Category created successfully.");
        }catch(Exception e){
            logger.debug("Exception while adminPannelSubSubMainCat :: "+e.getMessage());
        }

        return "redirect:adminPannelSubSubMainCat";
    }

    @ResponseBody
    @RequestMapping(value = "/adminPannelSubSubMainCatAjax")
    public String addSubMainItemPost(Model uiModel,@ModelAttribute("categories") CategoriesForm categoriesForm) {
        logger.debug("inside adminPannelSubSubMainCatAjax method");
        JSONObject jsonObject = new JSONObject();
        try {
            userService.createSubSubMainCategory(categoriesForm);
            jsonObject.put("MSG","Data Saved Successfully");
        } catch (Exception e) {
            logger.error("Exception while creating sub sub main category :", e);
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/adminPannelEndUserRole", method = RequestMethod.GET)
    public String addEndUserRole(Model uiModel) {
        List<ServiceOffered> serviceOfferedList = userService.getAllServiceOffered();
        uiModel.addAttribute("serviceOfferedList", serviceOfferedList);
        return "adminPannelEndUserRole";
    }

    @RequestMapping(value = "/adminPannelEndUserRole", method = RequestMethod.POST)
    public String addEndUserRoles(@ModelAttribute("companyTypeAndUserRolesForm") CompanyTypeAndUserRolesForm companyTypeAndUserRolesForm, Model uiModel) {
        logger.info("inside add end user role post method");
        try {
            userService.createEndUserRole(companyTypeAndUserRolesForm);
        } catch (Exception e) {
            logger.error("Exception while create or update end user role.{}", e);
        }
        return "redirect:adminPannelEndUserRole";
    }

    @RequestMapping(value = "/adminPannelUserRole", method = RequestMethod.GET)
    public String addUserRole(Model uiModel) {
        logger.info("Inside add admin user role get method");
        List<AdminUserRole> adminUserRoleList = userService.getAllAdminUserRole();
        uiModel.addAttribute("adminUserRoleList", adminUserRoleList);
        return "adminPannelUserRole";
    }

    @RequestMapping(value = "/adminPannelUserRole", method = RequestMethod.POST)
    public String addAdminUserRole(@ModelAttribute("companyTypeAndUserRolesForm") CompanyTypeAndUserRolesForm companyTypeAndUserRolesForm, Model uiModel) {
        logger.info("Inside create admin user role post method");
        try {
            userService.createAdminUserRole(companyTypeAndUserRolesForm);
        } catch (Exception e) {
            logger.error("Exception while create admin user role{}", e);
        }
        return "redirect:adminPannelUserRole";
    }

    @RequestMapping(value = "/adminPannelAuth", method = RequestMethod.GET)
    public String authentication(Model uiModel) {
        return "adminPannelAuth";
    }

    @RequestMapping(value = "/adminPannelUserReg", method = RequestMethod.GET)
    public String getInternalUserRoles(Model uiModel) {
        logger.info(" adminPannelUserReg : GET ");
        List<AdminUserRole> adminUserRoles = userService.getAllAdminUserRole();
        List<MainCategory> allMainCategoryList = userService.getAllMainCategoryList();
        List<AdminUserRegistration> adminPannelRegisterUsers = userService.getAllAdminPannelRegisterUsers();
        uiModel.addAttribute("adminUserRoleList", adminUserRoles);
        uiModel.addAttribute("allMainCategoryList", allMainCategoryList);
        uiModel.addAttribute("adminPannelRegisterUsers", adminPannelRegisterUsers);
        logger.info(" adminPannelUserReg : GET END ");
        return "adminPannelUserReg";
    }

    @RequestMapping(value = "/adminPannelUserReg", method = RequestMethod.POST)
    public String createInternalUser(@ModelAttribute("adminUserRegistrationForm") AdminUserRegistrationForm adminUserRegistrationForm, Model uiModel) {
        logger.info(" adminPannelUserReg : POST ");
        try {
            userService.createAdminUser(adminUserRegistrationForm);
        } catch (Exception e) {
            logger.info("Exception : adminPannelUserReg :: "+e.getMessage());
        }
        return "redirect:adminPannelUserReg";
    }

    @RequestMapping(value = "/adminPannelComType", method = RequestMethod.GET)
    public String addCompanyType(Model uiModel) {
        List<ServiceOffered> serviceOfferedList = userService.getAllServiceOffered();
        uiModel.addAttribute("serviceOfferedList", serviceOfferedList);
        return "adminPannelComType";
    }

    @RequestMapping(value = "/adminPannelComType", method = RequestMethod.POST)
    public String createCompanyType(@ModelAttribute("companyTypeAndUserRolesForm") CompanyTypeAndUserRolesForm companyTypeAndUserRolesForm, Model uiModel) {
        try {
            logger.debug(" adminPannelSubMainCat : POST ");
            userService.createCompanyType(companyTypeAndUserRolesForm);
            logger.debug("Sub Main Category created successfully.");
        } catch (Exception e) {
            logger.debug("Exception while createSubMainCategory :: " + e.getMessage());
        }

        return "redirect:adminPannelComType";
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
    @RequestMapping(value = "/create/mainCategory")
    public String createAndListMainCategory(@ModelAttribute("categories") CategoriesForm categoriesForm) {
        logger.debug("Inside create main category method.");
        List<JSONObject> list = new ArrayList<>();
        try {
            List<MainCategory> mainCategoryList = userService.getAllMainCategoryList();
            for (MainCategory mainCategory : mainCategoryList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("mainCategoryId", mainCategory.getId());
                jsonObject.put("name", mainCategory.getCategoryName());
                list.add(jsonObject);
            }
            return list.toString();
        } catch (Exception e) {
            logger.error("Exception while create/list main category{}", e.getMessage());
        }
        return null;
    }


    @ResponseBody
    @RequestMapping(value = "/subMainCategory/list")
    public String listSubMainCategory(@ModelAttribute("categories") CategoriesForm categoriesForm) {
        logger.debug("Inside get list of sub main category based on main category method.");
        List<JSONObject> list = new ArrayList<>();
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

    @ResponseBody
    @RequestMapping(value = "/subSubMainCategory/list")
    public String listSubSubMainCategory(@ModelAttribute("categories") CategoriesForm categoriesForm) {
        logger.debug("inside get sub sub main category list");
        List<JSONObject> list = new ArrayList<>();
        try {
            List<SubSubMainCategory> subSubMainCategoryList = userService.findBySubMainCategoryId(categoriesForm);
            for (SubSubMainCategory subSubMainCategory : subSubMainCategoryList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("subSubMainCategoryId", subSubMainCategory.getId());
                jsonObject.put("name", subSubMainCategory.getSubSubMainCategoryName());
                list.add(jsonObject);
            }
            return list.toString();
        } catch (Exception e) {
            logger.error("Exception while getting list of sub sub main category");
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/serviceOffered", method = RequestMethod.GET)
    public String serviceOfferedList() {
        logger.info("Inside service offered method");
        List<JSONObject> list = new ArrayList<>();
        try {
            List<ServiceOffered> serviceOfferedList = userService.getAllServiceOffered();
            for (ServiceOffered serviceOffered : serviceOfferedList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("serviceOfferedId", serviceOffered.getId());
                jsonObject.put("name", serviceOffered.getName());
                list.add(jsonObject);
            }
            return list.toString();
        } catch (Exception e) {
            logger.error("Exception while getting list of service offered");
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/companyType/list")
    public String companyTypeList(@ModelAttribute("companyTypeAndUserForm") CompanyTypeAndUserRolesForm companyTypeAndUserForm) {
        logger.info("Inside company type method");
        List<JSONObject> list = new ArrayList<>();
        try {
            List<CompanyType> companyTypeList = userService.findByServiceOfferedId(companyTypeAndUserForm.getServiceOfferedId());
            for (CompanyType companyType : companyTypeList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("companyTypeId", companyType.getId());
                jsonObject.put("type", companyType.getType());
                list.add(jsonObject);
            }
            return list.toString();
        } catch (Exception e) {
            logger.error("Exception while getting list of company type");
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/endUserRole/list")
    public String endUserRoleList(@ModelAttribute("companyTypeAndUserForm") CompanyTypeAndUserRolesForm companyTypeAndUserRolesForm) {
        logger.info("Inside endUser role method");
        List<JSONObject> list = new ArrayList<>();
        try {
            List<EndUserRole> endUserRoleList = userService.findByCompanyTypeId(companyTypeAndUserRolesForm.getCompanyTypeId());
            for (EndUserRole endUserRole : endUserRoleList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("endUserRoleId", endUserRole.getId());
                jsonObject.put("roleName", endUserRole.getRoleName());
                list.add(jsonObject);
            }
            return list.toString();
        } catch (Exception e) {
            logger.error("Exception while getting list of end user role");
        }
        return null;
    }
}