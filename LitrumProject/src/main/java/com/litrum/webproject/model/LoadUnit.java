package com.litrum.webproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Pc on 08/04/2017.
 */
@Entity
@Table(name = "load_unit")
public class LoadUnit extends PersistentObject {

    private String unitName;

    @Column(name = "unit_name", nullable = false, unique = true)
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("unitName", unitName)
                .toString();
    }
}
