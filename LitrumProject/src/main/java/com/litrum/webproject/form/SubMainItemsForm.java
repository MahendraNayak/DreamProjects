package com.litrum.webproject.form;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Pc on 15/04/2017.
 */
public class SubMainItemsForm {

    private Long mainItemId;
    private Long loadUnitId;
    private Long subMainItemMakerId;
    private Long subMainItemContractorId;
    private String shortDecription;
    private Long subMainIemId;
    private Double subMainItemMakerRate;
    private String subMainItemMakerName;
    private Double subMainItemContractorRate;
    private String subMainItemContractorName;
    private String subItemType;
    private String formSubmitType;
    private String operationType;

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

    public String getFormSubmitType() {
        return formSubmitType;
    }

    public void setFormSubmitType(String formSubmitType) {
        this.formSubmitType = formSubmitType;
    }

    public Long getSubMainItemMakerId() {
        return subMainItemMakerId;
    }

    public void setSubMainItemMakerId(Long subMainItemMakerId) {
        this.subMainItemMakerId = subMainItemMakerId;
    }

    public Long getSubMainItemContractorId() {
        return subMainItemContractorId;
    }

    public void setSubMainItemContractorId(Long subMainItemContractorId) {
        this.subMainItemContractorId = subMainItemContractorId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
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
                .append("formSubmitType", formSubmitType)
                .toString();
    }
}
