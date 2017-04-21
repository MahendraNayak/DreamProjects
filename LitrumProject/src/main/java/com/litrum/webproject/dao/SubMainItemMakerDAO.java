package com.litrum.webproject.dao;

import com.litrum.webproject.form.SubMainItemsForm;
import com.litrum.webproject.model.SubMainItemMaker;

import java.util.List;

/**
 * Created by Pc on 13/04/2017.
 */
public interface SubMainItemMakerDAO extends GenericeDAO<SubMainItemMaker, Long> {

    List<SubMainItemMaker> findBySubMainItem(SubMainItemsForm form);

    boolean isExistBySubMainItemAndMakerName(SubMainItemsForm form);
}
