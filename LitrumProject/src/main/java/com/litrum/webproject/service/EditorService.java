package com.litrum.webproject.service;

import com.litrum.webproject.form.ItemsForm;
import com.litrum.webproject.form.SubMainItemsForm;
import com.litrum.webproject.model.MainCategory;
import com.litrum.webproject.model.MainItem;
import com.litrum.webproject.model.RateCity;
import com.litrum.webproject.model.SubMainItem;

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

    List<RateCity> getAllRateCity();

    void createSubMainItem(SubMainItemsForm form) throws Exception;

    void createMakerOrContractorForSubMainItem(SubMainItemsForm form) throws Exception;

    List<SubMainItem> getAllSubMainItemsByMainItemId(Long mainItemId) throws Exception;
}

