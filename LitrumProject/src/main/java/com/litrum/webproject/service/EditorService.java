package com.litrum.webproject.service;

import com.litrum.webproject.model.MainCategory;

/**
 * Created by Pc on 12/04/2017.
 */
public interface EditorService {

    String getLoggedInUser();

    MainCategory findMainCatgoryByLoggedInUser();

}

