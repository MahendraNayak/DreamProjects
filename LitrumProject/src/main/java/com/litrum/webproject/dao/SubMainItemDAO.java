package com.litrum.webproject.dao;

import com.litrum.webproject.model.SubMainItem;

/**
 * Created by Pc on 13/04/2017.
 */
public interface SubMainItemDAO extends GenericeDAO<SubMainItem, Long> {

    SubMainItem findSubMainItemByShortDescription(String shortDecription);
}
