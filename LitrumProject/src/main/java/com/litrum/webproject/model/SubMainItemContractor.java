package com.litrum.webproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by Pc on 08/04/2017.
 */
@Entity
@Table(name = "sub_main_item_contractor")
public class SubMainItemContractor extends PersistentObject {

    private String subMainItemContractorName;
    private Double subMainItemContractorRate;
    private SubMainItem subMainItem;

    @Column(name = "sub_main_item_contractor_name")
    public String getSubMainItemContractorName() {
        return subMainItemContractorName;
    }

    public void setSubMainItemContractorName(String subMainItemContractorName) {
        this.subMainItemContractorName = subMainItemContractorName;
    }

    @Column(name = "sub_main_item_contractor_rate")
    public Double getSubMainItemContractorRate() {
        return subMainItemContractorRate;
    }

    public void setSubMainItemContractorRate(Double subMainItemContractorRate) {
        this.subMainItemContractorRate = subMainItemContractorRate;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = SubMainItem.class)
    @JoinColumn(name = "sub_main_item_id", nullable = false)
    public SubMainItem getSubMainItem() {
        return subMainItem;
    }

    public void setSubMainItem(SubMainItem subMainItem) {
        this.subMainItem = subMainItem;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("subMainItemContractorName", subMainItemContractorName)
                .append("subMainItemContractorRate", subMainItemContractorRate)
                .append("subMainItem", subMainItem)
                .toString();
    }
}
