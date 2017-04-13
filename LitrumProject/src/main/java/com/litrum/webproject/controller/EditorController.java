package com.litrum.webproject.controller;

import com.litrum.webproject.Utils.LitrumProjectConstants;
import com.litrum.webproject.form.CategoriesForm;
import com.litrum.webproject.form.ItemsForm;
import com.litrum.webproject.model.MainCategory;
import com.litrum.webproject.model.SubMainCategory;
import com.litrum.webproject.model.SubSubMainCategory;
import com.litrum.webproject.service.EditorService;
import com.litrum.webproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        long SMCID = Long.parseLong(request.getParameter("SMCID"));
        String SMCNAME = request.getParameter("SMCNM");
        System.out.println("SMCID :: " + SMCID + " SMCNAME :: " + SMCNAME);
        List<SubSubMainCategory> subSubMainCategoryList = null;
        CategoriesForm categoriesForm = new CategoriesForm();
        categoriesForm.setSubMainCategoryId(SMCID);
        try {
            subSubMainCategoryList = userService.findBySubMainCategoryId(categoriesForm);
            uiModel.addAttribute("subSubMainCategoryList", subSubMainCategoryList);

            uiModel.addAttribute("SMCID", SMCID);
            uiModel.addAttribute("SMCNAME", SMCNAME);

        } catch (Exception e) {
            logger.debug("Exception editorPannelSSMCHome :: findBySubMainCategoryId " + e.getMessage());
        }

        return "editorviews/editorPannelSSMCHome";
    }

    @RequestMapping(value = "/editorPannelMainItemAdd", method = RequestMethod.POST)
    public String editorPannelMainItemGet(@ModelAttribute("itemForm") ItemsForm form,
                                          @RequestParam("imageFile") MultipartFile imageFile,
                                          @RequestParam("pdfFile") MultipartFile pdfFile,
                                          HttpServletRequest request,
                                          Model uiModel, BindingResult result) {
        if (imageFile.isEmpty() || imageFile.getSize() <= 0) {
            result.rejectValue("imageFile", "Please select file");
        }
        if (!(imageFile.getContentType().toLowerCase().equals("image/jpg")
                || imageFile.getContentType().toLowerCase().equals("image/jpeg")
                || imageFile.getContentType().toLowerCase().equals("image/png")
                || imageFile.getContentType().toLowerCase().equals("image/gif"))) {
            result.rejectValue("imageFile", "Please choose jpg, jpeg, png or gif format image");
        }
        try {
            String imageFileOriginalName = imageFile.getOriginalFilename();
            if (imageFileOriginalName != null && imageFileOriginalName.contains(".")) {
                imageFileOriginalName = imageFileOriginalName.substring(0, imageFileOriginalName.lastIndexOf("."));
            }
            String fileName = imageFileOriginalName + LitrumProjectConstants.UNDER_SCORE + form.getSubSubMainCategoryId() +
                    LitrumProjectConstants.UNDER_SCORE + System.currentTimeMillis();
            String filePath = TMP_DIR + "/imageFolder/"
                    + fileName;

            FileOutputStream fos = new FileOutputStream(filePath);
            fos.write(imageFile.getBytes());
            fos.close();
            form.setImageFileName(fileName);
        } catch (IOException e) {
            logger.error("Exception while process file{}", e);
            return "editorviews/editorPannelMainItemAdd";
        }

        if (pdfFile.isEmpty() || pdfFile.getSize() <= 0) {
            result.rejectValue("pdfFile", "Empty file contents");
        }
        if (!(pdfFile.getContentType().toLowerCase().equals("application/pdf"))) {
            result.rejectValue("pdfFile", "Please choose pdf file");
        }
        try {
            String pdfFileOriginalName = pdfFile.getOriginalFilename();
            if (pdfFileOriginalName != null && pdfFileOriginalName.contains(".")) {
                pdfFileOriginalName = pdfFileOriginalName.substring(0, pdfFileOriginalName.lastIndexOf("."));
            }
            String fileName = pdfFileOriginalName + LitrumProjectConstants.UNDER_SCORE + form.getSubSubMainCategoryId() +
                    LitrumProjectConstants.UNDER_SCORE + System.currentTimeMillis();
            String filePath = TMP_DIR + "/pdfFolder/"
                    + fileName;

            FileOutputStream fos = new FileOutputStream(filePath);
            fos.write(pdfFile.getBytes());
            fos.close();
            form.setPdfFileName(fileName);
        } catch (IOException e) {
            logger.error("Exception while process file{}", e);
            return "editorviews/editorPannelMainItemAdd";
        }

        try {
            editorService.createMainItem(form);
        } catch (Exception e) {
            logger.error("Exception while creating main item{}", e);
        }
        logger.debug(" editorPannelMainItemAdd : GET ");
        return "editorviews/editorPannelMainItemAdd";
    }

    @RequestMapping(value = "/editorPannelMainItemIRAndSRAdd", method = RequestMethod.POST)
    public String addContractorOrMaker(@ModelAttribute("itemForm") ItemsForm form,
                                       Model uiModel, BindingResult result) {
        logger.info("inside add contractor or maker post method");
        try {
            editorService.createMakerOrContractorForMainItem(form);
        } catch (Exception e) {
            logger.error("Exception while creaing contractor or maker{}", e);
        }
        if (form != null && LitrumProjectConstants.CONTRACTOR.equalsIgnoreCase(form.getItemType())) {
            return "editorviews/editorPannelMainItemIR";
        } else {
            return "editorviews/editorPannelMainItemSR";
        }
    }

    //this called is added if we want to show image into browser then called this method.
    @RequestMapping(value = "/getImage/{fileName}")
    @ResponseBody
    public byte[] getImage(@PathVariable String imageName) {
        String imageFilePath = TMP_DIR + "/imageFolder/" + imageName;
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
        String imageFilePath = TMP_DIR + "/pdfFolder/" + pdfFileName;
        Path path = Paths.get(imageFilePath);
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            logger.error("Exception while reading byte from file{}", e);
        }
        return null;
    }
}
