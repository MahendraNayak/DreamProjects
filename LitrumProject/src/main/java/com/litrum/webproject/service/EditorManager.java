package com.litrum.webproject.service;

import com.litrum.webproject.Utils.LitrumProjectConstants;
import com.litrum.webproject.dao.DAOFactory;
import com.litrum.webproject.form.ItemsForm;
import com.litrum.webproject.form.SubMainItemsForm;
import com.litrum.webproject.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pc on 12/04/2017.
 */
@Service("editorService")
public class EditorManager implements EditorService {

    private static final Logger logger = LoggerFactory.getLogger(UserManager.class);
    @Autowired
    private DAOFactory daoFactory;

    public DAOFactory getDaoFactory() {
        return daoFactory;
    }


    @Override
    @Transactional
    public String getLoggedInUser() {
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetails != null) {
            return userDetails.getUsername();
        }
        return null;
    }

    @Override
    @Transactional
    public MainCategory findMainCatgoryByLoggedInUser() {
        String loginUserName = getLoggedInUser();
        AdminUserRegistration user = daoFactory.getAdminUserRegistrationDAO().findByUserName(loginUserName);
        MainCategory mainCategory = user.getMainCategory();
        return mainCategory;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void createMainItem(ItemsForm form) throws Exception {
        if (null != form && form.getSubSubMainCategoryId() > 0) {
            SubSubMainCategory subSubMainCategory = daoFactory.getSubSubMainCategoryDAO().findById(form.getSubSubMainCategoryId(), false);
            if (null != subSubMainCategory) {
                MainItem mainItem = daoFactory.getMainItemDAO().findByShortDescription(form.getShortDescription());
                if (null == mainItem) {
                    mainItem = new MainItem();
                    mainItem.setShortDescription(form.getShortDescription());
                    mainItem.setLongDescription(form.getLongDescription());
                    mainItem.setImageName(form.getImageFileName());
                    mainItem.setTechSpecificationName(form.getPdfFileName());
                    mainItem.setMainItemStatus(LitrumProjectConstants.PENDING);
                    if (form.getSubItemForMainItem() != null && LitrumProjectConstants.YES.equalsIgnoreCase(form.getSubItemForMainItem())) {
                        mainItem.setSubMainItemForMainItem(true);
                    } else {
                        mainItem.setSubMainItemForMainItem(false);
                    }

                    LoadUnit loadUnit = daoFactory.getLoadUnitDAO().findById(form.getLoadUnitId(), false);
                    if (null == loadUnit) {
                        throw new Exception("load Unit not found with id, hence cant create main item");
                    }
                    mainItem.setLoadUnit(loadUnit);
                    mainItem.setSubSubMainCategory(subSubMainCategory);
                    daoFactory.getMainItemDAO().makePersistent(mainItem);
                    logger.debug("Main Item created successfully.");
                } else {
                    throw new Exception("MainItem with short description is already exist hence can't create new.");
                }
            } else {
                throw new Exception("SubSubMainCategory Not found while creating main item, hence can't mproceed.");
            }
        } else {
            throw new Exception("Empty item form hence cant proceed for main item creatinon.");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void createMakerOrContractorForMainItem(ItemsForm form) throws Exception {
        if (null != form && form.getMainItemId() > 0) {
            MainItem mainItem = daoFactory.getMainItemDAO().findById(form.getMainItemId(), false);
            if (null == mainItem) {
                throw new Exception("No Main Item found, hence cant proceed for creating contractor ot maker");
            }
            if (null != form.getItemType() && LitrumProjectConstants.MAKER.equalsIgnoreCase(form.getItemType())) {
                MainItemMaker mainItemMaker = new MainItemMaker();
                mainItemMaker.setMainItem(mainItem);
                mainItemMaker.setMakerName(form.getMakerName());
                mainItemMaker.setMakerPriority(form.getMakerPriority());
                mainItemMaker.setMakerRate(form.getMakerPrice());

                RateCity rateCity = daoFactory.getRateCityDAO().findById(form.getCityId(), false);
                if (null == rateCity) {
                    throw new Exception("rate city not found with id, hence cant create rate city");
                }
                mainItemMaker.setRateCity(rateCity);
                daoFactory.getMainItemMakerDAO().makePersistent(mainItemMaker);

            } else if (LitrumProjectConstants.CONTRACTOR.equalsIgnoreCase(form.getItemType())) {
                MainItemContractor mainItemContractor = new MainItemContractor();
                mainItemContractor.setMainItem(mainItem);
                mainItemContractor.setContractorName(form.getContractorName());
                mainItemContractor.setContractorPriority(form.getContractorPriority());
                mainItemContractor.setContractorRate(form.getContractorPrice());

                RateCity rateCity = daoFactory.getRateCityDAO().findById(form.getCityId(), false);
                if (null == rateCity) {
                    throw new Exception("rate city not found with id, hence cant create rate city");
                }
                mainItemContractor.setRateCity(rateCity);
                daoFactory.getMainItemContractorDAO().makePersistent(mainItemContractor);
            }
        } else {
            throw new Exception("empty form values while creating contractor or maker, hence cant proceed.");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<MainItem> getMainItemsBySubSubMainCaegoryId(Long subSubMainCategoryId) {
        return daoFactory.getMainItemDAO().findBySubSubMainCategoryId(subSubMainCategoryId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RateCity> getAllRateCity() {
        return daoFactory.getRateCityDAO().findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public SubMainItem createSubMainItem(SubMainItemsForm form) throws Exception {
        if (form != null && form.getMainItemId() > 0 && form.getLoadUnitId() > 0) {
            MainItem mainItem = daoFactory.getMainItemDAO().findById(form.getMainItemId(), false);
            if (mainItem == null) {
                throw new Exception("main item not found with id, hence can't create sub main item");
            }
            LoadUnit loadUnit = daoFactory.getLoadUnitDAO().findById(form.getLoadUnitId(), false);
            if (loadUnit == null) {
                throw new Exception("load unit not found with id, hence can't create sub main item");
            }
            SubMainItem subMainItem = daoFactory.getSubMainItemDAO().findSubMainItemByShortDescription(form.getShortDecription());
            if (null == subMainItem) {
                subMainItem = new SubMainItem();
                subMainItem.setShortDescription(form.getShortDecription());
                subMainItem.setMainItem(mainItem);
                subMainItem.setLoadUnit(loadUnit);
                logger.info("sub main item created successfully.");
                return daoFactory.getSubMainItemDAO().makePersistent(subMainItem);
            } else {
                throw new Exception("Sub Main item already exist with short decription hence, can't create new.");
            }
        } else {
            throw new Exception("Main Item not found while creating sub main item.");
        }
    }
}
