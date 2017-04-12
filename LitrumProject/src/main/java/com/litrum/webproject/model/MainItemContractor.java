package com.litrum.webproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by Pc on 08/04/2017.
 */
@Entity
@Table(name = "main_item_contractor")
public class MainItemContractor extends PersistentObject {

    private String contractorName;
    private String contractorPriority;
    private String contractorRate;
    private RateCity rateCity;
    private MainItem mainItem;

    @Column(name = "contractor_name")
    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    @Column(name = "contractor_priority")
    public String getContractorPriority() {
        return contractorPriority;
    }

    public void setContractorPriority(String contractorPriority) {
        this.contractorPriority = contractorPriority;
    }

    @Column(name = "contractor_rate")
    public String getContractorRate() {
        return contractorRate;
    }

    public void setContractorRate(String contractorRate) {
        this.contractorRate = contractorRate;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = RateCity.class)
    @JoinColumn(name = "rate_city_id", nullable = false)
    public RateCity getRateCity() {
        return rateCity;
    }

    public void setRateCity(RateCity rateCity) {
        this.rateCity = rateCity;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = MainItem.class)
    @JoinColumn(name = "main_item_id", nullable = false)
    public MainItem getMainItem() {
        return mainItem;
    }

    public void setMainItem(MainItem mainItem) {
        this.mainItem = mainItem;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("contractorName", contractorName)
                .append("contractorPriority", contractorPriority)
                .append("contractorRate", contractorRate)
                .append("rateCity", rateCity)
                .append("mainItem", mainItem)
                .toString();
    }
}