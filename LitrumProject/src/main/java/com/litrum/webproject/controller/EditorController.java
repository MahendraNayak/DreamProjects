package com.litrum.webproject.controller;

import com.litrum.webproject.Utils.LitrumProjectConstants;
import com.litrum.webproject.form.CategoriesForm;
import com.litrum.webproject.form.ItemsForm;
import com.litrum.webproject.form.SubMainItemsForm;
import com.litrum.webproject.model.*;
import com.litrum.webproject.service.EditorService;
import com.litrum.webproject.service.UserService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vishal on 4/8/2017.
 */

@Controller
public class EditorController {

    private static Logger logger = LoggerFactory.getLogger(EditorController.class);
    public static final String TMP_DIR = System.getProperty("java.io.tmpdir");


    @Autowired
    private EditorService editorService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/editorPannelHome", method = RequestMethod.GET)
    public String editorDashboard(Model uiModel) {

        logger.debug(" editorPannelHome : GET ");
        try {
            MainCategory mainCategory = editorService.findMainCatgoryByLoggedInUser();
            uiModel.addAttribute("mainCategory", mainCategory);

            CategoriesForm form = new CategoriesForm();
            form.setMainCategoryId(mainCategory.getId());

            List<SubMainCategory> subMainCategoryList = userService.findByMainCategoryId(form);
            uiModel.addAttribute("subMainCategory", subMainCategoryList);
        } catch (Exception e) {
            logger.error("Exception while getting categories{}", e);
        }
        return "editorviews/editorPannelHome";
    }

    @RequestMapping(value = "/editorPannelMainItemSR", method = RequestMethod.GET)
    public String editorPannelAddMainItemSR(HttpServletRequest request,Model uiModel) {

        logger.debug(" editorPannelMainItemSR : GET ");

        long SMCID = Long.parseLong(request.getParameter("SMCID"));
        String SMCNAME = request.getParameter("SMCNM");

        long SSMCID = Long.parseLong(request.getParameter("SSMCID"));
        String SSMCNAME = request.getParameter("SSMCNM");

        uiModel.addAttribute("SMCID", SMCID);
        uiModel.addAttribute("SMCNAME", SMCNAME);
        uiModel.addAttribute("SSMCID", SSMCID);
        uiModel.addAttribute("SSMCNAME", SSMCNAME);

        List<MainItem> mainItemList = editorService.getMainItemsBySubSubMainCaegoryId(SSMCID);
        List<RateCity> rateCityList = editorService.getAllRateCity();
        List<LoadUnit> loadUnitList = userService.getAllLoadUnit();

        long mainItemId = 0;
        if(mainItemList != null && mainItemList.size() > 0) mainItemId = mainItemList.get(0).getId();

        uiModel.addAttribute("mainItemId", mainItemId);
        uiModel.addAttribute("mainItemList", mainItemList);
        uiModel.addAttribute("rateCityList", rateCityList);
        uiModel.addAttribute("loadUnitList", loadUnitList);

        return "editorviews/editorPannelMainItemSR";
    }

    @RequestMapping(value = "/editorPannelMainItemIR", method = RequestMethod.GET)
    public String editorPannelAddMainItemIR(HttpServletRequest request,Model uiModel) {

        logger.debug(" editorPannelMainItemIR : GET ");

        long SMCID = Long.parseLong(request.getParameter("SMCID"));
        String SMCNAME = request.getParameter("SMCNM");

        long SSMCID = Long.parseLong(request.getParameter("SSMCID"));
        String SSMCNAME = request.getParameter("SSMCNM");

        uiModel.addAttribute("SMCID", SMCID);
        uiModel.addAttribute("SMCNAME", SMCNAME);
        uiModel.addAttribute("SSMCID", SSMCID);
        uiModel.addAttribute("SSMCNAME", SSMCNAME);

        List<MainItem> mainItemList = editorService.getMainItemsBySubSubMainCaegoryId(SSMCID);
        List<RateCity> rateCityList = editorService.getAllRateCity();
        List<LoadUnit> loadUnitList = userService.getAllLoadUnit();

        long mainItemId = 0;
        if(mainItemList != null && mainItemList.size() > 0) mainItemId = mainItemList.get(0).getId();

        uiModel.addAttribute("mainItemId", mainItemId);
        uiModel.addAttribute("mainItemList", mainItemList);
        uiModel.addAttribute("rateCityList", rateCityList);
        uiModel.addAttribute("loadUnitList", loadUnitList);

        return "editorviews/editorPannelMainItemIR";
    }

    @RequestMapping(value = "/editorPannelMainItemAdd", method = RequestMethod.GET)
    public String editorPannelMainItemGet(HttpServletRequest request ,Model uiModel) {
        logger.debug(" editorPannelMainItemAdd : GET ");
        long SMCID = Long.parseLong(request.getParameter("SMCID"));
        String SMCNAME = request.getParameter("SMCNM");

        long SSMCID = Long.parseLong(request.getParameter("SSMCID"));
        String SSMCNAME = request.getParameter("SSMCNM");

        List<SubSubMainCategory> subSubMainCategoryList = null;
        CategoriesForm categoriesForm = new CategoriesForm();
        categoriesForm.setSubMainCategoryId(SMCID);
        try{
            subSubMainCategoryList = userService.findBySubMainCategoryId(categoriesForm);
            uiModel.addAttribute("subSubMainCategoryList", subSubMainCategoryList);

            List<LoadUnit> loadUnitList = userService.getAllLoadUnit();
            uiModel.addAttribute("loadUnitList", loadUnitList);

            uiModel.addAttribute("SMCID", SMCID);
            uiModel.addAttribute("SMCNAME", SMCNAME);
            uiModel.addAttribute("SSMCID", SSMCID);
            uiModel.addAttribute("SSMCNAME", SSMCNAME);

        }catch (Exception e){
            logger.debug("Exception editorPannelMainItemAdd :: findBySubMainCategoryId "+e.getMessage());
        }

        return "editorviews/editorPannelMainItemAdd";
    }

    @RequestMapping(value = "/editorPannelSSMCHome", method = RequestMethod.GET)
    public String editorPannelSSMCHomeGet(HttpServletRequest request ,Model uiModel) {
        logger.debug(" editorPannelSSMCHome : GET ");
        List<SubSubMainCategory> subSubMainCategoryList = null;
        Long SMCID = Long.parseLong(request.getParameter("SMCID"));

        CategoriesForm categoriesForm = new CategoriesForm();
        categoriesForm.setSubMainCategoryId(SMCID);
        try {
            subSubMainCategoryList = userService.findBySubMainCategoryId(categoriesForm);
            uiModel.addAttribute("subSubMainCategoryList", subSubMainCategoryList);

            uiModel.addAttribute("SMCID", SMCID);
            uiModel.addAttribute("SMCNAME", request.getParameter("SMCNM"));

        } catch (Exception e) {
            logger.debug("Exception editorPannelSSMCHome :: findBySubMainCategoryId " + e.getMessage());
        }

        return "editorviews/editorPannelSSMCHome";
    }

    @RequestMapping(value = "/editorPannelMainItemAdd", method = RequestMethod.POST)
    public String editorPannelMainItemGet(@ModelAttribute("itemForm") ItemsForm form, Model uiModel, HttpServletRequest request, BindingResult result) {
        try {
            uiModel.addAttribute("SMCID", Long.parseLong(request.getParameter("SMCID")));
            uiModel.addAttribute("SMCNM", request.getParameter("SMCNM"));
            uiModel.addAttribute("SSMCID", Long.parseLong(request.getParameter("SSMCID")));
            uiModel.addAttribute("SSMCNM", request.getParameter("SSMCNM"));
        } catch (Exception e) {
            logger.error("Exception ::: " + e.getMessage());
        }

        if (!form.getImageFile().isEmpty() && (form.getImageFile().getContentType().toLowerCase().equals("image/jpg")
                || form.getImageFile().getContentType().toLowerCase().equals("image/jpeg")
                || form.getImageFile().getContentType().toLowerCase().equals("image/png")
                || form.getImageFile().getContentType().toLowerCase().equals("image/gif"))) {

            try {
                String imageFileOriginalName = form.getImageFile().getOriginalFilename();
                String imageFileOriginalNameExtn = imageFileOriginalName;

                if (imageFileOriginalName != null && imageFileOriginalName.contains(".")) {
                    imageFileOriginalName = imageFileOriginalName.substring(0, imageFileOriginalName.lastIndexOf("."));
                }
                String fileName = imageFileOriginalName + LitrumProjectConstants.UNDER_SCORE + form.getSubSubMainCategoryId() +
                        LitrumProjectConstants.UNDER_SCORE + imageFileOriginalNameExtn.substring(imageFileOriginalNameExtn.lastIndexOf("."), imageFileOriginalNameExtn.length());
                String filePath = TMP_DIR + "/" + fileName;

                FileOutputStream fos = new FileOutputStream(filePath);
                fos.write(form.getImageFile().getBytes());
                fos.close();
                form.setImageFileName(fileName);
            } catch (IOException e) {
                logger.error("Exception while process file{}", e);
                return "redirect:/editorPannelMainItemAdd";
            }
        } else if (!form.getImageFile().isEmpty()) {
            result.rejectValue("imageFile", "Please choose jpg, jpeg, png or gif format image");
        }

        if (!form.getPdfFile().isEmpty() && (form.getPdfFile().getContentType().toLowerCase().equals("application/pdf"))) {
            try {
                String pdfFileOriginalName = form.getPdfFile().getOriginalFilename();
                String pdfFileOriginalNameExtn = pdfFileOriginalName;

                if (pdfFileOriginalName != null && pdfFileOriginalName.contains(".")) {
                    pdfFileOriginalName = pdfFileOriginalName.substring(0, pdfFileOriginalName.lastIndexOf("."));
                }
                String fileName = pdfFileOriginalName + LitrumProjectConstants.UNDER_SCORE + form.getSubSubMainCategoryId() +
                        LitrumProjectConstants.UNDER_SCORE + pdfFileOriginalNameExtn.substring(pdfFileOriginalNameExtn.lastIndexOf("."), pdfFileOriginalNameExtn.length());
                ;
                String filePath = TMP_DIR + "/" + fileName;

                FileOutputStream fos = new FileOutputStream(filePath);
                fos.write(form.getPdfFile().getBytes());
                fos.close();
                form.setPdfFileName(fileName);
            } catch (IOException e) {
                logger.error("Exception while process file{}", e);
                return "redirect:/editorPannelMainItemAdd";
            }
        } else if (!form.getPdfFile().isEmpty()) {
            result.rejectValue("pdfFile", "Please choose pdf file");
        }

        if (result.hasErrors()) {
            return "redirect:/editorPannelMainItemAdd";
        }
        try {
            editorService.createMainItem(form);
            uiModel.addAttribute("sucessMessage", "Main Item Has Successfully Added");
        } catch (Exception e) {
            logger.error("Exception while creating main item{}", e);
            uiModel.addAttribute("errorMessage", "Unable to add Main Item");
        }
        logger.debug(" editorPannelMainItemAdd : GET ");
        return "redirect:/editorPannelMainItemAdd";
    }

    @RequestMapping(value = "/editorPannelMainItemIRAndSRAdd", method = RequestMethod.POST)
    public String addContractorOrMaker(@ModelAttribute("itemForm") ItemsForm form,
                                       Model uiModel, HttpServletRequest request,
                                       BindingResult result) {
        logger.info("inside add contractor or maker post method");
        try {
            uiModel.addAttribute("SMCID", Long.parseLong(request.getParameter("SMCID")));
            uiModel.addAttribute("SMCNM", request.getParameter("SMCNM"));
            uiModel.addAttribute("SSMCID", Long.parseLong(request.getParameter("SSMCID")));
            uiModel.addAttribute("SSMCNM", request.getParameter("SSMCNM"));
        } catch (Exception e) {
            logger.error("Exception ::: " + e.getMessage());
        }

        try {
            editorService.createMakerOrContractorForMainItem(form);
        } catch (Exception e) {
            //redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            logger.error("Exception while creaing contractor or maker{}", e);
        }
        if (form != null && LitrumProjectConstants.CONTRACTOR.equalsIgnoreCase(form.getItemType())) {
           // redirectAttributes.addFlashAttribute("successMessge", "Contractor rate saved successfully");
            return "redirect:/editorPannelMainItemIR";
        } else {
           // redirectAttributes.addFlashAttribute("successMessge", "Supplier rate saved successfully");
            return "redirect:/editorPannelMainItemSR";
        }
    }

    @RequestMapping(value = "/editorPannelSubMainItemAdd", method = RequestMethod.GET)
    public String addSubMainItemGet(Model uiModel, HttpServletRequest request) {

        try {
            Long subSubMainCategoryId = Long.parseLong(request.getParameter("SSMCID"));

            uiModel.addAttribute("SMCID", Long.parseLong(request.getParameter("SMCID")));
            uiModel.addAttribute("SMCNAME", request.getParameter("SMCNM"));
            uiModel.addAttribute("SSMCID", subSubMainCategoryId);
            uiModel.addAttribute("SSMCNAME", request.getParameter("SSMCNM"));

            List<MainItem> mainItemList = editorService.getMainItemsBySubSubMainCaegoryId(subSubMainCategoryId);
            uiModel.addAttribute("mainItemList", mainItemList);

            List<LoadUnit> loadUnitList = userService.getAllLoadUnit();
            uiModel.addAttribute("loadUnitList", loadUnitList);

        } catch (Exception e) {
            logger.error("Exception ::: " + e.getMessage());
        }

        return "editorviews/editorPannelSubMainItemAdd";
    }

    @RequestMapping(value = "/editorPannelSubMainItemAdd", method = RequestMethod.POST)
    public String addSubMainItemPost(@ModelAttribute("subMainItemForm") SubMainItemsForm form, Model uiModel) {
        logger.debug("inside add sub main item post method");
        try {
            SubMainItem subMainItem = editorService.createSubMainItem(form);

        } catch (Exception e) {
            logger.error("Exception while creating sub main item:", e);
        }
        return "redirect:/editorPannelSubMainItemAdd";
    }

    @RequestMapping(value = "/editorPannelSubMainItemSR", method = RequestMethod.GET)
    public String addSubMainItemSR(Model uiModel, HttpServletRequest request) {
        try {
            uiModel.addAttribute("SMCID", Long.parseLong(request.getParameter("SMCID")));
            uiModel.addAttribute("SMCNAME", request.getParameter("SMCNM"));
            uiModel.addAttribute("SSMCID", Long.parseLong(request.getParameter("SSMCID")));
            uiModel.addAttribute("SSMCNAME", request.getParameter("SSMCNM"));
        } catch (Exception e) {
            logger.error("Exception ::: " + e.getMessage());
        }
        return "editorviews/editorPannelSubMainItemSR";
    }

    @RequestMapping(value = "/editorPannelSubMainItemIR", method = RequestMethod.GET)
    public String addSubMainItemIR(Model uiModel, HttpServletRequest request) {
        try {
            uiModel.addAttribute("SMCID", Long.parseLong(request.getParameter("SMCID")));
            uiModel.addAttribute("SMCNAME", request.getParameter("SMCNM"));
            uiModel.addAttribute("SSMCID", Long.parseLong(request.getParameter("SSMCID")));
            uiModel.addAttribute("SSMCNAME", request.getParameter("SSMCNM"));
        } catch (Exception e) {
            logger.error("Exception ::: " + e.getMessage());
        }
        return "editorviews/editorPannelSubMainItemIR";
    }

    @ResponseBody
    @RequestMapping(value = "/subMainItem/list")
    public String getAllSubMainItemsByMainItemId(@ModelAttribute("subMainItemForm") SubMainItemsForm form) {
        List<JSONObject> list = new ArrayList<>();
        try {
            List<SubMainItem> subMainItemList = editorService.getAllSubMainItemsByMainItemId(form.getMainItemId());
            for (SubMainItem subMainItem : subMainItemList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("subMainItemId", subMainItem.getId());
                jsonObject.put("shortDescription", subMainItem.getShortDescription());
                jsonObject.put("unitName", subMainItem.getLoadUnit().getUnitName());
                list.add(jsonObject);
            }
            return list.toString();
        } catch (Exception e) {
            logger.error("Exception while getting sub main item list based on main item", e);
        }
        return null;
    }
    @RequestMapping(value = "/editorPannelSubMainItemSRORIRAdd", method = RequestMethod.POST)
    public String addSubMainItemSRORIR(@ModelAttribute("subMainItemForm") SubMainItemsForm form) {
        logger.debug("Inside sub main Item SR or IR add post method");
        try {
            editorService.createMakerOrContractorForSubMainItem(form);
        } catch (Exception e) {
            logger.error("Exception while adding sub main item SR or IR", e);
        }
        if (null != form && LitrumProjectConstants.CONTRACTOR.equalsIgnoreCase(form.getSubItemType())) {
            return "redirect:/editorPannelSubMainItemIR";
        } else {
            return "redirect:/editorPannelSubMainItemSR";
        }
    }
    //this called is added if we want to show image into browser then called this method.
    @RequestMapping(value = "/getImage/{fileName}")
    @ResponseBody
    public byte[] getImage(@PathVariable String imageName) {
        String imageFilePath = TMP_DIR + "/" + imageName;
        Path path = Paths.get(imageFilePath);
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            logger.error("Exception while reading byte from file{}", e);
        }
        return null;
    }

    //this called is added if we want to show image into browser then called this method.
    @RequestMapping(value = "/getPdfFile/{pdfFileName}")
    @ResponseBody
    public byte[] getPdfFile(@PathVariable String pdfFileName) {
        String imageFilePath = TMP_DIR + "/" + pdfFileName;
        Path path = Paths.get(imageFilePath);
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            logger.error("Exception while reading byte from file{}", e);
        }
        return null;
    }
}
