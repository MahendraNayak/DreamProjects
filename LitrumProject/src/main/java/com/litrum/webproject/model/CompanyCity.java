package com.litrum.webproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Pc on 25/03/2017.
 */
@Entity
@Table(name = "company_city")
public class CompanyCity extends PersistentObject {

    private String cityName;

    @Column(name = "city_name", nullable = false, unique = true)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("cityName", cityName)
                .toString();
    }
}
