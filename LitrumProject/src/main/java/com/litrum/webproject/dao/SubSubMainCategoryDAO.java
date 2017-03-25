package com.litrum.webproject.dao;

import com.litrum.webproject.model.SubMainCategory;
import com.litrum.webproject.model.SubSubMainCategory;

import java.util.List;

/**
 * Created by Pc on 25/03/2017.
 */
public interface SubSubMainCategoryDAO extends GenericeDAO<SubSubMainCategory, Long> {

    List<SubSubMainCategory> findBySubMainCategory(SubMainCategory subMainCategory);
}
