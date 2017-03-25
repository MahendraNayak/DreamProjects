package com.litrum.webproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by Pc on 25/03/2017.
 */
@Entity
@Table(name = "sub_sub_main_category")
public class SubSubMainCategory extends PersistentObject {

    private String subSubMainCategoryName;
    private int activeFlag;
    private SubMainCategory subMainCategory;

    public SubSubMainCategory() {
        setActiveFlag(1);
    }

    @Column(name = "sub_sub_main_category_name", nullable = false)
    public String getSubSubMainCategoryName() {
        return subSubMainCategoryName;
    }

    public void setSubSubMainCategoryName(String subSubMainCategoryName) {
        this.subSubMainCategoryName = subSubMainCategoryName;
    }

    @Column(name = "active_flag")
    public int getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(int activeFlag) {
        this.activeFlag = activeFlag;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = SubMainCategory.class)
    @JoinColumn(name = "sub_main_category_id")
    public SubMainCategory getSubSubMainCategory() {
        return subMainCategory;
    }

    public void setSubSubMainCategory(SubMainCategory subMainCategory) {
        this.subMainCategory = subMainCategory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("subSubMainCategoryName", subSubMainCategoryName)
                .append("activeFlag", activeFlag)
                .append("subMainCategory", subMainCategory)
                .toString();
    }
}
