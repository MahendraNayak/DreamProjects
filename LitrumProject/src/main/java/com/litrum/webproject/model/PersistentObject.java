package com.litrum.webproject.model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class PersistentObject {
    protected Long id = null;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("unused")
    private void setId(final Long id) {
        this.id = id;
    }

}
