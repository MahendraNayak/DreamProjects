package com.litrum.webproject.dao;

import com.litrum.webproject.model.MainCategory;
import com.litrum.webproject.model.SubMainCategory;

import java.util.List;


/**
 * Created by Pc on 25/03/2017.
 */
public interface SubMainCategoryDAO extends GenericeDAO<SubMainCategory, Long> {

    List<SubMainCategory> findByMainCategory(MainCategory mainCategory);

    SubMainCategory findBySubCategoryName(String subMainCategoryName);
}
