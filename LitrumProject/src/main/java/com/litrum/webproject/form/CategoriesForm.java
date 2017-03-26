package com.litrum.webproject.form;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Pc on 26/03/2017.
 */
public class CategoriesForm {

    private String mainCategoryName;
    private Long mainCategoryId;
    private String subMainCategoryName;
    private Long subMainCategoryId;
    private String subSubMainCategoryName;

    public String getMainCategoryName() {
        return mainCategoryName;
    }

    public void setMainCategoryName(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }

    public Long getMainCategoryId() {
        return mainCategoryId;
    }

    public void setMainCategoryId(Long mainCategoryId) {
        this.mainCategoryId = mainCategoryId;
    }

    public String getSubMainCategoryName() {
        return subMainCategoryName;
    }

    public void setSubMainCategoryName(String subMainCategoryName) {
        this.subMainCategoryName = subMainCategoryName;
    }

    public Long getSubMainCategoryId() {
        return subMainCategoryId;
    }

    public void setSubMainCategoryId(Long subMainCategoryId) {
        this.subMainCategoryId = subMainCategoryId;
    }

    public String getSubSubMainCategoryName() {
        return subSubMainCategoryName;
    }

    public void setSubSubMainCategoryName(String subSubMainCategoryName) {
        this.subSubMainCategoryName = subSubMainCategoryName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("mainCategoryName", mainCategoryName)
                .append("mainCategoryId", mainCategoryId)
                .append("subMainCategoryName", subMainCategoryName)
                .append("subMainCategoryId", subMainCategoryId)
                .append("subSubMainCategoryName", subSubMainCategoryName)
                .toString();
    }
}
