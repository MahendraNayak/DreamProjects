package com.litrum.webproject.dao;

import com.litrum.webproject.form.SubMainItemsForm;
import com.litrum.webproject.model.SubMainItem;

import java.util.List;

/**
 * Created by Pc on 13/04/2017.
 */
public interface SubMainItemDAO extends GenericeDAO<SubMainItem, Long> {

    SubMainItem findSubMainItemByShortDescription(String shortDecription);

    List<SubMainItem> findByMainItemId(Long mainItemId);

    boolean isShortDescriptionExistForSubMainItem(SubMainItemsForm subMainItemsForm);

    List<SubMainItem> findByMainItemIds(List<Long> mainItemIds);
}
