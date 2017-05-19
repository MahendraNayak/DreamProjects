package com.litrum.webproject.dao;

import com.litrum.webproject.form.ItemsForm;
import com.litrum.webproject.model.MainItemContractor;

import java.util.List;

/**
 * Created by Pc on 13/04/2017.
 */
public interface MainItemContractorDAO extends GenericeDAO<MainItemContractor, Long> {

    List<MainItemContractor> findByMainItemAndCity(ItemsForm form);

    boolean isExistByMainItemIdAndRateCityAndMakerName(ItemsForm form);

    MainItemContractor findByMainItemAndRateCityAndMakerName(ItemsForm form);
}
