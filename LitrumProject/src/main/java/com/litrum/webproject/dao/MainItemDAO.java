package com.litrum.webproject.dao;

import com.litrum.webproject.model.MainItem;

import java.util.List;

/**
 * Created by Pc on 13/04/2017.
 */
public interface MainItemDAO extends GenericeDAO<MainItem, Long> {

    MainItem findByShortDescription(String shortDescription);

    List<MainItem> findBySubSubMainCategoryId(Long subSubMainCategoryId);
}
