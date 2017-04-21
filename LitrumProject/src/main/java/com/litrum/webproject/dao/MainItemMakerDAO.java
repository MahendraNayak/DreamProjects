package com.litrum.webproject.dao;

import com.litrum.webproject.form.ItemsForm;
import com.litrum.webproject.model.MainItemMaker;

import java.util.List;

/**
 * Created by Pc on 13/04/2017.
 */
public interface MainItemMakerDAO extends GenericeDAO<MainItemMaker, Long> {

    List<MainItemMaker> findByMainItemAndCity(ItemsForm form);

    boolean isExistByMainItemIdAndRateCityAndMakerName(ItemsForm form);
}
