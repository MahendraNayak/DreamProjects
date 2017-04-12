package com.litrum.webproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by Pc on 08/04/2017.
 */
@Entity
@Table(name = "main_item_maker")
public class MainItemMaker extends PersistentObject {

    private String makerName;
    private String makerPriority;
    private Double makerRate;
    private RateCity rateCity;
    private MainItem mainItem;

    @Column(name = "maker_name")
    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    @Column(name = "maker_priority")
    public String getMakerPriority() {
        return makerPriority;
    }

    public void setMakerPriority(String makerPriority) {
        this.makerPriority = makerPriority;
    }

    @Column(name = "maker_rate")
    public Double getMakerRate() {
        return makerRate;
    }

    public void setMakerRate(Double makerRate) {
        this.makerRate = makerRate;
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
                .append("makerName", makerName)
                .append("makerPriority", makerPriority)
                .append("makerRate", makerRate)
                .append("rateCity", rateCity)
                .append("mainItem", mainItem)
                .toString();
    }
}
