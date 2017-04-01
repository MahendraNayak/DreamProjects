package com.litrum.webproject.dao;

import com.litrum.webproject.model.MainCategory;

import java.util.List;

/**
 * Created by Pc on 25/03/2017.
 */
public interface MainCategoryDAO extends GenericeDAO<MainCategory, Long> {

    List<MainCategory> getAllMainCategoryList();

    MainCategory findByCategoryName(String mainCategoryName);
}
