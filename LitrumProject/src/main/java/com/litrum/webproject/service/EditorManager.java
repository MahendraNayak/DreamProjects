package com.litrum.webproject.service;

import com.litrum.webproject.Utils.HIbernateUtils;
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
                MainItemMaker mainItemMaker = daoFactory.getMainItemMakerDAO().findByMainItemAndRateCityAndMakerName(form);
                if (LitrumProjectConstants.ADD.equalsIgnoreCase(form.getOperationType())) {
                    if (null == mainItemMaker) {
                        mainItemMaker = new MainItemMaker();
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
                    } else {
                        throw new Exception("Maker already exist with name");
                    }
                } else if (LitrumProjectConstants.UPDATE.equalsIgnoreCase(form.getOperationType())) {
                    mainItemMaker = daoFactory.getMainItemMakerDAO().findById(form.getMakerId(), false);
                    if (null != mainItemMaker) {
                        if (!mainItemMaker.getMakerName().equalsIgnoreCase(form.getMakerName())
                                && !daoFactory.getMainItemMakerDAO().isExistByMainItemIdAndRateCityAndMakerName(form)) {
                            mainItemMaker.setMakerName(form.getMakerName());
                        }
                        mainItemMaker.setMakerRate(form.getMakerPrice());
                        mainItemMaker.setMakerPriority(form.getMakerPriority());
                    } else {
                        throw new Exception("Maker not found while update.");
                    }
                }
            }
            if (LitrumProjectConstants.CONTRACTOR.equalsIgnoreCase(form.getItemType())) {
                MainItemContractor mainItemContractor = daoFactory.getMainItemContractorDAO().findByMainItemAndRateCityAndMakerName(form);
                if (LitrumProjectConstants.ADD.equalsIgnoreCase(form.getOperationType())) {
                    if (null == mainItemContractor) {
                        mainItemContractor = new MainItemContractor();
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
                    } else {
                        throw new Exception("Contractor already exist with name");
                    }
                } else if (LitrumProjectConstants.UPDATE.equalsIgnoreCase(form.getOperationType())) {
                    mainItemContractor = daoFactory.getMainItemContractorDAO().findById(form.getContractorId(), false);
                    if (null != mainItemContractor) {
                        if (!mainItemContractor.getContractorName().equalsIgnoreCase(form.getContractorName())
                                && !daoFactory.getMainItemContractorDAO().isExistByMainItemIdAndRateCityAndMakerName(form)) {
                            mainItemContractor.setContractorName(form.getContractorName());
                        }
                        mainItemContractor.setContractorRate(form.getContractorPrice());
                        mainItemContractor.setContractorPriority(form.getContractorPriority());
                    } else {
                        throw new Exception("Contractor not found while update.");
                    }
                }
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
    public List<MainItem> getMainItemsBySubSubMainCatAvailSubItems(Long subSubMainCategoryId, boolean isSubMainItemForMainItem) {
        return daoFactory.getMainItemDAO().findBySubSubMainCatAvailItem(subSubMainCategoryId, isSubMainItemForMainItem);
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
                        !daoFactory.getSubMainItemDAO().isShortDescriptionExistForSubMainItem(form)) {
                    subMainItem.setShortDescription(form.getShortDecription());
                    subMainItem.setLoadUnit(loadUnit);
                    logger.info("sub main item updated successfully.");
                }
            } else {
                if (LitrumProjectConstants.ADD.equalsIgnoreCase(form.getFormSubmitType()) &&
                        !daoFactory.getSubMainItemDAO().isShortDescriptionExistForSubMainItem(form)) {
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
                if (LitrumProjectConstants.ADD.equalsIgnoreCase(form.getOperationType())) {
                    if (!daoFactory.getSubMainItemMakerDAO().isExistBySubMainItemAndMakerName(form)) {
                        SubMainItemMaker subMainItemMaker = new SubMainItemMaker();
                        subMainItemMaker.setSubMainItem(subMainItem);
                        subMainItemMaker.setSubMainItemMakerName(form.getSubMainItemMakerName());
                        subMainItemMaker.setSubMainItemMakerRate(form.getSubMainItemMakerRate());
                        daoFactory.getSubMainItemMakerDAO().makePersistent(subMainItemMaker);
                        logger.info("maker for sub main item added successfully");
                    } else {
                        throw new Exception("Maker already exist with name");
                    }
                } else if (LitrumProjectConstants.UPDATE.equalsIgnoreCase(form.getOperationType())) {
                    SubMainItemMaker subMainItemMaker = daoFactory.getSubMainItemMakerDAO().findById(form.getSubMainItemMakerId(), false);
                    if (null != subMainItemMaker) {
                        if (!subMainItemMaker.getSubMainItemMakerName().equalsIgnoreCase(form.getSubMainItemMakerName())
                                && !daoFactory.getSubMainItemMakerDAO().isExistBySubMainItemAndMakerName(form)) {
                            subMainItemMaker.setSubMainItemMakerName(form.getSubMainItemMakerName());
                        }
                        subMainItemMaker.setSubMainItemMakerRate(form.getSubMainItemMakerRate());
                    } else {
                        throw new Exception("Maker Already exist with name hence can't update.");
                    }
                }
            } else if (LitrumProjectConstants.CONTRACTOR.equalsIgnoreCase(form.getSubItemType())) {
                if (LitrumProjectConstants.ADD.equalsIgnoreCase(form.getOperationType())) {
                    if (!daoFactory.getSubMainItemContractorDAO().isExistBySubMainItemAndContractorName(form)) {
                        SubMainItemContractor subMainItemContractor = new SubMainItemContractor();
                        subMainItemContractor.setSubMainItem(subMainItem);
                        subMainItemContractor.setSubMainItemContractorName(form.getSubMainItemContractorName());
                        subMainItemContractor.setSubMainItemContractorRate(form.getSubMainItemContractorRate());
                        daoFactory.getSubMainItemContractorDAO().makePersistent(subMainItemContractor);
                        logger.info("contractor for sub main item added successfully");
                    } else {
                        throw new Exception("Contractor already exist with name");
                    }
                } else if (LitrumProjectConstants.UPDATE.equalsIgnoreCase(form.getOperationType())) {
                    SubMainItemContractor subMainItemContractor = daoFactory.getSubMainItemContractorDAO().findById(form.getSubMainItemContractorId(), false);
                    if (null != subMainItemContractor) {
                        if (!subMainItemContractor.getSubMainItemContractorName().equalsIgnoreCase(form.getSubMainItemContractorName())
                                && !daoFactory.getSubMainItemContractorDAO().isExistBySubMainItemAndContractorName(form)) {
                            subMainItemContractor.setSubMainItemContractorName(form.getSubMainItemContractorName());
                        }
                        subMainItemContractor.setSubMainItemContractorRate(form.getSubMainItemContractorRate());
                    } else {
                        throw new Exception("Contractor already with this name hence cant update.");
                    }
                }
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

    @Override
    @Transactional(readOnly = true)
    public MainItem findMainItemById(ItemsForm form) throws Exception {
        if (form.getMainItemId() <= 0) {
            logger.error("invalid param passed, mainItemId:[{}]", form.getMainItemId());
            throw new Exception("Invalid param passed");
        }
        return HIbernateUtils.unproxy(daoFactory.getMainItemDAO().findById(form.getMainItemId(), false));
    }

    @Override
    @Transactional(readOnly = true)
    public long countMainItemBySubSubMainCatId(Long subSubMainCatId, String status) throws Exception {
        if (subSubMainCatId <= 0) {
            logger.error("invalid param passed, subSubMainCatId:[{}]", subSubMainCatId);
            throw new Exception("Invalid param passed");
        }
        return daoFactory.getMainItemDAO().countMainItemBySubSubMainCatId(subSubMainCatId, status);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MainItemMaker> findMainItemMakerByMainItemAndCity(ItemsForm form) {
        return daoFactory.getMainItemMakerDAO().findByMainItemAndCity(form);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MainItemContractor> findMainItemContractorByMainItemAndCity(ItemsForm form) {
        return daoFactory.getMainItemContractorDAO().findByMainItemAndCity(form);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubMainItemMaker> findSubMainItemMakerBySubMainItem(SubMainItemsForm form) {
        return daoFactory.getSubMainItemMakerDAO().findBySubMainItem(form);

    }

    @Override
    @Transactional(readOnly = true)
    public List<SubMainItemContractor> findSubMainItemContractorBySubMainItem(SubMainItemsForm form) {
        return daoFactory.getSubMainItemContractorDAO().findBySubMainItem(form);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void updateMainItem(ItemsForm form) throws Exception {
        if (null != form && form.getMainItemId() > LitrumProjectConstants.ZERO) {
            MainItem mainItem = daoFactory.getMainItemDAO().findById(form.getMainItemId(), false);

            boolean hasCallFunction = false;

            if (null != mainItem && ((mainItem.getShortDescription()).equalsIgnoreCase(form.getShortDescription()))) {
                hasCallFunction = true;
            } else if (null != mainItem && !((mainItem.getShortDescription()).equalsIgnoreCase(form.getShortDescription()))) {
                hasCallFunction = !daoFactory.getMainItemDAO().isMainItemExistByShortDescripton(form.getShortDescription());
            }

            if (null != mainItem && hasCallFunction) {
                mainItem.setShortDescription(form.getShortDescription());
                mainItem.setLongDescription(form.getLongDescription());
                if (LitrumProjectConstants.YES.equalsIgnoreCase(form.getSubItemForMainItem())) {
                    mainItem.setSubMainItemForMainItem(true);
                } else {
                    mainItem.setSubMainItemForMainItem(false);
                }

                LoadUnit loadUnit = daoFactory.getLoadUnitDAO().findById(form.getLoadUnitId(), false);
                if (null != loadUnit) {
                    mainItem.setLoadUnit(loadUnit);
                } else {
                    throw new Exception("Load unit not found while updating main item");
                }
            } else {
                throw new Exception("No main item found for update");
            }
        } else {
            throw new Exception("Main item Id not found while updating main item");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void updateMainItemIR(ItemsForm form) throws Exception {
        if (null != form && form.getContractorId() > LitrumProjectConstants.ZERO) {
            MainItemContractor mainItemContractor = daoFactory.getMainItemContractorDAO().findById(form.getContractorId(), false);
            if (null != mainItemContractor && !daoFactory.getMainItemContractorDAO().isExistByMainItemIdAndRateCityAndMakerName(form)) {
                mainItemContractor.setContractorName(form.getContractorName());
                mainItemContractor.setContractorRate(form.getContractorPrice());
                mainItemContractor.setContractorPriority(form.getContractorPriority());
                logger.info("Main item contractor updated successfully.");
            } else {
                throw new Exception("Main Item contractor already exist with name");
            }
        } else {
            throw new Exception("Main item contractor id not found while update main item contractor");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void updateMainItemSR(ItemsForm form) throws Exception {
        if (null != form && form.getMakerId() > LitrumProjectConstants.ZERO) {
            MainItemMaker mainItemMaker = daoFactory.getMainItemMakerDAO().findById(form.getMakerId(), false);
            if (null != mainItemMaker && !daoFactory.getMainItemMakerDAO().isExistByMainItemIdAndRateCityAndMakerName(form)) {
                mainItemMaker.setMakerName(form.getMakerName());
                mainItemMaker.setMakerRate(form.getMakerPrice());
                mainItemMaker.setMakerPriority(form.getMakerPriority());
                logger.info("Main item maker updated successfully.");
            } else {
                throw new Exception("Main Item maker already exist with name");
            }
        } else {
            throw new Exception("Main item maker id not found while update main item maker");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void updateSubMainItemSR(SubMainItemsForm form) throws Exception {
        if (null != form && form.getSubMainItemMakerId() > LitrumProjectConstants.ZERO) {
            SubMainItemMaker subMainItemMaker = daoFactory.getSubMainItemMakerDAO().findById(form.getSubMainItemMakerId(), false);
            if (null != subMainItemMaker && !daoFactory.getSubMainItemMakerDAO().isExistBySubMainItemAndMakerName(form)) {
                subMainItemMaker.setSubMainItemMakerName(form.getSubMainItemMakerName());
                subMainItemMaker.setSubMainItemMakerRate(form.getSubMainItemMakerRate());
                logger.info("Sub Main item maker updated successfully.");
            } else {
                throw new Exception("Maker already exist with name");
            }
        } else {
            throw new Exception("Sub Main item maker id not found while update sub main item maker");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void updateSubMainItemIR(SubMainItemsForm form) throws Exception {
        if (null != form && form.getSubMainItemContractorId() > LitrumProjectConstants.ZERO) {
            SubMainItemContractor subMainItemContractor = daoFactory.getSubMainItemContractorDAO().findById(form.getSubMainItemContractorId(), false);
            if (null != subMainItemContractor && !daoFactory.getSubMainItemContractorDAO().isExistBySubMainItemAndContractorName(form)) {
                subMainItemContractor.setSubMainItemContractorName(form.getSubMainItemContractorName());
                subMainItemContractor.setSubMainItemContractorRate(form.getSubMainItemContractorRate());
                logger.info("Sub Main item contractor updated successfully.");
            } else {
                throw new Exception("Contractor already exist with name");
            }
        } else {
            throw new Exception("Sub Main item contractor id not found while update sub main item contractor");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<MainItemMaker> getMainItemMakersByMainItemId(ItemsForm itemsForm) throws Exception {
        return daoFactory.getMainItemMakerDAO().findMakerListByMainItemId(itemsForm);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MainItemContractor> getMainItemContractorsByMainItemId(ItemsForm itemsForm) throws Exception {
        return daoFactory.getMainItemContractorDAO().findContractorListByMainItemId(itemsForm);
    }
}
