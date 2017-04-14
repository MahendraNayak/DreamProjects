package com.litrum.webproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by Pc on 08/04/2017.
 */
@Entity
@Table(name = "sub_main_item_maker")
public class SubMainItemMaker extends PersistentObject {

    private String subMainItemMakerName;
    private SubMainItem subMainItem;
    private Double subMainItemMakerRate;

    @Column(name = "sub_main_item_maker_name")
    public String getSubMainItemMakerName() {
        return subMainItemMakerName;
    }

    public void setSubMainItemMakerName(String subMainItemMakerName) {
        this.subMainItemMakerName = subMainItemMakerName;
    }

    @Column(name = "sub_main_item_maker_rate")
    public Double getSubMainItemMakerRate() {
        return subMainItemMakerRate;
    }

    public void setSubMainItemMakerRate(Double subMainItemMakerRate) {
        this.subMainItemMakerRate = subMainItemMakerRate;
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
                .append("subMainItemMakerName", subMainItemMakerName)
                .append("subMainItem", subMainItem)
                .append("subMainItemMakerRate", subMainItemMakerRate)
                .toString();
    }
}
