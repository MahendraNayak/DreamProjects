package com.litrum.webproject.form;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Pc on 15/04/2017.
 */
public class SubMainItemsForm {

    private Long mainItemId;
    private Long loadUnitId;
    private String shortDecription;
    private Long subMainIemId;
    private Double subMainItemMakerRate;
    private String subMainItemMakerName;
    private Double subMainItemContractorRate;
    private String subMainItemContractorName;
    private String subItemType;

    public Long getMainItemId() {
        return mainItemId;
    }

    public void setMainItemId(Long mainItemId) {
        this.mainItemId = mainItemId;
    }

    public Long getLoadUnitId() {
        return loadUnitId;
    }

    public void setLoadUnitId(Long loadUnitId) {
        this.loadUnitId = loadUnitId;
    }

    public String getShortDecription() {
        return shortDecription;
    }

    public void setShortDecription(String shortDecription) {
        this.shortDecription = shortDecription;
    }

    public Long getSubMainIemId() {
        return subMainIemId;
    }

    public void setSubMainIemId(Long subMainIemId) {
        this.subMainIemId = subMainIemId;
    }

    public Double getSubMainItemMakerRate() {
        return subMainItemMakerRate;
    }

    public void setSubMainItemMakerRate(Double subMainItemMakerRate) {
        this.subMainItemMakerRate = subMainItemMakerRate;
    }

    public String getSubMainItemMakerName() {
        return subMainItemMakerName;
    }

    public void setSubMainItemMakerName(String subMainItemMakerName) {
        this.subMainItemMakerName = subMainItemMakerName;
    }

    public Double getSubMainItemContractorRate() {
        return subMainItemContractorRate;
    }

    public void setSubMainItemContractorRate(Double subMainItemContractorRate) {
        this.subMainItemContractorRate = subMainItemContractorRate;
    }

    public String getSubMainItemContractorName() {
        return subMainItemContractorName;
    }

    public void setSubMainItemContractorName(String subMainItemContractorName) {
        this.subMainItemContractorName = subMainItemContractorName;
    }

    public String getSubItemType() {
        return subItemType;
    }

    public void setSubItemType(String subItemType) {
        this.subItemType = subItemType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("mainItemId", mainItemId)
                .append("loadUnitId", loadUnitId)
                .append("shortDecription", shortDecription)
                .append("subMainIemId", subMainIemId)
                .append("subMainItemMakerRate", subMainItemMakerRate)
                .append("subMainItemMakerName", subMainItemMakerName)
                .append("subMainItemContractorRate", subMainItemContractorRate)
                .append("subMainItemContractorName", subMainItemContractorName)
                .append("subItemType", subItemType)
                .toString();
    }
}
