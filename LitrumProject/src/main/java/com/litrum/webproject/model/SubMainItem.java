package com.litrum.webproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by Pc on 08/04/2017.
 */
@Entity
@Table(name = "sub_main_item")
public class SubMainItem extends PersistentObject {

    private String shortDescription;
    private MainItem mainItem;
    private LoadUnit loadUnit;

    @Column(name = "short_description", length = 500)
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = MainItem.class)
    @JoinColumn(name = "main_item_id", nullable = false)
    public MainItem getMainItem() {
        return mainItem;
    }

    public void setMainItem(MainItem mainItem) {
        this.mainItem = mainItem;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = LoadUnit.class)
    @JoinColumn(name = "load_unit_id", nullable = false)
    public LoadUnit getLoadUnit() {
        return loadUnit;
    }

    public void setLoadUnit(LoadUnit loadUnit) {
        this.loadUnit = loadUnit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("shortDescription", shortDescription)
                .append("mainItem", mainItem)
                .append("loadUnit", loadUnit)
                .toString();
    }
}
