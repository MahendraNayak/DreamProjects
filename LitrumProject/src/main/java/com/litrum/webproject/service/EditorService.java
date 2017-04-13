package com.litrum.webproject.service;

import com.litrum.webproject.form.ItemsForm;
import com.litrum.webproject.model.MainCategory;

/**
 * Created by Pc on 12/04/2017.
 */
public interface EditorService {

    String getLoggedInUser();

    MainCategory findMainCatgoryByLoggedInUser();

    void createMainItem(ItemsForm form) throws Exception;

    void createMakerOrContractorForMainItem(ItemsForm form) throws Exception;
}

