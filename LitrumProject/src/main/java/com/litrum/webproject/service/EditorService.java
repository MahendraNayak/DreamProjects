package com.litrum.webproject.service;

import com.litrum.webproject.form.ItemsForm;
import com.litrum.webproject.model.MainCategory;
import com.litrum.webproject.model.MainItem;
import com.litrum.webproject.model.RateCity;

import java.util.List;

/**
 * Created by Pc on 12/04/2017.
 */
public interface EditorService {

    String getLoggedInUser();

    MainCategory findMainCatgoryByLoggedInUser();

    void createMainItem(ItemsForm form) throws Exception;

    void createMakerOrContractorForMainItem(ItemsForm form) throws Exception;

    List<MainItem> getAllMainItems();

    List<RateCity> getAllRateCity();
}

