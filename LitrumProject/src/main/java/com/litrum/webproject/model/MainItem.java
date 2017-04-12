package com.litrum.webproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by Pc on 08/04/2017.
 */
@Entity
@Table(name = "main_item")
public class MainItem extends PersistentObject {

    private SubSubMainCategory subSubMainCategory;
    private String mainItemName;
    private String shortDescription;
    private String longDescription;
    private String techSpecificationName;
    private String imageName;
    private LoadUnit loadUnit;

    @Column(name = "main_item_name")
    public String getMainItemName() {
        return mainItemName;
    }

    public void setMainItemName(String mainItemName) {
        this.mainItemName = mainItemName;
    }

    @Column(name = "short_description", length = 500)
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Column(name = "long_description", length = 2000)
    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Column(name = "tech_spec_name")
    public String getTechSpecificationName() {
        return techSpecificationName;
    }

    public void setTechSpecificationName(String techSpecificationName) {
        this.techSpecificationName = techSpecificationName;
    }

    @Column(name = "image_name")
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = LoadUnit.class)
    @JoinColumn(name = "load_unit_id", nullable = false)
    public LoadUnit getLoadUnit() {
        return loadUnit;
    }

    public void setLoadUnit(LoadUnit loadUnit) {
        this.loadUnit = loadUnit;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = SubSubMainCategory.class)
    @JoinColumn(name = "sub_sub_main_categoryId", nullable = false)
    public SubSubMainCategory getSubSubMainCategory() {
        return subSubMainCategory;
    }

    public void setSubSubMainCategory(SubSubMainCategory subSubMainCategory) {
        this.subSubMainCategory = subSubMainCategory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("mainItemName", mainItemName)
                .append("shortDescription", shortDescription)
                .append("longDescription", longDescription)
                .append("techSpecificationName", techSpecificationName)
                .append("imageName", imageName)
                .append("loadUnit", loadUnit)
                .toString();
    }
}
