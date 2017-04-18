package com.litrum.webproject.dao;

import com.litrum.webproject.form.SubMainItemsForm;
import com.litrum.webproject.model.SubMainItemContractor;

import java.util.List;

/**
 * Created by Pc on 13/04/2017.
 */
public interface SubMainItemContractorDAO extends GenericeDAO<SubMainItemContractor, Long> {

    List<SubMainItemContractor> findBySubMainItem(SubMainItemsForm form);
}
