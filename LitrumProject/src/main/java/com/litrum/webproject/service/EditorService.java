package com.litrum.webproject.service;

import com.litrum.webproject.form.ItemsForm;
import com.litrum.webproject.form.SubMainItemsForm;
import com.litrum.webproject.model.*;

import java.util.List;

/**
 * Created by Pc on 12/04/2017.
 */
public interface EditorService {

    String getLoggedInUser();

    MainCategory findMainCatgoryByLoggedInUser();

    void createMainItem(ItemsForm form) throws Exception;

    void createMakerOrContractorForMainItem(ItemsForm form) throws Exception;

    List<MainItem> getMainItemsBySubSubMainCaegoryId(Long subSubMainCategoryId);

    List<MainItem> getMainItemsBySubSubMainCatAvailSubItems(Long subSubMainCategoryId, boolean isSubMainItemForMainItem);

    List<RateCity> getAllRateCity();

    void createSubMainItem(SubMainItemsForm form) throws Exception;

    void createMakerOrContractorForSubMainItem(SubMainItemsForm form) throws Exception;

    List<SubMainItem> getAllSubMainItemsByMainItemId(Long mainItemId) throws Exception;

    List<SubMainItem> findSubMainItemByMainItemIds(List<Long> mainItemIds);

    List<AdminUserRegistration> getAdminUserByMainCategoryId(Long mainCategoryId) throws Exception;

    List<MainItem> findMainItemsBySubSubMainCatIds(List<Long> subSubMainCatIds, String itemStatus);

    MainItem findMainItemById(ItemsForm form) throws Exception;

    long countMainItemBySubSubMainCatId(Long subSubMainCatId, String status) throws Exception;

    List<MainItemMaker> findMainItemMakerByMainItemAndCity(ItemsForm form);

    List<MainItemContractor> findMainItemContractorByMainItemAndCity(ItemsForm form);

    List<SubMainItemMaker> findSubMainItemMakerBySubMainItem(SubMainItemsForm form);

    List<SubMainItemContractor> findSubMainItemContractorBySubMainItem(SubMainItemsForm form);

    void updateMainItem(ItemsForm form) throws Exception;

    void updateMainItemIR(ItemsForm form) throws Exception;

    void updateMainItemSR(ItemsForm form) throws Exception;

    void updateSubMainItemSR(SubMainItemsForm form) throws Exception;

    void updateSubMainItemIR(SubMainItemsForm form) throws Exception;
}

