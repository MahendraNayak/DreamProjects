package com.litrum.webproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by Pc on 25/03/2017.
 */
@Entity
@Table(name = "sub_main_category")
public class SubMainCategory extends PersistentObject {

    private String subMainCategoryName;
    private int activeFlag;
    private MainCategory mainCategory;

    public SubMainCategory() {
        setActiveFlag(1);
    }

    @Column(name = "sub_main_category_name", nullable = false)
    public String getSubMainCategoryName() {
        return subMainCategoryName;
    }

    public void setSubMainCategoryName(String subMainCategoryName) {
        this.subMainCategoryName = subMainCategoryName;
    }

    @Column(name = "active_flag")
    public int getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(int activeFlag) {
        this.activeFlag = activeFlag;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = MainCategory.class)
    @JoinColumn(name = "main_category_id")
    public MainCategory getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(MainCategory mainCategory) {
        this.mainCategory = mainCategory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("subMainCategoryName", subMainCategoryName)
                .append("activeFlag", activeFlag)
                .append("mainCategory", mainCategory)
                .toString();
    }
}

