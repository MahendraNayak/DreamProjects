package com.litrum.webproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by Pc on 21/03/2017.
 */
@Entity
@Table(name = "company_type")
public class CompanyType extends PersistentObject {

    private String type;
    private ServiceOffered serviceOffered;

    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ServiceOffered.class)
    @JoinColumn(name = "service_offered_id", nullable = false)
    public ServiceOffered getServiceOffered() {
        return serviceOffered;
    }

    public void setServiceOffered(ServiceOffered serviceOffered) {
        this.serviceOffered = serviceOffered;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .append("serviceOffered", serviceOffered)
                .toString();
    }
}
