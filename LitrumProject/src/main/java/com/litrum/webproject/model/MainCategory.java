package com.litrum.webproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Pc on 25/03/2017.
 */
@Entity
@Table(name = "main_category")
public class MainCategory extends PersistentObject {

    private String categoryName;
    private int activeFlag;

    public MainCategory() {
        setActiveFlag(1);
    }

    @Column(name = "category_name", nullable = false)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Column(name = "active_flag")
    public int getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(int activeFlag) {
        this.activeFlag = activeFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("categoryName", categoryName)
                .append("activeFlag", activeFlag)
                .toString();
    }
}
