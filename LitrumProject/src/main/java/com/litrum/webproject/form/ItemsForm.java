package com.litrum.webproject.form;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Pc on 12/04/2017.
 */
public class ItemsForm {

    private Long subSubMainCategoryId;
    private Long loadUnitId;
    private Long cityId;
    private Long mainItemId;
    private String shortDescription;
    private String longDescription;
    private String pdfFileName;
    private String imageFileName;
    private String makerName;
    private Double makerPrice;
    private String makerPriority;
    private String makerDescription;
    private String contractorName;
    private Double contractorPrice;
    private String contractorPriority;
    private String itemType;
    private String subItemForMainItem;
    private MultipartFile imageFile;
    private MultipartFile pdfFile;

    public Long getSubSubMainCategoryId() {
        return subSubMainCategoryId;
    }

    public void setSubSubMainCategoryId(Long subSubMainCategoryId) {
        this.subSubMainCategoryId = subSubMainCategoryId;
    }

    public Long getLoadUnitId() {
        return loadUnitId;
    }

    public void setLoadUnitId(Long loadUnitId) {
        this.loadUnitId = loadUnitId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getPdfFileName() {
        return pdfFileName;
    }

    public void setPdfFileName(String pdfFileName) {
        this.pdfFileName = pdfFileName;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    public Double getMakerPrice() {
        return makerPrice;
    }

    public void setMakerPrice(Double makerPrice) {
        this.makerPrice = makerPrice;
    }

    public String getMakerPriority() {
        return makerPriority;
    }

    public void setMakerPriority(String makerPriority) {
        this.makerPriority = makerPriority;
    }

    public String getMakerDescription() {
        return makerDescription;
    }

    public void setMakerDescription(String makerDescription) {
        this.makerDescription = makerDescription;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public Double getContractorPrice() {
        return contractorPrice;
    }

    public void setContractorPrice(Double contractorPrice) {
        this.contractorPrice = contractorPrice;
    }

    public String getContractorPriority() {
        return contractorPriority;
    }

    public void setContractorPriority(String contractorPriority) {
        this.contractorPriority = contractorPriority;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Long getMainItemId() {
        return mainItemId;
    }

    public void setMainItemId(Long mainItemId) {
        this.mainItemId = mainItemId;
    }

    public String getSubItemForMainItem() {
        return subItemForMainItem;
    }

    public void setSubItemForMainItem(String subItemForMainItem) {
        this.subItemForMainItem = subItemForMainItem;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public MultipartFile getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(MultipartFile pdfFile) {
        this.pdfFile = pdfFile;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("subSubMainCategoryId", subSubMainCategoryId)
                .append("loadUnitId", loadUnitId)
                .append("cityId", cityId)
                .append("shortDescription", shortDescription)
                .append("longDescription", longDescription)
                .append("pdfFileName", pdfFileName)
                .append("imageFileName", imageFileName)
                .append("makerName", makerName)
                .append("makerPrice", makerPrice)
                .append("makerPriority", makerPriority)
                .append("makerDescription", makerDescription)
                .append("contractorName", contractorName)
                .append("contractorPrice", contractorPrice)
                .append("contractorPriority", contractorPriority)
                .append("itemType", itemType)
                .append("subItemForMainItem", subItemForMainItem)
                .append("mainItemId", mainItemId)
                .toString();
    }
}
