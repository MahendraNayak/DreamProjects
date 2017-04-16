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
    public void createSubMainItem(SubMainItemsForm form) throws Exception {
        if (form != null && form.getMainItemId() > LitrumProjectConstants.ZERO && form.getLoadUnitId() > LitrumProjectConstants.ZERO) {
            SubMainItem subMainItem;
            MainItem mainItem = daoFactory.getMainItemDAO().findById(form.getMainItemId(), false);
            if (mainItem == null) {
                throw new Exception("main item not found with id, hence can't create sub main item");
            }
            LoadUnit loadUnit = daoFactory.getLoadUnitDAO().findById(form.getLoadUnitId(), false);
            if (loadUnit == null) {
                throw new Exception("load unit not found with id, hence can't create sub main item");
            }
            if (form.getSubMainIemId() > LitrumProjectConstants.ZERO) {
                subMainItem = daoFactory.getSubMainItemDAO().findById(form.getSubMainIemId(), false);
                if (null == subMainItem) {
                    throw new Exception("no sub main item found while update/delete");
                }
                if (LitrumProjectConstants.DELETE.equalsIgnoreCase(form.getFormSubmitType())) {
                    daoFactory.getSubMainItemDAO().makeTransient(subMainItem);
                    logger.info("sub main item deleted successfully.");
                } else if (LitrumProjectConstants.UPDATE.equalsIgnoreCase(form.getFormSubmitType()) &&
                        !daoFactory.getSubMainItemDAO().isShortDescriptionExistForSubMainItem(form.getShortDecription())) {
                    subMainItem.setShortDescription(form.getShortDecription());
                    subMainItem.setLoadUnit(loadUnit);
                    logger.info("sub main item updated successfully.");
                }
            } else {
                if (LitrumProjectConstants.ADD.equalsIgnoreCase(form.getFormSubmitType()) &&
                        !daoFactory.getSubMainItemDAO().isShortDescriptionExistForSubMainItem(form.getShortDecription())) {
                    subMainItem = new SubMainItem();
                    subMainItem.setShortDescription(form.getShortDecription());
                    subMainItem.setMainItem(mainItem);
                    subMainItem.setLoadUnit(loadUnit);
                    logger.info("sub main item created successfully.");
                    daoFactory.getSubMainItemDAO().makePersistent(subMainItem);
                } else {
                    throw new Exception("Sub Main item already exist with short decription hence, can't create new.");
                }
            }
        } else {
            throw new Exception("Main Item not found while creating sub main item.");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void createMakerOrContractorForSubMainItem(SubMainItemsForm form) throws Exception {
        if (null != form && form.getSubMainIemId() > 0) {
            SubMainItem subMainItem = daoFactory.getSubMainItemDAO().findById(form.getSubMainIemId(), false);
            if (null == subMainItem) {
                throw new Exception("Sub Main Item Not found while addding SR or CR");
            }
            if (LitrumProjectConstants.MAKER.equalsIgnoreCase(form.getSubItemType())) {
                SubMainItemMaker subMainItemMaker = new SubMainItemMaker();
                subMainItemMaker.setSubMainItem(subMainItem);
                subMainItemMaker.setSubMainItemMakerName(form.getSubMainItemMakerName());
                subMainItemMaker.setSubMainItemMakerRate(form.getSubMainItemMakerRate());
                daoFactory.getSubMainItemMakerDAO().makePersistent(subMainItemMaker);
                logger.info("maker for sub main item added successfully");
            } else if (LitrumProjectConstants.CONTRACTOR.equalsIgnoreCase(form.getSubItemType())) {
                SubMainItemContractor subMainItemContractor = new SubMainItemContractor();
                subMainItemContractor.setSubMainItem(subMainItem);
                subMainItemContractor.setSubMainItemContractorName(form.getSubMainItemContractorName());
                subMainItemContractor.setSubMainItemContractorRate(form.getSubMainItemContractorRate());
                daoFactory.getSubMainItemContractorDAO().makePersistent(subMainItemContractor);
                logger.info("contractor for sub main item added successfully");
            }
        } else {
            throw new Exception("form doesn't contains sub main item id, hnce can't proceed");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubMainItem> getAllSubMainItemsByMainItemId(Long mainItemId) throws Exception {
        if (mainItemId <= 0) {
            logger.error("invalid param passed, mainItemId:[{}]", mainItemId);
            throw new Exception("Invalid param passed");
        }
        return daoFactory.getSubMainItemDAO().findByMainItemId(mainItemId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubMainItem> findSubMainItemByMainItemIds(List<Long> mainItemIds) {
        return daoFactory.getSubMainItemDAO().findByMainItemIds(mainItemIds);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AdminUserRegistration> getAdminUserByMainCategoryId(Long mainCategoryId) throws Exception {
        if (mainCategoryId <= 0) {
            logger.error("invalid param passed, mainItemId:[{}]", mainCategoryId);
            throw new Exception("Invalid param passed");
        }
        return daoFactory.getAdminUserRegistrationDAO().findByMainCategoryId(mainCategoryId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MainItem> findMainItemsBySubSubMainCatIds(List<Long> subSubMainCatIds, String status) {
        return daoFactory.getMainItemDAO().findBySubSubMainCatIds(subSubMainCatIds, status);
    }

}
